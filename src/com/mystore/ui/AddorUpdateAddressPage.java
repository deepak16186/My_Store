package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class AddorUpdateAddressPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public AddorUpdateAddressPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForUserAccountHomePageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("address")));
	}
	public WebElement getFirstNameTextBox()
	{
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastNameTextBox()
	{
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getAddressTextBox()
	{
		return driver.findElement(By.id("address1"));
	}
	public WebElement getCityTextBox()
	{
		return driver.findElement(By.id("city"));
	}
	public Select getStatedropdown()
	{
		WebElement ddl4 = driver.findElement(By.id("id_state"));
		Select state = new Select(ddl4);
		return state;
	}
	public WebElement getZipCodeTextBox()
	{
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getHomePhTextBox()
	{
		return driver.findElement(By.id("phone"));
	}
	public WebElement getMobileTextBox()
	{
		return driver.findElement(By.id("phone_mobile"));
	}
	public WebElement getAddressNameTextBox()
	{
		return driver.findElement(By.id("alias"));
	}
	public WebElement getSaveAddressButton()
	{
		return driver.findElement(By.id("submitAddress"));
	}
}
