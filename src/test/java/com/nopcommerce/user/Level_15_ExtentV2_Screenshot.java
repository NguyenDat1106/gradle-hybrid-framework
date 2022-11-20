  package com.nopcommerce.user;

//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import page.objects.nopCommerce.user.UserCustomerInforPageObject;
//import page.objects.nopCommerce.user.UserHomePageObject;
//import page.objects.nopCommerce.user.UserLoginPageObject;
//import page.objects.nopCommerce.user.UserRegisterPageObject;
//import report.config.ExtentManager;
//@Listeners
//public class Level_15_ExtentV2_Screenshot extends BaseTest {
//	private WebDriver driver;
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerInforPage;
//	private String firstName, lastName, Email, Password;
//
//	@Parameters("browser")
//	@BeforeClass 
//	 public void beforeClass(String browserName) {
//	driver = getBrowserDriver(browserName);
//	homePage = PageGeneratorManager.getUserHomePage(driver);
//	
//	firstName = "Automation";
//	lastName = "FC";
//	Password = "123456";
//	Email = "afc" + generateFakeNumber() + "@mail.vn";
//		    
//} 
//  @Test
//  public void User_01_Register(Method method) {
//	  ExtentManager.startTest(method.getName(), "User_01_Register");
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//	  registerPage = homePage.openRegisterLink();
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName +"'");
//	  registerPage.inputToFirstNameTextbox(firstName);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to LastName textbox with value is '" + lastName +"'");
//	  registerPage.inputToLastNameTextbox(lastName);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + Email +"'");
//	  registerPage.inputToEmailTextbox(Email);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + Password +"'");
//	  registerPage.inputToPasswordTextbox(Password);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is '" + Password +"'");
//	  registerPage.inputToConfirmPasswordTextbox(Password);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click To 'Register'  Button ");
//	  registerPage.clickToRegisterButton();
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: verify Register success message is displayed");
//	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click To Logout link ");
//	  ExtentManager.endTest();
//
//  }
//  
//  @Test
//  public void User_02_Login(Method method) {
//	  ExtentManager.startTest(method.getName(), "User_02_Login");
//
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login Page");
//	  homePage = registerPage.clickToLogoutLink();
//
//	  loginPage = homePage.openLoginLink();
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + Email +"'");
//	  loginPage.inputToEmailTextbox(Email);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + Password +"'");
//	  loginPage.inputToPasswordTextbox(Password);
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click To 'Login'  Button ");
//	  homePage = loginPage.clickToLoginButton();
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: verify to My Account Link is displayed");
//	  Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
//	  customerInforPage = homePage.openMyAccountPage();
//	  
//	  ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: verify to Custommer Infor page is displayed");
//	  Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//	  ExtentManager.endTest();
//
//  }

//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }
//
//  public int generateFakeNumber() {
//	  Random rand = new Random();
//	  return rand.nextInt(9999);
//  }
//  
// 
//}



	
