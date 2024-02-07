package testCase;

import org.testng.annotations.Test;

import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageOrdersPage;
import elementRespository.ManageProductPage;

public class ManageOrdersPageTest extends BaseClass {
	LoginPage  lp;
	HomePage hp;
	ManageProductPage mpp;
	ManageOrdersPage mop;
	
	
  @Test
  public void verifyOrdersPage() {
		  
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);//homepage
		  mpp=new ManageProductPage(driver);
		  mop =new ManageOrdersPage(driver);
		  lp.sendUserName("Admin");
		  lp.sendpasswordField("admin");
		  lp.clickSignIn();
		  mop.clickmanageOrderTab();
		  
		  
		  
		  
  }
}
