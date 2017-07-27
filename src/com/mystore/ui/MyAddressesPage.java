package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class MyAddressesPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public MyAddressesPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForUserAccountHomePageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addresses")));
	}
	public WebElement getAddressUpdateButton()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div/ul/li[9]/a[1]"));
	}
	public WebElement getDeleteAddressButton()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div/ul/li[9]/a[2]"));
	}
	public WebElement getAddNewAddressButton()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[2]/a"));
	}
	public WebElement getNewAddressName()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div[2]/ul/li[1]/h3"));
	}
	public WebElement getNewCustomerName()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div[2]/ul/li[2]"));
	}
	public WebElement getLogoutButton()
	{
		return driver.findElement(By.className("logout"));
	}
	public WebElement getUpdatedAddressName()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div[1]/ul/li[1]/h3"));
	}
	public WebElement getUpdatedCustomerName()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div[1]/ul/li[2]"));
	}
}
