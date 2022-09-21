package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
		public HomePage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
		}
		
	//Locator for login button
	@FindBy(linkText = "SIGN-ON")
	WebElement signonLink;
	
	//Method to click login button
		public void clickSignOn() 
		{
			signonLink.click();
		}
		
}
