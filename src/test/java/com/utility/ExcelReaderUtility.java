package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;



public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile(String filename) {
		File xlsxFile=new File(System.getProperty("user.dir")+"/testData/"+filename);
		XSSFWorkbook xssfWorkBook = null;
		Row row;
		Cell emailAddressCell,passwordCell;
		User user;
		List<User> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		try {
			xssfWorkBook = new XSSFWorkbook(xlsxFile);
			userList=new ArrayList<User>();
			xssfSheet=xssfWorkBook.getSheet("LoginTestData");
			rowIterator=xssfSheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				row=rowIterator.next();
				emailAddressCell=row.getCell(0);
				passwordCell=row.getCell(1);
				user=new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkBook.close();
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList.iterator();
		
	} 

}
