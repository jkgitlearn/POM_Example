package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashBoard;
import pages.HomePage;
import pages.LoginPage;


public class MainPageTest {
  
WebDriver driver;
	
	@Test
	public void verifylogin() //throws InterruptedException
	{
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();              // this is for when chrome updates version it automatically download we dont need to give the path
		 driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\edgedriver_win64\\msedgedriver.exe");
	//	driver=new EdgeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sihik\\Desktop\\selBrowserDrives\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	//	driver=new FirefoxDriver();
		
		//Creating object of home page
			HomePage home = new HomePage(driver);
			
			//Creating object of Login page
			LoginPage login = new LoginPage(driver);	
			
			//Creating object of Dashboard
			DashBoard dashboard = new DashBoard(driver);
			
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://demo.guru99.com/test/newtours/index.php");
		  driver.manage().window().maximize();
		  
		  
		//Click on Login button
		home.clickSignOn();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login.php"));

		
		//Enter user name & password	
		login.enterUserName("PRANATI");
		login.enterPassword("PRANATI");
		
		//click on submit btn
		login.clickSubmit();
		//Thread.sleep(3000);
		
		//  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));                              //explicit wait is used to load or wait to find the element
		  wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/login_sucess.php"));
		
		//Capture the page heading and print on console
		System.out.println("The page heading is --- " + dashboard.pageHeading());
						 
		 
		//Click on Logout button
		dashboard.logOut();

	   //Close browser instance
		wait.until(ExpectedConditions.urlContains("https://demo.guru99.com/test/newtours/index.php"));
		driver.quit();
		  
	}
	
	
	
	
	
	
	
}
