package com.goHealth.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goHealth.common.BaseClass;
import com.goHealth.common.Log4j;
import com.goHealth.common.UserActions;
import com.goHealth.pageObjects.TestAutomationPage;

public class TestSuite extends BaseClass {

	@Test
	public void checkTheNumberOfDaysInAMonth() {
		System.out.println("Started checkTheNumberOfDaysInAMonth Method");
		String month = "Feb";
		int year = 1998;
		System.out.println("Number of Days in " + month + " of the Year " + year + " is "
				+ TestAutomationPage.getDaysInMonth(month, year));
		System.out.println("Completed checkTheNumberOfDaysInAMonth Method");
	}

	@Test
	public void checkLeapYear() {
		System.out.println("Started checkLeapYear Method");
		int year = 1986;
		int days = 0;
		TestAutomationPage.selectYear(year);
		By month = By.xpath(TestAutomationPage.monthDropDown);
		for (int i = 0; i < 12; i++) {
			UserActions.SafeSelectOptionInDropDown_ByIndex(getDriver(), month, i);
			days = days + TestAutomationPage.getDays();
		}

		System.out.println("Number of Days: " + days);
		if (days == 365)
			System.out.println(year + " is not a Leap Year");
		else if (days == 366)
			System.out.println(year + " is a Leap Year");
		else
			Log4j.logger.error("Error occured while readying the number of days in the year ");
		System.out.println("Completed checkLeapYear Method");
	}

	@Test
	public void validateTheUserOutput() {
		System.out.println("Started validateTheUserOutput Method");
		String month = "Sep";
		int year = 2000, day = 25;
		String monthNo = TestAutomationPage.getMonthNumber(month);
		TestAutomationPage.selectMonth(month);
		String expectedOutput = "NaN-09-NaN";
		Assert.assertTrue(expectedOutput.equals("NaN-" + monthNo + "-NaN"), "Expected User Output miss match");

		TestAutomationPage.selectDay(day);
		expectedOutput = "NaN-09-25";
		Assert.assertTrue(expectedOutput.equals("NaN-" + monthNo + "-" + Integer.toString(day)),
				"Expected User Output miss match");

		TestAutomationPage.selectYear(year);
		expectedOutput = "2000-09-25";
		Assert.assertTrue(expectedOutput.equals(Integer.toString(year) + "-" + monthNo + "-" + Integer.toString(day)),
				"Expected User Output miss match");
		
		System.out.println("Completed validateTheUserOutput Method");
	}
}
