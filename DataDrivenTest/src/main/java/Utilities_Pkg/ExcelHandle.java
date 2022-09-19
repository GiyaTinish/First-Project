package Utilities_Pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {

	
	public static int getRowCount(String path,String sheet) throws IOException {
		
			
			File f = new File(path);
		
			FileInputStream fs = new FileInputStream(f);
			
			
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheet);
			return sh.getLastRowNum();		
	}
	
	public static String fetchValue(String path,String sheet,int r,int c) throws IOException
	{
		File f = new File(path);
		
		FileInputStream fs = new FileInputStream(f);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet(sheet);
		XSSFCell cell = (XSSFCell)sh.getRow(r).getCell(c);
		
		if (cell.getCellType() == CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else
		{
//			double v = cell.getNumericCellValue()   this way is also possible, but here the value is in double,
//			return String.valueOf(v);				 we have to convert it to string. in sendkeys we can pass only string
			return cell.getRawValue();
		}
		
//		String value = sh.getRow(r).getCell(c).getStringCellValue();
		
//		return value;
	}
}
