  package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
@Listeners
public class Level_16_Share_Data_C extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	public static  String Email, Password;
	
	

	@Parameters("browser")
	@BeforeClass 
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getUserHomePage(driver);
	
	Password = Common_01_Register_End_User.Email;
	Email =  Common_01_Register_End_User.Password;
	
	  log.info("Pre-Condition - Step 01: Navigate to Login Page");
	  loginPage = homePage.openLoginLink();
	  
	  log.info("Pre-Condition - Step 02: Set cookie and reload page");
	  loginPage.setCookie(driver, Common_01_Register_Cookie.loggedCookie);
	  loginPage.refreshToPage(driver);
	  
	  log.info("Pre-Condition - Step 03: verify to My Account Link is displayed");
	  verifyTrue(homePage.isMyAccountLinkDisplayed());
	  
		    
} 
  
  
  @Test
  	public void Sreach_01_Empty_Data() {
	  
	  
  }
  
  
  @Test
  	public void Sreach_02_Relative_Product_Name() {
	  
	  
  }
  
  @Test
  	public void Sreach_03_Absolute_Product_Name() {
	  
	  
  }
  
  @Test
  	public void Sreach_04_Parent_Category() {
	  
	  
  }
  
  @Test
  	public void Sreach_05_Incorrect_Manufactorer() {
	  
	  
  }
  
  @Test
  	public void Sreach_06_Correct_Manufactorer() {
	  
	  
  }
  
  

  @AfterClass
  	public void afterClass() {
	  driver.quit();
  }


}



	
