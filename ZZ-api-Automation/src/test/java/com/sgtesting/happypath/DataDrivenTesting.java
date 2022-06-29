package com.sgtesting.happypath;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDrivenTesting
{
	public static FileInputStream file;
	public static XSSFWorkbook book;
	public static XSSFSheet Sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		file=new FileInputStream(xlfile);
		book=new XSSFWorkbook(file);
		Sheet=book.getSheet(xlsheet);
		int row_count=Sheet.getLastRowNum();
		file.close();
		book.close();
		return row_count;
		}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		file=new FileInputStream(xlfile);
		book=new XSSFWorkbook(file);
		Sheet=book.getSheet(xlsheet);
		row=Sheet.getRow(rownum);
		int cell_count=row.getLastCellNum();
		file.close();
		book.close();
		return cell_count;
		}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		file=new FileInputStream(xlfile);
		book=new XSSFWorkbook(file);
		Sheet=book.getSheet(xlsheet);
		row=Sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter=new DataFormatter();
		String celldata=formatter.formatCellValue(cell);
		file.close();
		book.close();
		return celldata;
		}
	
	}

