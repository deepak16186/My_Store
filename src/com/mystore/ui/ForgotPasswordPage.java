package com.mystore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utils.GetData;

public class ForgotPasswordPage {
	
	WebDriver driver;
	String timeout = GetData.fromProperties("configuration", "timeouts");
	Integer timeouts = new Integer(timeout);
	
	public ForgotPasswordPage(WebDriver driver){
		
		this.driver = driver;	
	}
	public void waitForForgotPwdPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("password")));
	}
	public WebElement getEmailAddressTextBox()
	{
		return driver.findElement(By.id("email"));
	}
	public WebElement getRetrivePasswordButton()
	{
		return driver.findElement(By.xpath("//*[@id='form_forgotpassword']/fieldset/p/button"));
	}
	public WebElement getRetrivePasswordSuccessText()
	{
		return driver.findElement(By.xpath("//*[@id='center_column']/div/p"));
	}
	
}
