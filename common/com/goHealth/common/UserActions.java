package com.goHealth.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class UserActions
{
	/**
	 * This method is used to get the List of webElements
	 * Parameters: WebDriver Object, Xpath of the element and Time to wait
	 * Return Type: List of WebElements
	 */
	public static List<WebElement> FindElemntsByXpath(WebDriver driver, String sElementxpath) throws Exception
	{
		boolean bFlag = Synchronization.WaitForElementExistWebdriverWait(driver, By.xpath(sElementxpath));
		Assert.assertTrue(bFlag);
		List<WebElement> elements=driver.findElements( By.xpath(sElementxpath));
		return elements;
	}
	
	/**
	 * This method is used to get the List of webElements
	 * Parameters: WebDriver Object, Xpath of the element and Time to wait
	 * Return Type: List of WebElements
	 */
	public static WebElement FindElemntByXpath(WebDriver driver, String sElementxpath) throws Exception
	{
		boolean bFlag = Synchronization.WaitForElementExistWebdriverWait(driver, By.xpath(sElementxpath));
		Assert.assertTrue(bFlag);
		WebElement element=driver.findElement( By.xpath(sElementxpath));
		return element;
	}
	
	// Method - Safe Method for User Select option from Drop down by option index, waits until the element is loaded and then selects an option from drop down
	// Parameters - Driver, Element Locator, Time period(in seconds), Option to select
	// Return Type and Value - boolean (returns True when option is selected from the drop down else returns false)	
	public static boolean SafeSelectOptionInDropDown_ByIndex(WebDriver driver, By bylocator, int iIndexofOptionToSelect)
	{ 
	    try
	    {
	    	Synchronization.WaitForElementExistWebdriverWait(driver, bylocator);
			WebElement selectElement = driver.findElement(bylocator);
			Select select = new Select(selectElement);
	    	select.selectByIndex(iIndexofOptionToSelect);
	    	System.out.println("Selected option from " + bylocator + " dropdown");
	    	return true;
	    }
	    catch (Exception e)
	    {
	    	System.out.println("ERROR: Unable to select option from " + bylocator + "Some exception occurred during execution");
	    	return false;
	    }
	} 
	
	// Method - Safe Method for User Select option from Drop down by option index, waits until the element is loaded and then selects an option from drop down
	// Parameters - Driver, Element Locator, Time period(in seconds), Option to select
	// Return Type and Value - boolean (returns True when option is selected from the drop down else returns false)	
	public static boolean SafeSelectOptionInDropDown_ByVisibletext(WebDriver driver, By bylocator, String sOptionToSelect)
	{ 
	    try
	    {
	    	Synchronization.WaitForElementExistWebdriverWait(driver, bylocator);
			WebElement selectElement = driver.findElement(bylocator);
			Select select = new Select(selectElement);
			
	    	select.selectByVisibleText(sOptionToSelect);
	    	System.out.println("Selected option from " + bylocator + " dropdown");
	    	return true;
	    }
	    catch (Exception e)
	    {
	    	System.out.println("ERROR: Unable to select option from " + bylocator + "Some exception occurred during execution");
	    	return false;
	    }
	} 
	
	// Method - Safe Method for User Select option from Drop down by option index, waits until the element is loaded and then selects an option from drop down
	// Parameters - Driver, Element Locator, Time period(in seconds), Option to select
	// Return Type and Value - boolean (returns True when option is selected from the drop down else returns false)	
	public static boolean SafeSelectOptionInDropDown_ByValue(WebDriver driver, By bylocator, String sOptionToSelect)
	{ 
	    try
	    {
	    	Synchronization.WaitForElementExistWebdriverWait(driver, bylocator);
			WebElement selectElement = driver.findElement(bylocator);
			Select select = new Select(selectElement);
			select.selectByValue(sOptionToSelect);
	    	System.out.println("Selected option from " + bylocator + " dropdown");
	    	return true;
	    }
	    catch (Exception e)
	    {
	    	System.out.println("ERROR: Unable to select option from " + bylocator + "Some exception occurred during execution");
	    	return false;
	    }
	} 
}