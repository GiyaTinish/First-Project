package Test_Pkg;

import java.io.IOException;

import org.testng.annotations.Test;

import Base_Pkg.BaseClass;
import Pages_Pkg.FbLoginPage;
import Utilities_Pkg.ExcelHandle;

public class FbLoginTest extends BaseClass{

	
	@Test
	public void testLogin() throws IOException
	{
		FbLoginPage ob = new FbLoginPage(driver);
		
		String excelPath = "D:\\LoginTest.xlsx";
		String sheet = "Sheet1";
		
		int rowCount = ExcelHandle.getRowCount(excelPath, sheet);
		
		for (int i= 1; i<=rowCount; i++)
		{
			String username = ExcelHandle.fetchValue(excelPath, sheet, i, 0);
			String password = ExcelHandle.fetchValue(excelPath, sheet, i, 1);

			ob.setValues(username,password);
			ob.login();
		}
		
	}
}
