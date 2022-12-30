package util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ExcelReader 
{
	public static void main(String[] args) throws BiffException, IOException 
	{
		String path = "./专利数据Demo.xls";//Excel文件的路径
		Workbook wrb = Workbook.getWorkbook(new File(path));
		Sheet rs = wrb.getSheet(0);
		//得到一共有多少列
		int cols = rs.getColumns();
		//得到一共有多少行
		int rows = rs.getRows();
		for (int i = 0; i < rows; i++) 
		{
		 	for (int j = 0; j < cols; j++) 
		 	{
		         //第一个参数是列 第二个参数是行 然后根据excel对应的每行每列进行取值 第一次遍历的时候
		         String name1=rs.getCell(j, i).getContents();//默认最左边编号也算一列 所以这里得j++
		         //name1 第一行第一列
		         System.out.println(name1);
		    }
		}
	}
}
