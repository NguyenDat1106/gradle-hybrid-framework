  package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
@Listeners
public class Level_15_ReportNG_Screenshot extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
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
		    
} 
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Navigate to 'Register' page");
	  registerPage = homePage.openRegisterLink();
	  
	  log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName +"'");
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName +"'");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value is '" + Email +"'");
	  registerPage.inputToEmailTextbox(Email);
	  
	  log.info("Register - Step 05: Enter to Password textbox with value is '" + Password +"'");
	  registerPage.inputToPasswordTextbox(Password);
	  
	  log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + Password +"'");
	  registerPage.inputToConfirmPasswordTextbox(Password);
	  
	  log.info("Register - Step 07: Click To 'Register'  Button ");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 08: verify Register success message is displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
	  
	  log.info("Register - Step 09: Click To Logout link ");
	  homePage = registerPage.clickToLogoutLink();

  }
  
  @Test
  public void User_02_Login() {
	  
	  log.info("Login - Step 01: Navigate to Login Page");
	  loginPage = homePage.openLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '" + Email +"'");
	  loginPage.inputToEmailTextbox(Email);
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '" + Password +"'");
	  loginPage.inputToPasswordTextbox(Password);
	  
	  log.info("Login - Step 04: Click To 'Login'  Button ");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: verify to My Account Link is displayed");
	  Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
	  
	  log.info("Login - Step 06: Navigate to 'My Account' page");
	  customerInforPage = homePage.openMyAccountPage();
	  
	  log.info("Login - Step 07: verify to Custommer Infor page is displayed");
	  Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
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



	
