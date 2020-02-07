package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
Workbook wb;
//write constructor for reading path of excel
public ExcelFileUtil (String excelpath)throws Throwable
{
 FileInputStream fi=new FileInputStream(excelpath);
 wb=WorkbookFactory.create(fi);
}
//method for counting no of rows
public int rowCount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
	
}
 //count no of columns from row
public int colCount(String sheetname)
{
	return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	
}
//get cell data from sheet
public String getCellData(String sheetname,int row,int column)
{
	String data="";
	if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
	int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	data=String.valueOf(celldata);
	}
	else
	{
	 data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	 
	}	
	return data;
}
  //write into ouput

public void setCelldata(String sheetname,int row,int column,String status ,String writeexcel)
throws Throwable{
Sheet ws=wb.getSheet(sheetname);
Row rownum=ws.getRow(row);
Cell cell=rownum.createCell(column);
cell.setCellValue(status);
if(status.equalsIgnoreCase("pass"))
{
	//create cell style	
	CellStyle style=wb.createCellStyle();
	//create font
	Font font=wb.createFont();
	//Apply color To The Text
	font.setColor(IndexedColors.GREEN.getIndex());
	//Apply Bold To The Text
	font.setBold(true);
	font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	style.setFont(font);
	rownum.getCell(column).setCellStyle(style);
}
else if(status.equalsIgnoreCase("Fail"))
{
	//create cell style	
		CellStyle style=wb.createCellStyle();
		//create font
		Font font=wb.createFont();
		//Apply color To The Text
		font.setColor(IndexedColors.RED.getIndex());
		//Apply Bold To The Text
		font.setBold(true);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);	
		
}
else if(status.equalsIgnoreCase("Block"))
{
	//create cell style	
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();
			//Apply color To The Text
			font.setColor(IndexedColors.BLUE.getIndex());
			//Apply Bold To The Text
			font.setBold(true);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);	
}
FileOutputStream fo=new FileOutputStream(writeexcel);
wb.write(fo);
fo.close();
}
}





	
