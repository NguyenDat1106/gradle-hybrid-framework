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
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;

	
	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com");
	homePage  = new HomePageObject(driver);
	firstName = "Automation";
	lastName = "FC";
	validPassword = "123456";
	incorrectPassword = "654321";
	existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
	invalidEmail = "afc@afc.com@.vn";
	notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
	
	  System.out.println("Pre_Condition-Step 01: Click register link");
	  homePage.clickToRegisterLink();  
	  registerPage = new RegisterPageObject(driver);

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
	  
	  homePage  = new HomePageObject(driver);
	  
} 
  @Test
  public void Login_01_Emply_Data() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.ClickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.InputToEmailTextbox(invalidEmail);
	  
	  loginPage.ClickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

  }
  
  @Test
  public void Login_03_Email_Not_Found() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.InputToEmailTextbox(notFoundEmail);
	  
	  loginPage.ClickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  

  }
  
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.InputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox("");
	  
	  loginPage.ClickToLoginButton();
	
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

  }
  
  @Test
  public void Login_05_Existing_Email_Incorrect_Password() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.InputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(incorrectPassword);
	  
	  loginPage.ClickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void Login_06_Valid_Email_password() {
	  homePage.ClickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.InputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(validPassword);
	  
	  loginPage.ClickToLoginButton();
	  
	  homePage = new HomePageObject(driver);
	  
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



	
