package testCases;

import org.testng.annotations.Test;

import dataDrivenTests.ReadingDataFromExcel;
import dataDrivenTests.TestData;
import dataDrivenTests.TestDataDuplicate;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class DataProvid {
  @Test(dataProvider = "dp")                           //data provider with data provider method name 
  public void f(String uName, String pwd) {             //send the parameters as string or object in method for data provider
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\chromedriver_win32\\chromedriver.exe");
	  WebDriver	 driver = new ChromeDriver();
	  
	//Creating object of home page
		HomePage home = new HomePage(driver);
		
	//Creating object of Login page
	    LoginPage login = new LoginPage(driver);
		
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://demo.guru99.com/test/newtours/index.php");
	  driver.manage().window().maximize();
	  
	//Click on Login button
    home.clickSignOn();
    
//    WebElement trialPopUpClose = driver.findElement(By.xpath(" //*[@id=\"dismiss-button\"]/div/span"));         // use this when its not alert
//    trialPopUpClose.click(); 
  
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login.php"));

    
  //Enter user name & password	
  		login.enterUserName(uName);
  		login.enterPassword(pwd);
  	//	wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login.php"));

  		
  	//click on submit btn
  	 login.clickSubmit();
  }

//  @DataProvider                                     // 1way of writing data provider
//  public Object[][] dp() {
//    return new Object[][] {
//      new String[] {"PRANATI", "PRANATI"},
//      new String[] {"PRANATI1", "PRANATI1"},
//      new String[] {"uName1", "pwd1"}
//    };
//  }
  
//  @DataProvider(name="dp")                           //another way ofwriting data provider
//  
//	  public String[][] getData()
//	  {
//	  String dp[][]= 
//		  {
//			  
//			  {"sachin", "sachin"},
//			  {"sachin1", "sachin1"}, 
//			  {"sachin2", "sachin2"},
//			  {"sachin3", "sachin3"}
//         };
//	  return dp;
//			  
//	  }
  
  
  @DataProvider
  public Object[][] dp() throws IOException {
	  
	//object creation from class Testdata
	  
	//  TestData ed = new TestData();
	//  ReadingDataFromExcel ed = new  ReadingDataFromExcel();
	  
	    TestDataDuplicate ed = new  TestDataDuplicate();
	    String filePath = System.getProperty("user.dir")+"\\TestData";                           //dir means directory         //test data is a name of the folder u created in the pom-example  in the windows explorer in java ecliose-->then pomexample there u created a new folder called test data
	    return ed.readExcel(filePath, "testData1.xlsx", "sheet1");                                 // testdata1.xslx is the name of the excel sheet i created a test data 
  } 
	  
			  
 
}
