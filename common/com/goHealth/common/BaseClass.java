package com.goHealth.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	static GetPropertyValues _prop = new GetPropertyValues();
	private static WebDriver driver;
	
	/**
	 * This method is used for initializing the driver and setting the driver size
	 * Parameters: NONE
	 * Return Type: Void
	 */
	@BeforeSuite
	public void setUp() throws Exception
	{
		setDrver(InitializeDriver());
		getDriver().get(_prop.getPropValues("APP_URL"));
	}
	
	/**
	 * This method is used to deallocation of memory all the open object
	 * Parameters: NONE
	 * Return Type: Void
	 */
	@AfterSuite
	public void tearDown() throws Exception 
	{
		getDriver().quit();
	}
	
	/**
	 * This Method is to initialize WebDriver
	 * Parameters: WebDriver object
	 * Return Type: WebDriver object
	 */
	public static WebDriver InitializeDriver() throws Exception
	{
		String browser_To_Run = _prop.getPropValues("BROWSER_NAME");
		if(browser_To_Run.equalsIgnoreCase("chrome"))
			setDrver(setChromeDriver());
		else
			setDrver(setFirefoxDriver());

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}
	
	/**
	 * This method is to initialize ChromeDriver
	 * Parameters: WebDriver Object
	 * Return Type: ChromeDriver Object
	 * @throws IOException 
	 */
	private static WebDriver setChromeDriver() throws IOException
    {
        String dir = null;
        File directory = new File (".");
        try
        {
            dir = directory.getCanonicalPath();
        }
        catch(Exception e)
        {
            System.out.println("Exceptione is ="+e.getMessage());
            System.exit(0);
        }

        //Set the required properties to instantiate ChromeDriver. Place the ChromeDriver.exe file in the resources folder
        System.setProperty("webdriver.chrome.driver", dir+"\\resources\\chromedriver.exe");
        setDrver(new ChromeDriver());
        return getDriver();
    }
	
	/**
	 * This method is to initialize FirefoxDriver
	 * Parameters: WebDriver Object
	 * Return Type: FirefoxDriver Object
	 */
	private static WebDriver setFirefoxDriver()
	{
		setDrver(new FirefoxDriver());
		return getDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDrver(WebDriver driver) {
		BaseClass.driver = driver;
	}

}
