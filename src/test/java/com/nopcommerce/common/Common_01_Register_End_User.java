  package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
@Listeners
public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName;
	public static String Email;
	public static String Password;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Class Test")
  public void Register(String browserName) {
		
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
	  
	  log.info("Pre-Condition - Step 08: verify Register success message is displayed");
	  verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  log.info("Pre-Condition - Step 09: Click To Logout link ");
	  homePage = registerPage.clickToLogoutLink();
	  
	  driver.quit();
  }
  


}



	
