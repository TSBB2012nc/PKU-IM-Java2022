package Util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
	public static Sheet read(String path, int sheetIndex) throws BiffException, IOException {
		return Workbook.getWorkbook(new File(path)).getSheet(sheetIndex);
	}
}
