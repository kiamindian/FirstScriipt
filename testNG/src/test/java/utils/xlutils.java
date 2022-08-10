package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutils extends Apputils
{
public void getRowCount(String xlfile,String xlsheet,int rownum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	int row = ws.getLastRowNum();
	wb.close();
	fi.close();
}
public static short getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	short colcount = row.getLastCellNum();
	wb.close();
	fi.close();
	return colcount;
}

public static String getStringCelldata(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	String data;
	try {
		Cell cell = row.getCell(colnum);
		data = cell.getStringCellValue();
	} catch (Exception e) {
	data = " ";
	}
	wb.close();
	fi.close();
	return data;
}
public static double getNumericCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	double data;
	try {
		Cell cell = row.getCell(colnum);
		data = cell.getNumericCellValue();
	} catch (Exception e) {
		data = 0.0;
	}
	wb.close();
	fi.close();
	return data;
}
public static boolean getBooleanCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	boolean data;
	try {
		Cell cell = row.getCell(colnum);
		data = cell.getBooleanCellValue();
	} catch (Exception e) {
		data = false;
	}
	wb.close();
	fi.close();
	return data;
}
public static void setCelldata(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	Cell cell = row.createCell(colnum);
	cell.setCellValue(data);
	FileOutputStream fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
public static void fill_GREEN_colour(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	Cell cell = row.getCell(colnum);
	CellStyle style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	FileOutputStream fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
public static void fill_RED_colour(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
{
	FileInputStream fi = new FileInputStream(xlfile);
	Workbook wb = new XSSFWorkbook(fi);
	Sheet ws = wb.getSheet(xlsheet);
	Row row = ws.getRow(rownum);
	Cell cell = row.getCell(colnum);
	CellStyle style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	FileOutputStream fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();

}
}