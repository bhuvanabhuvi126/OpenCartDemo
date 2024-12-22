package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class DataProviders {
	@DataProvider(name="login_credentials")
	public String[][] getLoginData() throws IOException{
		String filepath = ".//testdata//login_test_data.xlsx";
		ExcelUtility utility = new ExcelUtility(filepath);
		int rows = utility.getRowCount("sheet1");
		int cols = utility.getCellCount("sheet1", 1);
		String data[][] = new String[rows][cols];
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<cols; j++) {
				data[i-1][j]=utility.getCellData("sheet1", i, j );
			}
		}
		return data;
		
	}

}
