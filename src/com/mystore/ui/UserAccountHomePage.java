package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class UserAccountHomePage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public UserAccountHomePage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForUserAccountHomePageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("page")));
	}
	public WebElement getWelcomText()
	{
		return driver.findElement(By.className("info-account"));
	}
	public WebElement getLogoutButton()
	{
		return driver.findElement(By.className("logout"));
	}
	public WebElement getOrderHistoryButton()
	{
		return driver.findElement(By.className("icon-list-ol"));
	}
	public WebElement getMyAddressesButton()
	{
		return driver.findElement(By.className("icon-building"));
	}
	public WebElement getPersonalInfoButton()
	{
		return driver.findElement(By.className("icon-user"));
	}
	public WebElement getLogo()
	{
		return driver.findElement(By.className("logo"));
	}
}
