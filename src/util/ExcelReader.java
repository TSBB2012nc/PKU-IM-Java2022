package util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelReader {
	public static Workbook read(String path) throws BiffException, IOException {
		return Workbook.getWorkbook(new File(path));
	}
}
