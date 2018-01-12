package com.goHealth.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.goHealth.common.BaseClass;
import com.goHealth.common.Log4j;
import com.goHealth.common.UserActions;

public class TestAutomationPage extends BaseClass {
	public static String daysDropDown = "//select[@id='dob' and @placeholder='Day']";
	public static String days = "//select[@id='dob' and @placeholder='Day']/option";
	public static String monthDropDown = "//select[@id='dob' and @placeholder='Month']";
	public static String yearDropDown = "//select[@id='dob' and @placeholder='Year']";
	public static String UserOutPut = "//div[label[@for='dobOutput']]//h3";

	public static String labelSelectDOB = "//label[@for='dob']";
	public static String labelUserOutput = "//label[@for='dobOutput']";

	public static String labelAppTitle = "//h1[@class='App-title']";
	public static String logoGoHealth = "//header[@class='App-header']/img";
	public static String AppDesc = "//p[@class='App-intro']";

	public static int getDaysInMonth(String monthName, int year)
	{
		int noOfDays=0;
		try
		{
			selectMonth(monthName);
			selectYear(year);
			List<WebElement> daysList = getDriver().findElements(By.xpath(days));
			noOfDays = daysList.size();
			
		}catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}
		return noOfDays;
	}
	
	public static int getDays()
	{
		int noOfDays=0;
		try
		{
			List<WebElement> daysList = getDriver().findElements(By.xpath(days));
			noOfDays = daysList.size();
			
		}catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}
		return noOfDays;
	}
	
	public static int getDaysInMonth(String monthName)
	{
		int noOfDays=0;
		try
		{
			selectMonth(monthName);
			List<WebElement> daysList = getDriver().findElements(By.xpath(days));
			noOfDays = daysList.size();
			
		}catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}
		return noOfDays;
	}
	
	public static void selectMonth(String monthName){
		try {
			UserActions.SafeSelectOptionInDropDown_ByVisibletext(getDriver(), By.xpath(monthDropDown), monthName);
		} catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}

	}
	public static String getMonthNumber(String monthName)
	{
		int monthNo=0;
		String monthNumber=null;
		try
		{
			Select months = new Select(UserActions.FindElemntByXpath(getDriver(), monthDropDown));
			List<WebElement> monthNames = months.getOptions();
			for(WebElement month:monthNames)
			{
				if(month.getText().equalsIgnoreCase(monthName))
					monthNo = Integer.parseInt(month.getAttribute("value"))+1;
			}
			monthNumber = (monthNo < 10 ? "0" : "") + monthNo;
			
		}
		catch(Exception e){
			Log4j.logger.error(e.getMessage());
		}
		return monthNumber;
	}
	
	public static void selectDay(int day){
		try {
			UserActions.SafeSelectOptionInDropDown_ByVisibletext(getDriver(), By.xpath(daysDropDown), Integer.toString(day));
		} catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}
	}

	public static void selectYear(int year){
		try {
			UserActions.SafeSelectOptionInDropDown_ByVisibletext(getDriver(), By.xpath(yearDropDown), Integer.toString(year));
		} catch (Exception e) {
			Log4j.logger.error(e.getMessage());
		}
	}

	public static void printOutput() {
		Log4j.logger.info("Output: " + getDriver().findElement(By.xpath(UserOutPut)).getText());
	}
}
