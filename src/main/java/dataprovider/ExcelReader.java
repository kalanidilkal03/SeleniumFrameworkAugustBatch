package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
   static XSSFWorkbook wb;
   public static Object[][] getDataFromExcel(String sheetName)
   {
	   try
	   {
		   wb=new XSSFWorkBook(new FileInputStream(new File(System.getProperty("user.dir")+"./testdata/Data.xlsx")));
		   System.out.println("LOG:INFO - Loading excel workbook");
	   }
	   catch (IOException e)
	   {
		   System.out.println("Could not load the data file "+e.getMessage());
	   }
	   int row=wb.getSheet(sheetName).getPhysicalNumberOfRows();
	   int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	   
	   Object [][]arr=new Object[row-1][column];
	   for(int i=1;i<row;i++)
	   {
		   for(int j=0;j<column;j++)
		   {
			 arr[i-1][j]=getData(sheetName,i,j);
		   }
	   }
	   System.out.println("LOG:INFO - Excel workbook completed");
	   try
	   {
		   wb.close();
	   }
	   catch(IOException e)
	   {
		   System.out.println("Could not close the data file "+e.getMessage());
	   }
	   return arr;
   }
   
   public static String getData(String sheetName, int row, int column)
	{
		//links, data etc.
		String value="";
		CellType type=wb.getSheet(sheetName).getRow(row).getCell(column).getCellType();
		if(type==CellType.STRING)
		{
			value=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		else if(type==CellType.NUMERIC)
		{
			double dValue=wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			value=String.valueOf(dValue);
		}
		else if(type==CellType.BOOLEAN)
		{
			boolean bValue=wb.getSheet(sheetName).getRow(row).getCell(column).getBooleanCellValue();
			value=String.valueOf(bValue);
		}
		else if(type==CellType.BLANK)
		{
			value="";
		}
		return value;
	}
}
