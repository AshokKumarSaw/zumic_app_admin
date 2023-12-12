package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class  ActionUtil {
	public static Logger logger= LogManager.getLogger(ActionUtil.class);
	
	
	public static void click(WebElement webElement) {
		if (webElement != null) {
			webElement.click();
		}
	}
	
	public static void generateAndSendRandomAlphaNumericToInput(WebElement locator) {
		if (locator != null) {
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			String generatedNumber = RandomStringUtils.randomNumeric(8);
			locator.sendKeys(generatedString + generatedNumber);
		}
		else
		{
			logger.info("locator is null, Please pass valid locator ");
		}
	}
	
	public static void scrollWebPage(int x, int y,JavascriptExecutor js)
	{
	
	js.executeScript("window.scrollBy("+x+","+y+")");
	 
	}
	
	
}
