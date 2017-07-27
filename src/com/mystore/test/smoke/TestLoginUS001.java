package com.mystore.test.smoke;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.test.config.CreateWebDrive;
import com.mystore.ui.AddorUpdateAddressPage;
import com.mystore.ui.ForgotPasswordPage;
import com.mystore.ui.HomePage;
import com.mystore.ui.LoginPage;
import com.mystore.ui.MyAddressesPage;
import com.mystore.ui.PersonalInfoPage;
import com.mystore.ui.UserAccountHomePage;
import com.mystore.ui.UserCreationPage;
import com.mystore.utils.GetData;

public class TestLoginUS001 {
	
	String username = GetData.fromExcel("data", "US001", 0, 1);
	String password	= GetData.fromExcel("data", "US001", 1, 1);
	String firstname = GetData.fromExcel("data", "US001", 2, 1);
	String lastname	= GetData.fromExcel("data", "US001", 3, 1);
	String address	= GetData.fromExcel("data", "US001", 4, 1);
	String city	= GetData.fromExcel("data", "US001", 5, 1);
	String zipcode	= GetData.fromExcel("data", "US001", 6, 1);
	String mobile	= GetData.fromExcel("data", "US001", 7, 1);
	String welcometext	= GetData.fromExcel("data", "US001", 8, 1);
	String pwdRetriveSuccesstxt	= GetData.fromExcel("data", "US001", 9, 1);
	
	String updatedFirstName = GetData.fromExcel("data", "US002", 0, 1);
	String updatedLastName	= GetData.fromExcel("data", "US002", 1, 1);
	String updateSuccessText	= GetData.fromExcel("data", "US002", 2, 1);
	String newPassword	= GetData.fromExcel("data", "US002", 3, 1);
	String updatedEmailId	= GetData.fromExcel("data", "US002", 4, 1);
	
	String add2FirstName = GetData.fromExcel("data", "US003", 0, 1);
	String add2LastName	= GetData.fromExcel("data", "US003", 1, 1);
	String add2Address	= GetData.fromExcel("data", "US003", 2, 1);
	String add2City	= GetData.fromExcel("data", "US003", 3, 1);
	String add2ZipCode = GetData.fromExcel("data", "US003", 4, 1);
	String add2HomePhone = GetData.fromExcel("data", "US003", 5, 1);
	String add2MobilePhone = GetData.fromExcel("data", "US003", 6, 1);
	String newAddressName = GetData.fromExcel("data", "US003", 7, 1);
	String newAddressCustomerName = GetData.fromExcel("data", "US003", 8, 1);
	
	String add3FirstName = GetData.fromExcel("data", "US004", 0, 1);
	String add3LastName	= GetData.fromExcel("data", "US004", 1, 1);
	String add3Address	= GetData.fromExcel("data", "US004", 2, 1);
	String add3City	= GetData.fromExcel("data", "US004", 3, 1);
	String add3ZipCode = GetData.fromExcel("data", "US004", 4, 1);
	String add3HomePhone = GetData.fromExcel("data", "US004", 5, 1);
	String add3MobilePhone = GetData.fromExcel("data", "US004", 6, 1);
	String updatedAddressName = GetData.fromExcel("data", "US004", 7, 1);
	String updatedAddressCustomerName = GetData.fromExcel("data", "US004", 8, 1);
	
	WebDriver driver;
	HomePage home;
	LoginPage login;
	UserAccountHomePage accountHome;
	UserCreationPage userCreation;
	ForgotPasswordPage forgotPwd;
	PersonalInfoPage personalInfo;
	MyAddressesPage addresses;
	AddorUpdateAddressPage updateAddress;
	
	/*Test Case 001 - User Login & Logout Validation*/
	@BeforeMethod
	public void driverSetUp(){
		
		driver = CreateWebDrive.instance();
		home = new HomePage(driver);
		login = new LoginPage(driver);
		accountHome = new UserAccountHomePage(driver);
		userCreation = new UserCreationPage(driver);
		forgotPwd = new ForgotPasswordPage(driver);
		personalInfo = new PersonalInfoPage(driver);
		addresses = new MyAddressesPage(driver);
		updateAddress = new AddorUpdateAddressPage(driver);
	}
		
	@Test(enabled=true, priority=1)
	public void registerUserTC001() throws InterruptedException{
	
		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getEmailTextBoxforReg().sendKeys(username);
		login.getCreatAccountButton().click();
		userCreation.waitForRegisterUserPageToLoad();
		userCreation.getTitleRadioButton().click();
		userCreation.getFirstNameTextBox().sendKeys(firstname);
		userCreation.getLastNameTextBox().sendKeys(lastname);
		userCreation.getPasswordTextBox().sendKeys(password);
		userCreation.getDOBDatedropdown().selectByIndex(5);
		userCreation.getDOBMonthdropdown().selectByIndex(5);
		userCreation.getDOBYeardropdown().selectByIndex(10);
		userCreation.getAddressTextBox().sendKeys(address);
		userCreation.getCityTextBox().sendKeys(city);
		userCreation.getStatedropdown().selectByIndex(5);
		userCreation.getZipCodeTextBox().sendKeys(zipcode);
		userCreation.getMobileTextBox().sendKeys(mobile);
		userCreation.getRegisterButton().click();
		accountHome.waitForUserAccountHomePageToLoad();

		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getLogoutButton().click();
		
	}
	
	@Test(enabled=true, priority=2)
	public void userLoginTC002(){
	
		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();

		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getLogoutButton().click();
	}
	
	@Test(enabled=true, priority=3)
	public void forgotPasswordTC003(){
		
	
		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getForgotPasswordLink().click();
		
		forgotPwd.waitForForgotPwdPageToLoad();
		forgotPwd.getEmailAddressTextBox().sendKeys(username);
		forgotPwd.getRetrivePasswordButton().click();
		
		String actualPwdRetriveSuccesstxt = forgotPwd.getRetrivePasswordSuccessText().getText();
		String expectedPwdRetriveSuccesstxt = pwdRetriveSuccesstxt;
		Assert.assertTrue(actualPwdRetriveSuccesstxt.contains(expectedPwdRetriveSuccesstxt));

	}
	
	@Test(enabled=true, priority=4)
	public void updateUserTC004(){

		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getPersonalInfoButton().click();
		
		personalInfo.getTitleRadioButton().click();
		personalInfo.getFirstNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),updatedFirstName);
		personalInfo.getLastNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),updatedLastName);
		personalInfo.getDOBDatedropdown().selectByIndex(8);
		personalInfo.getDOBMonthdropdown().selectByIndex(6);
		personalInfo.getDOBYeardropdown().selectByIndex(20);
		personalInfo.getCurrentPasswordTextBox().sendKeys(password);
		personalInfo.getSaveButton().click();
		
		String actualUpdateSuccessText = personalInfo.getUpdateSuccessText().getText();
		String expectedUpdateSuccessText = updateSuccessText;
		Assert.assertEquals(actualUpdateSuccessText,expectedUpdateSuccessText);
		
		personalInfo.getLogoutButton().click();
	}
	
	@Test(enabled=true, priority=5)
	public void addNewAddressTC005(){
	
		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);

		accountHome.getMyAddressesButton().click();
		
		addresses.waitForUserAccountHomePageToLoad();
		addresses.getAddNewAddressButton().click();
		
		updateAddress.waitForUserAccountHomePageToLoad();
		updateAddress.getFirstNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2FirstName);
		updateAddress.getLastNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2LastName);
		updateAddress.getAddressTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2Address);
		updateAddress.getCityTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2City);
		updateAddress.getStatedropdown().selectByIndex(6);
		updateAddress.getZipCodeTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2ZipCode);
		updateAddress.getHomePhTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2HomePhone);
		updateAddress.getMobileTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add2MobilePhone);
		updateAddress.getAddressNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),newAddressName);
		updateAddress.getSaveAddressButton().click();
		
		String actualNewAddressNameText = addresses.getNewAddressName().getText();
		String actualNewAddresscustomerNameText = addresses.getNewCustomerName().getText();
		
		String expectedNewAddressNameText = newAddressName;
		String expectedNewAddresscustomerNameText = newAddressCustomerName;
				
		Assert.assertTrue(actualNewAddressNameText.equalsIgnoreCase(expectedNewAddressNameText));
		Assert.assertTrue(actualNewAddresscustomerNameText. equalsIgnoreCase(expectedNewAddresscustomerNameText));

	}
	
	@Test(enabled=true, priority=6)
	public void addNewAddressTC006() throws InterruptedException{
	
		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getMyAddressesButton().click();
		
		addresses.waitForUserAccountHomePageToLoad();
		addresses.getAddressUpdateButton().click();
		
		updateAddress.waitForUserAccountHomePageToLoad();		
		updateAddress.getFirstNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3FirstName);
		updateAddress.getLastNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3LastName);
		updateAddress.getAddressTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3Address);
		updateAddress.getCityTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3City);
		updateAddress.getStatedropdown().selectByIndex(6);
		updateAddress.getZipCodeTextBox().clear();
		updateAddress.getZipCodeTextBox().sendKeys(add3ZipCode);
		updateAddress.getHomePhTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3HomePhone);
		updateAddress.getMobileTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),add3MobilePhone);
		updateAddress.getAddressNameTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),updatedAddressName);
		updateAddress.getSaveAddressButton().click();
		
		String actualNewAddressNameText = addresses.getUpdatedAddressName().getText();
		String actualNewAddresscustomerNameText = addresses.getUpdatedCustomerName().getText();
		
		String expectedNewAddressNameText = updatedAddressName;
		String expectedNewAddresscustomerNameText = updatedAddressCustomerName;
				
		Assert.assertTrue(actualNewAddressNameText.equalsIgnoreCase(expectedNewAddressNameText));
		Assert.assertTrue(actualNewAddresscustomerNameText. equalsIgnoreCase(expectedNewAddresscustomerNameText));

	}
	
	@Test(enabled=true, priority=7)
	public void updatePasswordTC007(){

		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(password);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getPersonalInfoButton().click();
		
		personalInfo.waitForPersonalInfoPageToLoad();
		personalInfo.getCurrentPasswordTextBox().sendKeys(password);
		personalInfo.getNewPasswordTextBox().sendKeys(newPassword);
		personalInfo.getConfirmPasswordTextBox().sendKeys(newPassword);
		personalInfo.getSaveButton().click();
		
		String actualUpdateSuccessText = personalInfo.getUpdateSuccessText().getText();
		String expectedUpdateSuccessText = updateSuccessText;
		Assert.assertEquals(actualUpdateSuccessText,expectedUpdateSuccessText);
		
		personalInfo.getLogoutButton().click();
		
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(newPassword);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText1 = accountHome.getWelcomText().getText();
		String expectedWelcomeText1 = welcometext;;
		Assert.assertEquals(actualWelcomeText1,expectedWelcomeText1);
		
		accountHome.getLogoutButton().click();
		
	}
	
	@Test(enabled=true, priority=8)
	public void updateEmailTC008(){

		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(username);
		login.getPasswordTextBox().sendKeys(newPassword);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText = accountHome.getWelcomText().getText();
		String expectedWelcomeText = welcometext;;
		Assert.assertEquals(actualWelcomeText,expectedWelcomeText);
		
		accountHome.getPersonalInfoButton().click();
		
		personalInfo.waitForPersonalInfoPageToLoad();
		personalInfo.getEmailAddressTextBox().sendKeys(Keys.chord(Keys.CONTROL,"a"),updatedEmailId);
		personalInfo.getCurrentPasswordTextBox().sendKeys(newPassword);
		personalInfo.getSaveButton().click();
		
		String actualUpdateSuccessText = personalInfo.getUpdateSuccessText().getText();
		String expectedUpdateSuccessText = updateSuccessText;
		Assert.assertEquals(actualUpdateSuccessText,expectedUpdateSuccessText);
		
		personalInfo.getLogoutButton().click();
		
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(updatedEmailId);
		login.getPasswordTextBox().sendKeys(newPassword);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText1 = accountHome.getWelcomText().getText();
		String expectedWelcomeText1 = welcometext;;
		Assert.assertEquals(actualWelcomeText1,expectedWelcomeText1);
		
		accountHome.getLogoutButton().click();
	}

	@Test(enabled=true, priority=9)
	public void signOutFromHomeTC009(){

		home.waitForHomePageToLoad();
		home.getSignInButton().click();
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys(updatedEmailId);
		login.getPasswordTextBox().sendKeys(newPassword);
		login.getLoginButton().click();
		
		accountHome.waitForUserAccountHomePageToLoad();
		
		String actualWelcomeText1 = accountHome.getWelcomText().getText();
		String expectedWelcomeText1 = welcometext;;
		Assert.assertEquals(actualWelcomeText1,expectedWelcomeText1);
		
		accountHome.getLogo().click();
		home.getSignOutButton().click();
	}
	@AfterMethod
	public void closeDriver(){
		
		driver.quit();
	}
}
