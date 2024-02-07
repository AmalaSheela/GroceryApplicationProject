package testCase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import elementRespository.HomePage;
import elementRespository.LoginPage;
import elementRespository.ManageExpenseCategoryPage;
import elementRespository.ManageExpensePage;
import utilities.ExcelReadUtilities;

public class ManageExpensePageTest extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ManageExpenseCategoryPage mec;
	ManageExpensePage mep;
	ExcelReadUtilities er;
	
  @Test(groups="Smoketest")
  public void VerifyCreationOfManageExpense() throws Throwable {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mep=new ManageExpensePage(driver);
		lp.sendUserName(er.readstringData(1, 0));
		lp.sendpasswordField( er.readstringData(1, 1));
		lp.clickSignIn();
	
		mep.clickManageExpenseTab();
		mep.clickExpenseTab();
		mep.clickNewButton();
		mep.userNameField(3);
	mep.dateFieldTextBox("08-02-2024");
		mep.CategoryField(451);
		mep.orderIdField(4);
		mep.purchaseIdField(4);
		mep.expenseTypeField("db");
		mep.amountFieldTextBox("2000");
		mep.remarksFieldTextBox("Added latest data");
		Thread.sleep(10000);
		
		/*StringSelection s1=new  StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFile\\TestCaseTemplate.xls");	 
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
		   Robot robot = new Robot();
		     robot.delay(1000);
		     //copy
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_V);
		      robot.delay(250);
		      //paste
		     robot.keyRelease(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.delay(250);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);*/
		    
		
		
		//mep.chooseFile("src\\main\\resources\\UploadFile\\TestCaseTemplate.xls");
		
		mep.clicksaveButton();
		
		
}
  
  
  
}
