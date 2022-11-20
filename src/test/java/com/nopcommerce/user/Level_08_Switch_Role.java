  package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userEmail, userPassword, adminEmail, adminPassword;

	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	userHomePage = PageGeneratorManager.getUserHomePage(driver);
	driver.get(GlobalConstants.PORTAL_DEV_URL);

	userEmail = "afc123@gmail.net";
	userPassword = "123456";
	adminEmail = "admin@yourstore.com";
	adminPassword = "admin";
	    
} 
  @Test
  public void Role_01_User() {
	  userLoginPage = userHomePage.openLoginLink();
	  
	  // login as user role
	  userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  // HomePage -> Customer info
	  userCustomerInforPage = userHomePage.openMyAccountPage();
	  
	  // Customer info -> click logout -> home page
	  userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
	  
	  // User home page -> open login page (admin)
	  userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  // login as Admin
	  adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
	  Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	  
	  // Dash page -> click logout -> login page(admin)
	  adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);

  }
  
  @Test
  public void Role_02_Admin() {
	  // login page(admin) -> open user url -> home page
	  adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  
	  userLoginPage = userHomePage.openLoginLink();
	  
	// login as user role
	userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
	Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		  
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



	
