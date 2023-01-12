package GenData;
import Util.TxtReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxScaler {
    public static void main(String[] args) {
        int[][] D111 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS
        int[][] D112 = new int[5][3];
        int[][] D121 = new int[5][3];
        int[][] D122 = new int[5][3];

        float[][] researchIndex = new float[5][3];
        float[][] applicationIndex = new float[5][3];

        // D-111
        readAndFill("D-111.csv", D111);
        float[][] D111Scaled = minMaxScaler(D111);
        saveAsFile("D-111_scaled.csv", D111Scaled);

        // D-112
        readAndFill("D-112.csv", D111);
        float[][] D112Scaled = minMaxScaler(D111);
        saveAsFile("D-112_scaled.csv", D112Scaled);

        // D-121
        readAndFill("D-121.csv", D111);
        float[][] D121Scaled = minMaxScaler(D111);
        saveAsFile("D-121_scaled.csv", D121Scaled);

        // D-122
        readAndFill("D-122.csv", D111);
        float[][] D122Scaled = minMaxScaler(D111);
        saveAsFile("D-122_scaled.csv", D121Scaled);

        calLevel1(researchIndex, D111Scaled, D112Scaled);
        saveAsFile("researchIndex.csv", researchIndex);

        calLevel1(applicationIndex, D121Scaled, D122Scaled);
        saveAsFile("applicationIndex.csv", applicationIndex);

    }

    /**
     * general method for Level1 with two subLevels
     * @param resContainer: [5][3]
     * @param level2A: subLevel1
     * @param level2B: subLevel2
     */
    static public void calLevel1(float[][] resContainer, float[][] level2A, float[][] level2B) {
        for (int i=0; i < 5; i++) {
            for (int j=0; j<3; j++) {
                resContainer[i][j] = (level2A[i][j] + level2B[i][j])/2;
            }
        }
    }
    /**
     * save File，但是好像应该用多态
     * @param path: String file path
     * @param resContainer: float[][]
     */
    public static void saveAsFile(String path, float[][] resContainer) {
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
     * read csv and fill [5][3] array
     * @param path: file path
     * @param resContainer: array[][]
     */
    public static void readAndFill(String path, int[][] resContainer) {
        ArrayList<String> full = TxtReader.read(path);
        for (int i = 1; i < 6; i++) {
            String[] lineSplit = full.get(i).split(",");
            for (int j = 1; j < 4; j ++) {
                resContainer[i-1][j-1] = Integer.parseInt(lineSplit[j]);
            }
        }
    }

    /**
     * min-max scaler for [5][3] array (on each col)
     * @param resContainer: target array[][]
     * @return result scaled
     */
    public static float[][] minMaxScaler(int[][] resContainer) {
        float[][] scaled = new float[5][3];
        for (int i = 0; i < 3; i ++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                col.add(resContainer[j][i]);
            }
            float min = (float) Collections.min(col);
            float max = (float) Collections.max(col);
            List<Float> newCol = new ArrayList<>();
            for (int j = 0; j< 5; j++) {
                int temp = col.get(j);
                float newTemp = (temp - min)/(max - min);
                newCol.add(newTemp);
            }
            addCol(scaled, newCol, i);
        }
        return scaled;
    }

    /**
     * add col to [5][3] array
     * @param array target array
     * @param col one column
     * @param ind column index
     */
    public static void addCol(float[][] array, List<Float> col, int ind) {
        for (int i =0;i<5;i++) {
            array[i][ind] = col.get(i);
        }
    }

}
