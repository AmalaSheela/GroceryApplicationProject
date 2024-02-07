package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	public void explicitWaitForTextField(WebDriver driver,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(value)));
	}
	public void explicitWaitForAlertMessages(WebDriver driver)//explicitwait
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());	
	}
	public void fleuntWait(WebDriver driver,WebElement element,String attributeValues,String attribute)//fleuntwait
	{
	
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValues));
	}
	
	

}
