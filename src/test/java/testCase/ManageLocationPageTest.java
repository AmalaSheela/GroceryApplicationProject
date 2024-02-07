package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageLocationPage;
import elementRespository.ManageOrdersPage;
import elementRespository.ManageProductPage;

public class ManageLocationPageTest extends BaseClass {
	LoginPage  lp;
	HomePage hp;
	ManageLocationPage mlp;
	
  @Test(groups="Smoketest")
  public void VerifyCreateManageLocation() throws Throwable {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);//homepage
	  mlp=new ManageLocationPage(driver);//locationpage
	  lp.sendUserName("Admin");
	  lp.sendpasswordField("admin");
	  lp.clickSignIn();
	  mlp.clickmanageLocationTab();
	 // mlp.waitFormanageLocationTab();
	  Thread.sleep(10000);
	  mlp.clickNewButton();
	  mlp.countryNameField(1);
	  mlp.StateNameField("Bristol");
	  mlp.locationFieldTextBox("Glascow");
	  mlp.deliveryChargeFieldTextBox("20.2");
	  mlp.saveButtonField();
	  String expected="Alert!";
	  String actual= mlp.alertMsgPopUp();
	  Assert.assertEquals(actual, expected, "::Alert Message not as expected");
  }
  
 
  
  
  
}
