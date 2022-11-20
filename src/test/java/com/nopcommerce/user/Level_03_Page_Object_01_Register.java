package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register extends BasePage {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");
	private String firstName, lastName, emailAddress, password;
@BeforeClass 
 public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com");
	homePage  = new UserHomePageObject(driver);
	firstName = "Automation";
	lastName = "FC";
	password = "123456";
	emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
	
}
	 
  @Test
  public void Register_01_Emply_Data() {
	
	  System.out.println("Register_01-Step 01: Click register link");
	  homePage.openRegisterLink();
	  
	  registerPage = new UserRegisterPageObject(driver);

	 
	  System.out.println("Register_01-Step 02: Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_01-Step 03: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
  }
  
  @Test
  public void  Register_02_Invalid_Email() {

	System.out.println("Register_02-Step 01: Click register link");
	homePage.openRegisterLink();
	
	registerPage = new UserRegisterPageObject(driver);

	
	System.out.println("Register_02-Step 02: input to required fields");

	registerPage.inputToFirstNameTextbox(firstName);
	registerPage.inputToLastNameTextbox(lastName);
	registerPage.inputToEmailTextbox("123@456#%*");
	registerPage.inputToPasswordTextbox(password);
	registerPage.inputToConfirmPasswordTextbox(password);
	 
	System.out.println("Register_02-Step 03: Click to register button");
	registerPage.clickToRegisterButton();
	 
	System.out.println("Register_02-Step 04: Verify error message displayed");
	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	    
  }
  
  @Test
  public void  Register_03_Success() {
	  
	  System.out.println("Register_03-Step 01: Click register link");
	  homePage.openRegisterLink();
	  
	  registerPage = new UserRegisterPageObject(driver);

		  

	  System.out.println("Register_03-Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  System.out.println("Register_03-Step 03: Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_03-Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	  System.out.println("Register_03-Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
  }
  
  @Test
  public void Register_04_Existing_Email() {
	  System.out.println("Register_04-Step 01: Click register link");
	  homePage.openRegisterLink();
	  
	  registerPage = new UserRegisterPageObject(driver);

		  
	  System.out.println("Register_04-Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  System.out.println("Register_04-Step 03: Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_04-Step 04: Verify Error existing email message displayed");
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
		
  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  
	  System.out.println("Register_05-Step 01: Click register link");
	  homePage.openRegisterLink();
	  
	  registerPage = new UserRegisterPageObject(driver);
		  
	  System.out.println("Register_05-Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
		
	  System.out.println("Register_05-Step 03: Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_05-Step 04: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

  }
  
  @Test
  public void Register_06_Invalid_Confirm_Password() {
	  
	  System.out.println("Register_06-Step 01: Click register link");
	  homePage.openRegisterLink();
	  
	  registerPage = new UserRegisterPageObject(driver);

		  
	  System.out.println("Register_06-Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox("123");
		
	  System.out.println("Register_06-Step 03: Click to register button");
	  registerPage.clickToRegisterButton();
		
	  System.out.println("Register_06-Step 04: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");


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



	
