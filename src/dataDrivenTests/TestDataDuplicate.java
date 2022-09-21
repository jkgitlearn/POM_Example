package dataDrivenTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataDuplicate {
	
	
	
	public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{   
		 
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream("C:\\Java Eclipse\\Workspace\\POM_Example\\TestData\\testData1.xlsx");
		
	    //If it is xlsx file then create object of XSSFWorkbook class
	    XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	    
	      XSSFSheet sheet =wb.getSheet("Sheet1");    //providing sheet name
	 //   XSSFSheet sheet =wb.getSheetAt(0);        //providing index name like sheet 1 is 0 sheet2 is 1 goes on
	      
	      
	   //   int rowCount = sheet.getLastRowNum()+1;     //returns the row count
	  //    int rowCount1 = sheet.getLastRowNum()-sheet.getFirstRowNum();
	      
	      int rowCount = sheet.getLastRowNum()+1;
	     
	      System.out.println("total number of rows in the sheet1 excel is "+ rowCount);
	      
	      int colCount =  sheet.getRow(0).getLastCellNum();  //returns column/cell count
	      System.out.println("total number of columns in the sheet1 excel is "+ colCount);
	      
	     String data[][] = new String[rowCount][colCount];

	      for(int i=1; i<rowCount; i++)
	      {
	    	XSSFRow currentRow = sheet.getRow(i);                 //focused on current row based on i value
	    	
	    	for(int j=0; j<colCount; j++)
	    	{
	    	 
	    	XSSFCell c =currentRow.getCell(j);
	    	
//				try 
//				{
				 data[i][j]=c.toString();                                                                                                                                             //read the value from a cell//.toString is a generic value there r other values like getstringcellvalue, getstringnumericvalue, getstringbooleancellvalue and more. .tostring will get all types string and numeric
				 System.out.print("   " + c.toString());                                //if u  write print instead println it will go in next line once the column done then it will jump to the next row/column
//					    	                                       // this statement is just for align  in console
//				} 
//			 catch (Exception e) {
//				
//				e.printStackTrace();
//			}
//	    	  	    	
	       }
	    	 System.out.println(); 
      	}
	      
		return data;
	//	wb.close();                                                       //if u dont close in future u will have memoery leak
	    
	     	     
	}	
	

}	


