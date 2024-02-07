package elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public ManageProductPage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}
	
	
@FindBy(xpath = "//p[text()='Manage Product']")
WebElement manageProductTab;

@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger'] ")
WebElement newItemButton;

@FindBy(xpath ="//input[@id='title'] ")
WebElement titleField;

@FindBy(xpath = "//label[text()='Product Type']")
WebElement productType;


public void clickManageProductTab()
{
	manageProductTab.click();
}

public void clickNewItemButton()
{
	newItemButton.click();
}

public void setTitle(String products) {
	titleField.sendKeys(products);

}

public void setproductType()
{
	productType.click();
}

}
