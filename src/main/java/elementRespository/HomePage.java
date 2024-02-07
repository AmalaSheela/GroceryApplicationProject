package elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = " //a[text()=' Admin']")
	WebElement adminText;

	public String readAdminText() {
		String getAdminText = gu.getElementText(adminText);
		return getAdminText;

	}

}
