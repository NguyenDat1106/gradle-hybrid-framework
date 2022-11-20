  package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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


public class Level_12_Assert_Verify extends BaseTest {
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
	

	firstName = "Automation";
	lastName = "FC";
	Password = "123456";
	Email = "afc" + generateFakeNumber() + "@mail.vn";
	
	    
} 
  @Test
  public void User_01_Register_Login() {
	  registerPage = homePage.openRegisterLink();  
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(Email);
	  registerPage.inputToPasswordTextbox(Password);
	  registerPage.inputToConfirmPasswordTextbox(Password);
	  
	  registerPage.clickToRegisterButton();
	  
	  verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	  homePage = registerPage.clickToLogoutLink();
	 
	  loginPage = homePage.openLoginLink();
	  
	  loginPage.inputToEmailTextbox(Email);
	  loginPage.inputToPasswordTextbox(Password);
	  
	  homePage = loginPage.clickToLoginButton();
	  verifyTrue(homePage.isMyAccountLinkDisplayed());

	  customerInforPage = homePage.openMyAccountPage();
	  verifyTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
  
  
  public void User_02_Switch_Page() {
	  
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
  
 
  public void User_03_Dynamic_Page_01() {

	// My Product Review -> Reward Point
	 rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points"); 
	 
	 // Reward Point -> Address
	 addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
	
	 // Address -> Reward Point
	 rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
	 
	 // Reward Point -> My Product Review
	 myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
	  
	 customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
  }
  
  
  public void User_03_Dynamic_Page_02() {
	  
	  customerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
	  myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

	// My Product Review -> Reward Point
	  myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points"); 
	  rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

	 // Reward Point -> Address
	  rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getUserAddressPage(driver);

	 // Address -> Reward Point
	  addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
	  rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

	 // Reward Point -> My Product Review
	  rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
	  myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

	  myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
	  customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
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



	
