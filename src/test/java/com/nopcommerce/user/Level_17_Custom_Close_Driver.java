  package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
@Listeners
public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, Email, Password;

	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	firstName = "Automation";
	lastName = "FC";
	Password = "123456";
	Email = "afc" + generateFakeNumber() + "@mail.vn";
	
	 log.info("Pre-Condition - Step 01: Navigate to 'Register' page");
	  registerPage = homePage.openRegisterLink();
	  
	  log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value is '" + firstName +"'");
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  log.info("Pre-Condition - Step 03: Enter to LastName textbox with value is '" + lastName +"'");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  log.info("Pre-Condition - Step 04: Enter to Email textbox with value is '" + Email +"'");
	  registerPage.inputToEmailTextbox(Email);
	  
	  log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + Password +"'");
	  registerPage.inputToPasswordTextbox(Password);
	  
	  log.info("Pre-Condition - Step 06: Enter to ConfirmPassword textbox with value is '" + Password +"'");
	  registerPage.inputToConfirmPasswordTextbox(Password);
	  
	  log.info("Pre-Condition - Step 07: Click To 'Register'  Button ");
	  registerPage.clickToRegisterButton();
	  
	  driver = null;
	  
	  log.info("Pre-Condition - Step 08: verify Register success message is displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed....");
	  
	  log.info("Pre-Condition - Step 09: Click To Logout link ");
	  homePage = registerPage.clickToLogoutLink();
	
	  log.info("Pre-Condition - Step 10: Navigate to Login Page");
	  loginPage = homePage.openLoginLink();
	  
	  log.info("Pre-Condition - Step 11: Enter to Email textbox with value is '" + Email +"'");
	  loginPage.inputToEmailTextbox(Email);
	  
	  log.info("Pre-Condition - Step 12: Enter to Password textbox with value is '" + Password +"'");
	  loginPage.inputToPasswordTextbox(Password);
	  
	  log.info("Pre-Condition - Step 13: Click To 'Login'  Button ");
	  homePage = loginPage.clickToLoginButton();
} 
  @Test
  public void User_01_Register() {
	 

  }
  
  @Test
  public void User_02_Login() {
	  
	
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	 closeBrowserAndDriver();
  }

 
}



	
