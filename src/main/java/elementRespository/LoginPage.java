package elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public LoginPage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}
	// By userName = By.xpath("//input[@name='username']");// With out page factory

	@FindBy(xpath = "//input[@name='username']") // with page factory
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInField;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement heading;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMsg;
	
	

	public void sendUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void sendpasswordField(String Password) {
		passwordField.sendKeys(Password);
	}

	public void clickSignIn() {
		signInField.click();
	}

	public void headingField() {
		System.out.println(heading.getText());
	}

	public String alertPopUp() {
		// return alertMsg.getText();
		String invalidAlertMsg = gu.getElementText(alertMsg);
		return invalidAlertMsg;

	}

}
