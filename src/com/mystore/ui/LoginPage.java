package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class LoginPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("authentication")));
	}
	public WebElement getUserNameTextBox()
	{
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordTextBox()
	{
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.id("SubmitLogin"));
	}
	public WebElement getEmailTextBoxforReg()
	{
		return driver.findElement(By.id("email_create"));
	}
	public WebElement getCreatAccountButton()
	{
		return driver.findElement(By.id("SubmitCreate"));
	}
	public WebElement getForgotPasswordLink()
	{
		return driver.findElement(By.xpath("//*[@id='login_form']/div/p[1]/a"));
	}
}
