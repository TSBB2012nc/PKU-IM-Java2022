package GenData;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import util.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;

public class PatentSolution {
    public static void main(String[] args) throws BiffException, IOException {
        Workbook patents = ExcelReader.read("requirements/专利数据.xls");
        System.out.println(patents);

        // D-121 专利申请数量
        int[][] d121 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS
        // D-122 专利授权量
        int[][] d122 = new int[5][3];  // 0: PRC[0: 2019; 1: 2020; 2: 2021]; 1: ENG; 2: FRA; 3: USA; 4: RUS


    }
}
