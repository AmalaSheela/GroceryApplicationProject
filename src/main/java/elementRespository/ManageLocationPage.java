package elementRespository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageLocationPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageLocationPage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//p[text()='Manage Location']")
	WebElement manageLocationTab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonOption;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countryFieldDropDown;

	@FindBy(xpath = "//select[@id='st_id']")
	WebElement StateFieldDropDown;

	@FindBy(xpath = "//input[@id='location']")
	WebElement locationField;

	@FindBy(xpath = "//input[@id='delivery'] ")
	WebElement deliveryChargeField;

	@FindBy(xpath = "//button[@class='btn btn-danger'] ")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertMsg;

	public void waitFormanageLocationTab() {
		wu.fleuntWait(driver, manageLocationTab, "text", "Manage Location");
	}
	
	
	public void clickmanageLocationTab() {
		manageLocationTab.click();
	}

	public void clickNewButton() {
		newButtonOption.click();
	}

	public void countryNameField(int values) {
		Select objCountryName = new Select(countryFieldDropDown);
		objCountryName.selectByIndex(values);
	}

	public void StateNameField(String name) {
		Select objStateName = new Select(StateFieldDropDown);
		objStateName.selectByVisibleText(name);
	}

	public void locationFieldTextBox(String place) {
		locationField.sendKeys(place);
	}

	public void deliveryChargeFieldTextBox(String numbers) {
		deliveryChargeField.sendKeys(numbers);
	}

	public void saveButtonField() {
		saveButton.click();
	}

	public String getDataFromManageLocationTable(int row, int column) {
		String tableElementData = "//div[@class='card']//tbody//tr[" + row + "]//td[" + column + "]";
		WebElement element = driver.findElement(By.xpath(tableElementData));
		return element.getText();
	}

	public String alertMsgPopUp() {
		String invalidAlertMsg = gu.getElementText(alertMsg);
		return invalidAlertMsg;
	}

}
