package elementRespository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class AdminUserPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminUserPage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement AdminUserTab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='username']") // with page factory
	WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextBoxField;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown;

	@FindBy(xpath = " //button[@name='Create']")
	WebElement saveButtonOptions;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonOption;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement dataSearchButton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUserNameText;

	public void clickAdminUserTab() {
		AdminUserTab.click();
	}

	public void newButtonClick() {
		newButton.click();
	}

	public void sendUserNameTextBox(String userName) {
		userNameTextBox.sendKeys(userName);
	}

	public void sendpasswordFieldTextBox(String Password) {
		passwordTextBoxField.sendKeys(Password);

	}

	public void userTypeDropDownField(String name) {
		Select objUserType = new Select(userTypeDropDown);
		objUserType.selectByValue(name);
	}

	public void clickOnsaveButton() {
		saveButtonOptions.click();
	}

	public void getTextEditRowFromTable() {
		List<WebElement> tableHeader = driver.findElements(By.xpath("//div[@class='card']//thead//tr//th"));
		for (int i = 0; i < tableHeader.size(); i++) {
			String header = tableHeader.get(i).getText();
			System.out.print(header + "  ");
		}

		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='card']//tbody//tr//td[1]"));// row
		for (int i = 0; i < tableRows.size(); i++) {
			String rows = tableRows.get(i).getText();
			System.out.print(rows + "  ");
		}
		int row = gu.selectValueFromDynamicTable(tableRows, "test31012024");

		WebElement rowElement = driver.findElement(By.xpath("//div[@class='card']//tbody//tr[" + row + "]//td"));

		WebElement findElement = rowElement.findElement(By.xpath("//a[@class='btn btn-sm btn btn-primary btncss']"));
		findElement.getText();
		findElement.click();

	}

	public void searchButton() {
		searchButtonOption.click();
	}

	public void dataSearchOption() {

		dataSearchButton.click();
	}

	public void searchUsernameTextBoxField(String userName) {
		searchUserNameText.sendKeys(userName);

	}

	public String searchFromTable(int row, int column) {
		WebElement rowElement = driver
				.findElement(By.xpath("//div[@class='card']//tbody//tr[" + row + "]//td[" + column + "]"));
		return rowElement.getText();
	}

}
