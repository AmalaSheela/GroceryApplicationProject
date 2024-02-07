package elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrdersPage {
	
		WebDriver driver;
		GeneralUtilities gu=new GeneralUtilities();

		public ManageOrdersPage(WebDriver driver) {// constructor
			this.driver = driver;// calls from constructor in java
			PageFactory.initElements(driver, this);// with page factory
		}
		
		
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrderTab;
	
	public void clickmanageOrderTab()
	{
		manageOrderTab.click();
	}

	
	
	
	
	
}	


