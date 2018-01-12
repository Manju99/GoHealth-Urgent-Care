package com.goHealth.common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	// Method - Waits for an element till the timeout expires
	// Parameters - Driver, ElementLocator, Timeout period(in seconds)
	// Return Type and Value - Boolean (returns True when element is located
	// within timeout period else returns false)
	public static boolean WaitForElementExistWebdriverWait(WebDriver driver,By bylocator) throws Exception
	{
		boolean bFlag = false;
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(bylocator)); 

			if (driver.findElement((bylocator)).isDisplayed())
			{
				bFlag = true;;
				Log4j.logger.info("INFO: Element " + bylocator + " is available");
			}
		}
		catch (NoSuchElementException e)
		{
			Log4j.logger.error("Element "+ bylocator+ " is not available. Some exception occurred while executing");
			return false;
		}

		catch (Exception e)
		{
			bFlag = false;
			Log4j.logger.error("Some exception occurred while executing");
		}
		return bFlag;
	}
}