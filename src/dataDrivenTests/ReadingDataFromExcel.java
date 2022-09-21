package dataDrivenTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;                 //instead of importing each step just take out the word XSSFworkbook and put * so that it contains for each step dont have to import again and again 

public class ReadingDataFromExcel {
		                                                                   	
	 public static void main(String[]args) throws IOException {
	//public void readExcel(String filePath,String fileName,String sheetName) throws IOException {	 
	//public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{   
		 
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream("C:\\Java Eclipse\\Workspace\\POM_Example\\TestData\\testData1.xlsx");
		
	    //If it is xlsx file then create object of XSSFWorkbook class
	    XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	    
	      XSSFSheet sheet =wb.getSheet("Sheet1");    //providing sheet name
	 //   XSSFSheet sheet =wb.getSheetAt(0);        //providing index name like sheet 1 is 0 sheet2 is 1 goes on
	      
	      
	      int rowCount = sheet.getLastRowNum()+1;                                      //returns the row count
	      System.out.println("total number of rows in the sheet1 excel is "+ rowCount);
	      
	      int colCount =  sheet.getRow(0).getLastCellNum();                             //returns column/cell count
	      System.out.println("total number of columns in the sheet1 excel is "+ colCount);
	      
	    // String data[][] = new String[rowCount][colCount];

	      for(int i=0; i<rowCount; i++)
	      {
	    	XSSFRow currentRow = sheet.getRow(i);                 //focused on current row based on i value
	    	
	    	for(int j=0; j<colCount; j++)
	    	{
	    	 
	    	String value =currentRow.getCell(j).toString();          //read the value from a cell//.toString is a generic value there r other values like getstringcellvalue, getstringnumericvalue, getstringbooleancellvalue and more. .tostring will get all types string and numeric
	    	 	System.out.print("   " + value);                                //if u  write print instead println it will go in next line once the column done then it will jump to the next row/column
	    	}
	    	 System.out.println();                                        // this statement is just for align  in console
	      }
	//	return data;
		wb.close();                                                       //if u dont close in future u will have memoery leak
	    
	     	     
	}	
	

}	

//excel-->Work books--->sheets--->rows--->cells
//XSSFWorkbook
//XSSFSheet
//XSSFRow
//XssfCell