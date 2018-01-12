package com.goHealth.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {

	public String propFileName = null;
	Properties prop = new Properties();
	public String getPropValues(String key) throws IOException
	{		
		try
        {
            if(key!=null)
            {  
            	InputStream inputStream = InitProp();
        		if (inputStream == null)
        		{
        			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        		}
        		return prop.getProperty(key);
            }
            else
            {
            	System.out.println("One of the config parameter/property is given null");
            }
		}
		catch(Exception e)
		{
			System.out.println("Check the given Config property values - Either the key "+key+" doesn't exist or mistyped");
            System.exit(0);
		}
		return null;
	}
	//To initialize and load the configuration from Config.properties file
    //Throws IOException
	private InputStream InitProp() throws IOException
	{
		propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);
		return inputStream;
	}

}
