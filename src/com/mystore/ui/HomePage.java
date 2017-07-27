package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class HomePage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
	}
	public void waitForHomePageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("index")));
	}
	public WebElement getSignInButton()
	{
		return driver.findElement(By.className("login"));
	}
	public WebElement getSignOutButton()
	{
		return driver.findElement(By.xpath("//*[@id='footer']/div/section[5]/div/ul/li[5]/a"));
	}
}
