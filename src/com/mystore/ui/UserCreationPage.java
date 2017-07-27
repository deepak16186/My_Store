package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class UserCreationPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public UserCreationPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForRegisterUserPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("page")));
	}
	public WebElement getTitleRadioButton()
	{
		return driver.findElement(By.id("uniform-id_gender1"));
	}
	public WebElement getFirstNameTextBox()
	{
		return driver.findElement(By.id("customer_firstname"));
	}
	public WebElement getLastNameTextBox()
	{
		return driver.findElement(By.id("customer_lastname"));
	}
	public WebElement getPasswordTextBox()
	{
		return driver.findElement(By.id("passwd"));
	}
	public Select getDOBDatedropdown()
	{
		WebElement ddl1 = driver.findElement(By.id("days"));
		Select date = new Select(ddl1);
		return date;
	}
	public Select getDOBMonthdropdown()
	{
		WebElement ddl2 = driver.findElement(By.id("months"));
		Select month = new Select(ddl2);
		return month;
	}
	public Select getDOBYeardropdown()
	{
		WebElement ddl3 = driver.findElement(By.id("years"));
		Select year = new Select(ddl3);
		return year;
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
	public WebElement getMobileTextBox()
	{
		return driver.findElement(By.id("phone_mobile"));
	}
	public WebElement getRegisterButton()
	{
		return driver.findElement(By.id("submitAccount"));
	}
	
}
