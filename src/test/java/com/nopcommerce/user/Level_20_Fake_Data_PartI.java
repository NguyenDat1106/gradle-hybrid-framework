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
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
import utilities.DataHelper;
@Listeners
public class Level_20_Fake_Data_PartI extends BaseTest {
	private WebDriver driver;
	private DataHelper dateFaker;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, Email, Password;
	private String date, month, year;

	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	dateFaker = DataHelper.getDataHelper();
	firstName = dateFaker.getFirstName();
	lastName = dateFaker.getLastName();
	Email = dateFaker.getEmailAddress();
	Password = dateFaker.getPassword();
	date = "6";
	month = "November";
	year = "1996";
		    
} 
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Navigate to 'Register' page");
	  registerPage = homePage.openRegisterLink();
	  
	  registerPage.clickRadioButtonByLabel(driver, "Male");
	  
	  log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName +"'");
	  registerPage.inputToTextboxByID(driver, "FirstName",firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName +"'");
	  registerPage.inputToTextboxByID(driver, "LastName", lastName);
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value is '" + Email +"'");
	  registerPage.inputToTextboxByID(driver, "Email", Email);
	  
	  registerPage.clickCheckboxButtonByLabel(driver, "Newsletter");
	  
	  log.info("Register - Step 05: Enter to Password textbox with value is '" + Password +"'");
	  registerPage.inputToTextboxByID(driver, "Password", Password);
	  
	  log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + Password +"'");
	  registerPage.inputToTextboxByID(driver, "ConfirmPassword", Password);
	  
	  log.info("Register - Step 07: Click To 'Register'  Button ");
	  registerPage.clickToButtonByText(driver, "Register");
	  
	  log.info("Register - Step 08: verify Register success message is displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	 

  }
  
  @Test
  public void User_02_Login() {
	  log.info("Register - Step 09: Click To Logout link ");
	  homePage = registerPage.clickToLogoutLink();
	  
	  log.info("Login - Step 01: Navigate to Login Page");
	  loginPage = homePage.openLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '" + Email +"'");
	  loginPage.inputToTextboxByID(driver, "Email", Email);
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '" + Password +"'");
	  loginPage.inputToTextboxByID(driver, "Password", Password);
	  
	  log.info("Login - Step 04: Click To 'Login'  Button ");
	  loginPage.clickToButtonByText(driver, "Log in");
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  log.info("Login - Step 05: verify to My Account Link is displayed");
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
	  
  }
  
  @Test
  public void User_03_My_Account() {
	  
	  log.info("My Account - Step 01: Navigate to 'My Account' page");
	  customerInforPage = homePage.openMyAccountPage();
	  
	  log.info("My Account - Step 02: verify to 'Custommer Infor' page is displayed");
	  Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	  
	  log.info("My Account - Step 02: verify to 'First name' value is correctly");
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);
	  
	  log.info("My Account - Step 02: verify to 'Last name' value is correctly");
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);
	  
	  log.info("My Account - Step 02: verify to 'Email' value is correctly");
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), Email);
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	 closeBrowserAndDriver();
  }


}



	
