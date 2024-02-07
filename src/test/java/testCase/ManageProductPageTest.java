package testCase;

import org.testng.annotations.Test;

import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageProductPage;

public class ManageProductPageTest extends BaseClass{
	LoginPage  lp;
	HomePage hp;
	ManageProductPage mpp;
	
  @Test
  public void verifyManageProduct() {
	  
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);//homepage
	  mpp= new ManageProductPage(driver);
	  lp.sendUserName("Admin");
	  lp.sendpasswordField("admin");
	  lp.clickSignIn();
	  
	  mpp.clickManageProductTab();
	  mpp.clickNewItemButton();
	  mpp.setTitle("paneer");
	  mpp.setproductType();
	  
	  
	  
	  
  }
}
