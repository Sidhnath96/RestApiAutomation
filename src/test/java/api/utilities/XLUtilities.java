package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilities {
	
	
	public void getXlData() throws IOException
	{
	File xlpath = new File("path of excell file");
	FileInputStream xlfile = new FileInputStream(xlpath);
	
	XSSFWorkbook workbook = new XSSFWorkbook();
	
	XSSFSheet sheet=workbook.getSheetAt(0);
	
	int rowcount = sheet.getLastRowNum();
	
	for(int i=0;i<=rowcount;i++)
	{
		
	}
	
	
	}
}
