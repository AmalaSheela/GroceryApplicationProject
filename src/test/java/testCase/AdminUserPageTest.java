package testCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRespository.AdminUserPage;
import elementRespository.HomePage;
import elementRespository.LoginPage;
import utilities.ExcelReadUtilities;

public class AdminUserPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	AdminUserPage ap;
	ExcelReadUtilities er;

	@Test(groups = "Smoketest")
	public void verifyAdminUserDetails() throws Throwable {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);// homepage
		ap = new AdminUserPage(driver);
		lp.sendUserName(er.readstringData(1, 0));
		lp.sendpasswordField(er.readstringData(1, 1));
		lp.clickSignIn();
		ap.clickAdminUserTab();
		

	}

	@Test
	public void VerifyNewAdmin() throws Throwable {
		verifyAdminUserDetails();
		String newValue = "Admin15";
		ap.clickAdminUserTab();
		ap.newButtonClick();
		ap.sendUserNameTextBox(newValue);
		ap.sendpasswordFieldTextBox("admin12");
		ap.userTypeDropDownField("staff");
		ap.clickOnsaveButton();
		String actualValue = ap.searchFromTable(1, 1);
		Assert.assertEquals(actualValue, newValue, "::Values are not same");

	}
	 
	 @Test
	public void verifyDataSearch() throws Throwable {
		verifyAdminUserDetails();
		String searchValue = "NewTestdata07_02_24";
		ap.searchButton();
		ap.searchUsernameTextBoxField(searchValue);
		ap.dataSearchOption();
		String actualValue = ap.searchFromTable(1, 1);
		Assert.assertEquals(actualValue, searchValue, "::Values are not same");
	}

}
