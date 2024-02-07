package elementRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageExpensePage(WebDriver driver) {// constructor
		this.driver = driver;// calls from constructor in java
		PageFactory.initElements(driver, this);// with page factory
	}
	
	/*public void waitForManageExpenseCategoryTab()
	{
		wu.fleuntWait(driver, manageExpenseTab, "class", "nav-icon fas fa-money-bill-alt");
	}*/
	
	/*public void waitForManageExpeneseCategoryTab()
	{
		wu.fleuntWait(driver, amountTextBoxField, null, null);
	}*/
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpenseTab;
	
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement manageExpense;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonOption;
	
	@FindBy(xpath ="//select[@id='user_id']")
	WebElement userFieldDropDown;
	
	@FindBy(xpath ="//input[@id='ex_date']")
	WebElement dateField;
	
	@FindBy(xpath ="//select[@id='ex_cat']")
	WebElement categoryFieldDropDown;
	
	
	@FindBy(xpath ="//select[@id='order_id']")
	WebElement orderIdFieldDropDown;
	
	
	@FindBy(xpath ="//select[@id='purchase_id']")
	WebElement purchaseIdFieldDropDown;
	
	@FindBy(xpath ="//select[@id='ex_type']")
	WebElement expenseTypeFieldDropDown;
	
	@FindBy(xpath = "//input[@id='amount']") 
	WebElement amountTextBoxField;
	
	@FindBy(xpath = "//textarea[@id='content']") 
	WebElement remarksTextBoxField;
	
	
	/*@FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div[9]/input") 
	WebElement  chooseFileOption;*/
	
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[2]/button") 
	WebElement saveButtonField;
	
	
	
	public void clickManageExpenseTab()
	{
		manageExpenseTab.click();
	}
	
	public void clickExpenseTab()
	{
		manageExpense.click();
	}

	
	public void clickNewButton()
	{
		newButtonOption.click();
	}
	public void userNameField(int values)
	{
		Select objuserName= new Select(userFieldDropDown);
		objuserName.selectByIndex(values);
	}
	
	public void dateFieldTextBox(String numbers)
	{
		dateField.clear();
		dateField.sendKeys(numbers);
	}
	public void CategoryField(int values)
	{
		Select objCategoryField= new Select(categoryFieldDropDown);
		objCategoryField.selectByIndex(values);
	}
	
	public void orderIdField(int values)
	{
		Select objorderIdField= new Select(orderIdFieldDropDown);
		objorderIdField.selectByIndex(values);
	}
	public void purchaseIdField(int values)
	{
		Select objpurchaseIdField= new Select(purchaseIdFieldDropDown);
		objpurchaseIdField.selectByIndex(values);
	}
	
	public void expenseTypeField(String values)
	{
		Select objexpenseTypeField= new Select(expenseTypeFieldDropDown);
		objexpenseTypeField.selectByValue(values);
	}
	
	
	public void amountFieldTextBox(String numbers)
	{
		amountTextBoxField.sendKeys(numbers);
	}
	
	public void remarksFieldTextBox(String values)
	{
		remarksTextBoxField.sendKeys(values);
	}
	
	
	/*public void chooseFile(String file)
	{
		chooseFileOption.click();		
		chooseFileOption.sendKeys(file);
		Actions obj = new Actions(driver);
		gu.fileUploadFunction(chooseFileOption, obj);
	}*/
	
	
	public void clicksaveButton()
	{
		saveButtonField.click();
	}
	

}
