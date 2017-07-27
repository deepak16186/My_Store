package com.mystore.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.mystore.utils.GetData;

public class CreateWebDrive {
	
	public static WebDriver instance() {
		
		WebDriver driver = null;
		String browsername = GetData.fromProperties("configuration", "browser");
		String url = GetData.fromProperties("configuration", "URL");
		String timeout = GetData.fromProperties("configuration", "timeouts");
		
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette","./browser-drivers/geckodriver.exe");
			driver = new org.openqa.selenium.firefox.FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./browser-drivers/chromedriver.exe");
			driver = new org.openqa.selenium.chrome.ChromeDriver();
		}
		else
		{
			System.err.print("Improper Browser Selection");
		}
		
		Integer timeouts = new Integer(timeout);
		driver.manage().window().maximize();
		driver.manage().timeouts().
		implicitlyWait(timeouts, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
