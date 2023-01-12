package GenData;
import Util.TxtReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 专利指标D-111和D-112的计算方式
 */


public class ArticlesSolution {
    public static void main(String[] args) {
        ArrayList<String> full = getFullDataset();
        Map<String, Integer> authorCnt = new HashMap<>(); // TODO: 作者消歧问题
        Set<String> authorCache = new HashSet<>();
//        Map<String, Set<String>> authorCache = new HashMap<>();
//        authorCache.put("2019", new HashSet<>());
//        authorCache.put("2020", new HashSet<>());
//        authorCache.put("2021", new HashSet<>());
        // D-111 顶级学者人口数量
        int[][] d111 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS
        // D-112 论文产出量
        int[][] d112 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS


        for (String line : full){
            String[] splits = line.split("\t");
            // Adress --> splits[24]
            // Year --> splits[46]
            calD111(d111, authorCnt, authorCache, splits);
            calD112(d112, splits);
        }
        // 对于d111每一行都是相较于前一年新增的顶级学者数量，因此再遍历一遍加上前面的基数
        for(int row=0;row<5;row++) {
            int one = d111[row][0];
            d111[row][1] += one;
            d111[row][2] += d111[row][1];
        }
        saveAsFile("D-111.csv", d111);
        saveAsFile("D-112.csv", d112);

    }

    /**
     * save ArrayList as csv File
     * @param path: String, Target path
     * @param resContainer: ArrayList
     */
    public static void saveAsFile(String path, int[][] resContainer) {
        String[] countries = {"中国", "英国", "法国", "美国", "俄国"};
        String[] years = {"国家", "2019", "2020", "2021"};
        try{
            File file =new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            fileWriter.write(String.join(",", years)+"\n");
            for (int i=0; i<5; i++){
                fileWriter.write(countries[i]+",");
                for (int j=0; j<2; j++){
                    fileWriter.write(resContainer[i][j] + ",");
                }
                fileWriter.write(resContainer[i][2]+"\n");
            }
            fileWriter.close();
            System.out.println("finish");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * pick out lines that among 5 countries & between 2019 and 2021
     * @param year: year info in splits
     * @param country: country info picked out by checkCountry
     * @return resContainer index [i][j], if not qualified then return []
     */
    public static int[] dataFilter(String year, String country) {
        int i; int j;
        switch (country) {
            case "PRC":
                i = 0;
                switch ( year ){
                    case "2019":
                        j = 0; break;
                    case "2020":
                        j = 1; break;
                    case "2021":
                        j = 2; break;
                    default: return new int[]{};
                }
                break;
            case "ENG":
                i = 1;
                switch ( year ){
                    case "2019":
                        j = 0; break;
                    case "2020":
                        j = 1; break;
                    case "2021":
                        j = 2; break;
                    default: return new int[]{};
                }
                break;
            case "FRA":
                i = 2;
                switch ( year ){
                    case "2019":
                        j = 0; break;
                    case "2020":
                        j = 1; break;
                    case "2021":
                        j = 2; break;
                    default: return new int[]{};
                }
                break;
            case "USA":
                i = 3;
                switch ( year ){
                    case "2019":
                        j = 0; break;
                    case "2020":
                        j = 1; break;
                    case "2021":
                        j = 2; break;
                    default: return new int[]{};
                }
                break;
            case "RUS":
                i = 4;
                switch ( year ){
                    case "2019":
                        j = 0; break;
                    case "2020":
                        j = 1; break;
                    case "2021":
                        j = 2; break;
                    default: return new int[]{};
                }
                break;
            default: return new int[]{};
        }
        return new int[]{i, j};
    }

    /**
     * calculate D-111
     * @param resContainer ArrayList
     * @param authorCnt {author: int }
     * @param authorCache {year: {authors}}
     * @param splits line cut
     */
    public static void calD111(int[][] resContainer, Map<String, Integer> authorCnt, Set<String> authorCache, String[] splits){
        String[] authors = splits[1].split("; ");
        String year = splits[46];
        String country = countryCheck(splits[24]);
        int i;int j;
        int[] resPos = dataFilter(year, country);
        if (resPos.length == 2) {
            i = resPos[0];
            j = resPos[1];
        }else {
            return;
        }
        // 年份和国家都满足要求

        for (String a : authors) {
            if (authorCnt.containsKey(a)) { // 如果当前作品的作者在所有作者发文量计数中
                int cnt = authorCnt.get(a); // 取出该作者的发文量计数
                cnt += 1;
                authorCnt.put(a, cnt); // 更新发文量
                if (cnt >= 2){  // 至少发文两篇，满足高被引资格
                    if (authorCache.contains(a)) return;  // 该作者已经被记录
                    else {
                        authorCache.add(a);
                        resContainer[i][j] += 1;
                    }
                }
            }
            else {
                authorCnt.put(a,1);
            }
        }

    }
    /**
     * calculate D-112
     * @param resContainer Array int[country][year]
     * @param splits Array String
     */
    public static void calD112(int[][] resContainer, String[]splits) {

        String country = countryCheck(splits[24]);
        String year = splits[46];
        int[] resPos = dataFilter(year, country);
        if (resPos.length == 2){
            int i = resPos[0];
            int j = resPos[1];
            resContainer[i][j] += 1;
        }
    }
    /**
     * read full dataset from requirements using TxtReader Tool
     * @return full data lines: ArrayList<String>
     */
    public static ArrayList<String> getFullDataset() {
        ArrayList<String> full = new ArrayList<>();
        for(int i =1;i<=6;i++){
            String nowPath = "requirements/信息化高被引论文/数据"+i+".txt";
            ArrayList<String> dataFraction = TxtReader.read(nowPath);
            // add to full except headline
            full.addAll(dataFraction.subList(1,dataFraction.size()));
        }
        return full;
    }


    /**
     * get qualified country from country info string
     * @param lineRP: col RP
     * @return countryName or Other
     */
    public static String countryCheck(String lineRP) {
        lineRP = lineRP.split(";")[0].toLowerCase(); // 第一个通讯作者
        if (lineRP.contains("china") || lineRP.contains("chinese")){
            return "PRC";
        } else if (lineRP.contains("usa") || lineRP.contains("america") || lineRP.contains("united states")) {
            return "USA";
        } else if (lineRP.contains("france") || lineRP.contains("fr.") || lineRP.contains(" fr ")) {
            return "FRA";
        } else if (lineRP.contains("england") || lineRP.contains("united kingdom") || lineRP.contains(" uk ")) {
            return "ENG";
        } else if (lineRP.contains("russia") || lineRP.contains(" ru ")) {
            return "RUS";
        }else return "Other";
    }
}
