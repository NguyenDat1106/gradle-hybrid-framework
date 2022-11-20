  package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserAddressPageObject;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserMyProductReviewPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
import page.objects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private String firstName, lastName, Email, Password;

	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	driver.get("https://demo.nopcommerce.com");

	firstName = "Automation";
	lastName = "FC";
	Password = "123456";
	Email = "afc" + generateFakeNumber() + "@mail.vn";
	
	    
} 
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

	  homePage = registerPage.clickToLogoutLink();
	 
  }
  
  @Test
  public void User_02_Login() {
	  loginPage = homePage.openLoginLink();
	  
	  loginPage.inputToEmailTextbox(Email);
	  loginPage.inputToPasswordTextbox(Password);
	  
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
  }
  
  @Test
  public void User_03_Customer_Infor() {
	  customerInforPage = homePage.openMyAccountPage();
	  Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
  
  @Test
  public void User_04_Switch_Page() {
	  // Customer Infor -> Address
	 addressPage = customerInforPage.openAddressPage(driver);
	 
	 // Address -> My Product Review
	 myProductReviewPage = addressPage.openMyProductReview(driver);
	 
	// My Product Review -> Reward Point
	 rewardPointPage = myProductReviewPage.openRewardPage(driver);
		 
	 
	 // Reward Point -> Address
	 addressPage = rewardPointPage.openAddressPage(driver);
	 

	 // Address -> Reward Point
	 rewardPointPage = addressPage.openRewardPage(driver);
	 
	 
	 // Reward Point -> My Product Review
	 myProductReviewPage = rewardPointPage.openMyProductReview(driver);
	  
	 // My Product Review -> Address
	 addressPage = myProductReviewPage.openAddressPage(driver);
	 
	 customerInforPage = addressPage.openCustomerInfoRPage(driver);
	 
	 myProductReviewPage = customerInforPage.openMyProductReview(driver);
  }
  
  @Test
  public void User_05_Switch_Role() {
	  
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



	
