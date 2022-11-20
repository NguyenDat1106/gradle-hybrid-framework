 package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommorce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
@Listeners
public class Level_20_Fake_Data_PartIV extends BaseTest {
	private WebDriver driver;
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	UserDataMapper userData;
	private String Email;
	

	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserNamer) {
	driver = getBrowserDriver(browserNamer);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	userData = UserDataMapper.getUserData();
	
	Email = userData.getEmail() + generateFakeNumber() + "@fakemail.com";
	
		    
} 
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Navigate to 'Register' page");
	  registerPage = homePage.openRegisterLink();
	  
	  registerPage.clickRadioButtonByLabel(driver, "Male");
	  
	  log.info("Register - Step 02: Enter to Firstname textbox with value is '" + userData.getFirstName() +"'");
	  registerPage.inputToTextboxByID(driver, "FirstName",userData.getFirstName());
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value is '" + userData.getLastName() +"'");
	  registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());
	  
	  registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());
	  
	  log.info("Register - Step 04: Enter to Email textbox with value is '" + Email +"'");
	  registerPage.inputToTextboxByID(driver, "Email", Email);
	  
	  registerPage.clickCheckboxButtonByLabel(driver, "Newsletter");
	  
	  log.info("Register - Step 05: Enter to Password textbox with value is '" + userData.getPassword() +"'");
	  registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());
	  
	  log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + userData.getPassword() +"'");
	  registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());
	  
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
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getPassword() +"'");
	  loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());
	  
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
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());
	  
	  log.info("My Account - Step 02: verify to 'Last name' value is correctly");
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());
	  
	  log.info("My Account - Step 02: verify to 'Email' value is correctly");
	  Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), Email);
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	 closeBrowserAndDriver();
  }


}



	
