package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
			public LoginPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(d, this);
			}
	
	
			//Locator for username field
			@FindBy(name = "userName")
			WebElement uName;
	
			//Locator for password field
			@FindBy(name = "password")
			WebElement pwd;
			
			//Locator for login button
			@FindBy(name = "submit")
			WebElement sub;
			
			//Method to enter username
			public void enterUserName(String userName) 
			{
				uName.sendKeys(userName);
			}
			
			
			//Method to enter password
			public void enterPassword(String passW)
			{
				pwd.sendKeys(passW);
			}
			
			//Method to enter submit btn
			public void clickSubmit()
			{
				sub.click();
			} 
}
