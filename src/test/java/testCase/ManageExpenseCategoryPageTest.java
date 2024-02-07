package testCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Contants;
import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageExpenseCategoryPage;
import elementRespository.ManageExpenseCategoryPage;
import elementRespository.ManageLocationPage;
import utilities.ExcelReadUtilities;

public class ManageExpenseCategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ExcelReadUtilities er;
	ManageExpenseCategoryPage mec;

	//@Test(groups = "Smoketest")
	public void VerifyCreationOfManageExpenseCategory() throws Throwable {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		er = new ExcelReadUtilities();// ExcelRead
		mec = new ManageExpenseCategoryPage(driver);
		lp.sendUserName(er.readstringData(1, 0));
		lp.sendpasswordField(er.readstringData(1, 1));
		lp.clickSignIn();
		//mec.waitForManageExpenseCategoryTab();
		Thread.sleep(10000);
		mec.clickManageExpense();
		mec.clickexpenseCategory();
	}


	//@Test(groups = "Smoketest")
	public void verifySavedDataInTable() throws Throwable {
		VerifyCreationOfManageExpenseCategory();
		Thread.sleep(1000);
		mec.clickNewButton();
		String data = "Testdata290120245NEW1";
		mec.titleFieldTextBox(data);// new data creation
		mec.clicksaveButton();
		String expected = "Alert!";
		String actual = mec.alertPopUpSuccess();
		Assert.assertEquals(actual, expected, "::Data not saved in Table");

		String tableValue = mec.getTextOfValueExpenseCategoryTable(1, 1);
		// System.out.println(tableValue);
		Assert.assertEquals(data, tableValue, "::Data not same");

	}


//	@Test(groups = "Smoketest")
	public void verifyInvalidSavedDataInTable() throws Throwable {
		VerifyCreationOfManageExpenseCategory();
		Thread.sleep(1000);
		mec.clickNewButton();
		mec.titleFieldTextBox("Testdata290120245N4");// edit exsisting data
		mec.clicksaveButton();
		Thread.sleep(1000);
		String expected = "Alert!";
		String actual = mec.alertPopUp();
		Assert.assertEquals(actual, expected, "::Data not saved in Table");
	}


	//@Test(groups = "Smoketest")
	
	public void verifyEditDataInTable() throws Throwable {
		VerifyCreationOfManageExpenseCategory();
		Thread.sleep(1000);
		String updateValue = ("Testdata290120245NU1");
		WebElement rowFromTable = mec.getRowFromTable("Testdata290120245N46");
		mec.clickEditButtonOfRow(rowFromTable);
		mec.titleFieldTextBox(updateValue);
		mec.clickUpdateButton();

		String tableValue = mec.getTextOfValueExpenseCategoryTable(1, 1);
		Assert.assertEquals(updateValue, tableValue, Contants.mep_VerifyEditDataInTableErrorMessage);

	}


	@Test(groups = "Smoketest")
	public void verifyDeleteRowFromTable() throws Throwable {
		VerifyCreationOfManageExpenseCategory();
		WebElement rowFromTable = mec.getRowFromTable("Testdata290120245N2");// delete data from table
		mec.clickDeleteButton(rowFromTable);
		Thread.sleep(1000);

		String searchValue = ("TTestdata290120245N2");
		String tableValue = mec.getTextOfValueExpenseCategoryTable(1, 1);
		System.out.println(" Deleted row is:" + tableValue);
		Assert.assertNotEquals(searchValue, tableValue, Contants.mep_VerifyDeleteRowFromTableErrorMessage);

	}

}
