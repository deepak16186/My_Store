package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class PersonalInfoPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public PersonalInfoPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForPersonalInfoPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("identity")));
	}
	public WebElement getTitleRadioButton()
	{
		return driver.findElement(By.id("id_gender2"));
	}
	public WebElement getFirstNameTextBox()
	{
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastNameTextBox()
	{
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getEmailAddressTextBox()
	{
		return driver.findElement(By.id("email"));
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
	public WebElement getCurrentPasswordTextBox()
	{
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getNewPasswordTextBox()
	{
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getConfirmPasswordTextBox()
	{
		return driver.findElement(By.id("confirmation"));
	}
	public WebElement getSaveButton()
	{
		return driver.findElement(By.name("submitIdentity"));
	}
	public WebElement getUpdateSuccessText()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div/p"));
	}
	public WebElement getLogoutButton()
	{
		return driver.findElement(By.className("logout"));
	}
}
