package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream fi;
	
	public static XSSFWorkbook wb;
	
	public static XSSFSheet ws;
	
	public static XSSFRow row;
	
	public static XSSFCell cell;
	
	public static FileOutputStream fo;
	
			
		
	public static String[][] getSheetData(String XLPath, String XLSheetName)
	{
		try {
			fi=new FileInputStream(XLPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws=wb.getSheet(XLSheetName);
		int firstRowNum = ws.getFirstRowNum();  
		int lastRowNum = ws.getLastRowNum(); 
		row =ws.getRow(firstRowNum);
		int firstCellNum = row.getFirstCellNum();  
		int lastCellNum = row.getLastCellNum();  
		
		
		String [][] data = new String [lastRowNum][lastCellNum];
		
		for(int i=0;i<lastRowNum;i++)
			for(int j=0;j<lastCellNum;j++)
			{
				row = ws.getRow(i+1);
				cell = row.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		
		return data;
		
	}
	

}
