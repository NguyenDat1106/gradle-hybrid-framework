package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;

@Parameters("browser")
@BeforeClass 
 public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com");
	homePage  = new UserHomePageObject(driver);
	firstName = "Automation";
	lastName = "FC";
	validPassword = "123456";
	incorrectPassword = "654321";
	existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
	invalidEmail = "afc@afc.com@.vn";
	notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
	
	  System.out.println("Pre_Condition-Step 01: Click register link");
	  homePage.openRegisterLink();  
	  registerPage = new UserRegisterPageObject(driver);

	  System.out.println("Pre_Condition-Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(validPassword);
	  registerPage.inputToConfirmPasswordTextbox(validPassword);

	  System.out.println("Pre_Condition-Step 03: Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Pre_Condition-Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	  System.out.println("Pre_Condition-Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
	  
	  homePage  = new UserHomePageObject(driver);
	  
} 
  @Test
  public void Login_01_Emply_Data() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(invalidEmail);
	  
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

  }
  
  @Test
  public void Login_03_Email_Not_Found() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(notFoundEmail);
	  
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  

  }
  
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox("");
	  
	  loginPage.clickToLoginButton();
	
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

  }
  
  @Test
  public void Login_05_Existing_Email_Incorrect_Password() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(incorrectPassword);
	  
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void Login_06_Valid_Email_password() {
	  homePage.openLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(validPassword);
	  
	  loginPage.clickToLoginButton();
	  
	  homePage = new UserHomePageObject(driver);
	  
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }
  
 
}



	
