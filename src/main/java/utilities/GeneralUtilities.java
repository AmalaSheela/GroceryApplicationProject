package utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {
	
	public String getElementText(WebElement element)
	{
		return element.getText();
	}
	
	
	public String selectDropDownUsingIndex(WebElement element,int index)
	{
		
		Select object= new Select(element);
		object.selectByIndex(index);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public void sendkeysFunction(WebElement element,String values)
	{
		element.sendKeys(values);
	}
	 
	public void clickingFunction(WebElement element)
	{
		element.click();
	}
	
	public String getCssValue (WebElement element,String value) {
		return element.getCssValue("value");
	}
	
	public void doubleClickFunction(WebElement element, Actions actionObject)
	{
		actionObject.doubleClick(element).perform();
	}
	public boolean elementIsSelected(WebElement element)
	{
		return element.isSelected();
		
	}
	public boolean elementIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
		
	}
	public boolean elementIsEnabled(WebElement element)
	{
		return element.isEnabled();
		
	}
	 
	public void rightClickFunction(WebElement element, Actions actionObject)
	{
		
		actionObject.contextClick(element).perform();
	}
	
	public void dragAndDropFunction(WebElement targetelement, Actions actionObject,WebElement sourceelement)
	{
		actionObject.dragAndDrop(targetelement, sourceelement).perform();
	}
	
	public void fileUploadFunction(WebElement element,Actions object)
	{
		object.moveToElement(element).click().perform();
	}
	
	public String selectValueFromDynamicTable(List<WebElement> listofRow, String value, String locator )
	{
		String elementLocator=null;
		for(int i=0;i<listofRow.size();i++)
		{
			if(listofRow.get(i).getText().equals(value))
			{
				elementLocator = locator;
				break;
			}
		}
		return elementLocator;
	}
	
	public int selectValueFromDynamicTable(List<WebElement> listofRow, String value) {
		int elementLocator = 0;
		for (int i = 0; i < listofRow.size(); i++) {
			if (listofRow.get(i).getText().equals(value)) {
				elementLocator = i+1;
				break;
			}
		}
		return elementLocator;
	}
	
	
	public void pageScroll(int horizontal,int vertical, WebDriver driver)
	{

		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");
	}
	
	public void clickJavaAcriptExecutor(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", element);
	}
	
	
	public String generateCurrentDateAndTime() 
	{
		Date date = new Date(0);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	
	

}
