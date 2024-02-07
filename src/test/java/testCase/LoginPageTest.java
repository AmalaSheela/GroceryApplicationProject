package testCase;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Contants;
import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageProductPage;
import utilities.ExcelReadUtilities;
import utilities.GeneralUtilities;

public class LoginPageTest extends BaseClass {
	LoginPage  lp;
	HomePage hp;
	ExcelReadUtilities er;
	
	
	@DataProvider(name="loginpagedata-provider")
	public Object[][] dpMethod()
	{
		return new Object[][] {{"Admin","InvalidPassword"}, {"InvalidUsername","admin"},{"invalidUsername","Invalidpassword"}};
	}	
	
	
  @Test(groups="Smoketest")
  public void verifyLoginWithValidCredentials() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);//homepage
	  er = new ExcelReadUtilities();//ExcelRead
	  lp.sendUserName(er.readstringData(1, 0));
	  lp.sendpasswordField( er.readstringData(1, 1));
	  lp.clickSignIn();
	  String actual =hp.readAdminText();
	  String expected="Admin";
	  Assert.assertEquals(actual, expected,Contants.lp_verifyLoginWithValidCredentialsErrorMessage);
  }
  
  @Test (dataProvider="loginpagedata-provider")
  public void verifyLoginWithInvalidCredentials(String username,String password) {
	  lp=new LoginPage(driver);
	  lp.sendUserName(username);
	  lp.sendpasswordField(password);
	  lp.clickSignIn();
	  String expected="Alert!";
	  String actual=lp.alertPopUp();
	  Assert.assertEquals(actual, expected, "::Alert Message not as expected");
	  
	  
  }
  
}
