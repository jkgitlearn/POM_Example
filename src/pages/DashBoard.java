package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public DashBoard(WebDriver d) {
	driver=d;
	PageFactory.initElements(d, this);
	}
	
	//Locator for logOut button
		@FindBy(linkText = "SIGN-OFF")
		WebElement signOffLink;
	
		@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")
		WebElement text;
	
		//Method to click the sign-off btn
	    public void logOut()
	    {
	    	signOffLink.click();
	    }
        
	    public String pageHeading()
	    {
	    	String head = text.getText();
	    	return head;
	    }	
}
