
package elementRespository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageExpenseCategoryPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageExpenseCategoryPage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpenseCategoryTab;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategoryTab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonOption;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleField;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement saveButtonField;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement errrorFailAlertMsg;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement successAlertMsg;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButtonField;

	public void waitForManageExpenseCategoryTab() {
		wu.fleuntWait(driver, manageExpenseCategoryTab, "class", "nav-icon fas fa-money-bill-alt");
	}
	
	public void clickManageExpense() {
		manageExpenseCategoryTab.click();
	}

	public void clickexpenseCategory() {
		expenseCategoryTab.click();
	}

	public void clickNewButton() {
		newButtonOption.click();
	}

	public void titleFieldTextBox(String name) {
		titleField.clear();
		titleField.sendKeys(name);
	}

	public void clicksaveButton() {
		saveButtonField.click();
	}

	public void clickUpdateButton() {
		updateButtonField.click();
	}

	public String alertPopUp() {
		// return alertMsg.getText();
		String invalidAlertMsg = gu.getElementText(errrorFailAlertMsg);
		return invalidAlertMsg;

	}

	public String alertPopUpSuccess() {
		// return alertMsg.getText();
		String invalidAlertMsg = gu.getElementText(successAlertMsg);
		return invalidAlertMsg;

	}

	public String getTextOfValueExpenseCategoryTable(int row, int column)// dynamic table
	{
		String tableElementPath = "//div[@class='card']//tbody//tr[" + row + "]//td[" + column + "]";
		WebElement element = driver.findElement(By.xpath(tableElementPath));
		return element.getText();
	}

	public WebElement getRowFromTable(String name) {
		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='card']//tbody//tr//td[1]"));
		for (int i = 0; i < tableRows.size(); i++) {
			String rows = tableRows.get(i).getText();
			System.out.print(rows + "  ");
		}
		int row = gu.selectValueFromDynamicTable(tableRows, name);
		// System.out.println("location : " + row);
		WebElement rowElement = driver.findElement(By.xpath("//div[@class='card']//tbody//tr[" + row + "]//td"));
		return rowElement;

	}

	public void clickEditButtonOfRow(WebElement rowFromTable) {
		WebElement findElement = rowFromTable.findElement(By.xpath("//a[@class='btn btn-sm btn btn-primary btncss']"));
		findElement.click();
	}

	public void clickDeleteButton(WebElement rowFromTable) {
		WebElement findElement = rowFromTable.findElement(By.xpath("//a[@class='btn btn-sm btn btn-danger btncss']"));
		findElement.click();
		driver.switchTo().alert().accept();
	}

}
