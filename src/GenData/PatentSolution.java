package GenData;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import util.ExcelReader;

import java.io.IOException;
import java.util.Arrays;

import static GenData.ArticlesSolution.saveAsFile;

public class PatentSolution {
    public static void main(String[] args) throws BiffException, IOException {
        Sheet patents = ExcelReader.read("requirements/专利数据.xls", 0);

        // D-121 专利申请数量
        int[][] d121 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS
        // D-122 专利授权量
        int[][] d122 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS

        int rowCnt = patents.getRows();
        for (int r=1; r< rowCnt; r++) { // skip title
            String applicationYear = getYear(patents.getCell(2, r).getContents());
            String authorizationYear = getYear(patents.getCell(3,r).getContents());
            String[] addressInfo = patents.getCell(4,r).getContents().split("\\|");
            int i = yearCheck(applicationYear);
            if (i != 9) calD(d121, addressInfo, i);
            int j1 = yearCheck(authorizationYear);
            if (j1 != 9) calD(d122, addressInfo, j1);
        }

        saveAsFile("D-121.csv", d121);
        saveAsFile("D-122.csv", d122);
    }

    /**
     * general method to cal D-121, D-122
     * @param resContainer: int[][] to store results
     * @param addressInfo: String[] with country info
     * @param j: year index
     */
    public static void calD(int[][] resContainer, String[] addressInfo, int j){
        for (String a : addressInfo) {
            int i = countryCheck(a);
            if (i != 9) resContainer[i][j] += 1;
        }
    }

    /**
     * get year from yyyy-mm-dd
     * @param date:String yyyy-mm-dd
     * @return "", "yyyy"
     */
    public static String getYear(String date) {
        if (date.length() >= 4){
            return date.substring(0,4);
        }
        return "";
    }

    /**
     * check year, between 2019-2021
     * @param year: String extracted from yyyy-mm-dd
     * @return int, 012 for valid index, 9 for invalid year
     */
    public static int yearCheck(String year) {
        return switch (year) {
            case "2019" -> 0;
            case "2020" -> 1;
            case "2021" -> 2;
            default -> 9;
        };
    }

    /**
     * check country, among 中英法美俄
     * @param one: String one piece of country info
     * @return 0-4 for valid country index, 9 for invalid country
     */
    public static int countryCheck(String one) {
        if (one.contains("CN")) return 0;
        else if (one.contains("GB")) {
            return 1;
        } else if (one.contains("FR")) {
            return 2;
        } else if (one.contains("US")) {
            return 3;
        } else if (one.contains("RU")) {
            return 4;
        } else return 9;
    }

}
