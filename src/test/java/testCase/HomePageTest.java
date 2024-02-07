package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRespository.HomePage;
import elementRespository.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage hp;
	
  @Test
  public void verifyLoginPage() {
	  hp=new HomePage(driver);
	  
  
  
  }
}

