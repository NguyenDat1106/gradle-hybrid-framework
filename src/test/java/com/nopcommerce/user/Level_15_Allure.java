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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
@Listeners
public class Level_15_Allure extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;	private UserCustomerInforPageObject customerInforPage;
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
@Description("Register to system")
@Severity(SeverityLevel.NORMAL)
@Test
  public void User_01_Register() {
	  
	  registerPage = homePage.openRegisterLink();
	  
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  registerPage.inputToEmailTextbox(Email);
	  
	  registerPage.inputToPasswordTextbox(Password);
	  
	  registerPage.inputToConfirmPasswordTextbox(Password);
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  

  }
@Description("Login to system")
@Severity(SeverityLevel.NORMAL)
@Test
  public void User_02_Login() {

	  homePage = registerPage.clickToLogoutLink();
	  loginPage = homePage.openLoginLink();
	  
	  loginPage.inputToEmailTextbox(Email);
	  
	  loginPage.inputToPasswordTextbox(Password);
	  
	  homePage = loginPage.clickToLoginButton();
	  
	  Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
	  
	  customerInforPage = homePage.openMyAccountPage();
	  
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



	
