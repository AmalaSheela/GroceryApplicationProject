package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtilities {
	
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
public static String readstringData(int i,int j) throws IOException
{
	
	f=new FileInputStream("D:\\Sujin\\StudyMaterials\\Job\\Spring\\EclipseWorkspace\\Amala\\GroceryApp\\src\\main\\resources\\Excel\\credentials.xlsx");
	wb = new XSSFWorkbook(f);
	sh=wb.getSheet("Sheet1");
	Row r= sh.getRow(i);
	Cell c=r.getCell(j);
	return c.getStringCellValue();
}
public static double readNumericData(int i,int j) throws IOException
{
	f=new FileInputStream("D:\\Sujin\\StudyMaterials\\Job\\Spring\\EclipseWorkspace\\Amala\\GroceryApp\\src\\main\\resources\\Excel\\credentials.xlsx");
	wb = new XSSFWorkbook(f);
	sh=wb.getSheet("sheet1");
	Row r= sh.getRow(i);
	Cell c=r.getCell(j);
	return c.getNumericCellValue();
}





}
	

