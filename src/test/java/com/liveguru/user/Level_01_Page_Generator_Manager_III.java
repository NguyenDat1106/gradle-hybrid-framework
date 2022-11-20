package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.liveguru.admin.AdminLoginPageObject;
import pageObject.liveguru.admin.AdminManageCustomersPageObject;
import pageObjects.liveGuru.user.HomePageObject;
import pageObjects.liveGuru.user.LoginPageObject;
import pageObjects.liveGuru.user.MyDashboardPageObject;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageObjects.liveGuru.user.RegisterPageObject;


public class Level_01_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminManageCustomersPageObject adminManageCustomerspage;
	private String firstName, lastName, existingEmail, validPassword, adminEmail, adminPassword;
	@Parameters("browser")
	@BeforeClass 
	 public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	homePage = PageGeneratorManager.getHomePage(driver);
	driver.get("http://live.techpanda.org/");
	firstName = "Mientay";
	lastName = "FC";
	validPassword = "123456";
	//existingEmail = "mientay" + generateFakeNumber() + "@mail.vn";
	existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
	adminEmail = "user01";
	adminPassword = "guru99com";
} 
  @Test
  public void User_01_Register_To_System() {
	 loginPage = homePage.ClickToMyAccountLink();
	 
	 registerPage = loginPage.ClickToCreateAnAccountButton();
	 
	 registerPage.inputToFirstNameTextBox(firstName);
	 registerPage.inputToLastNameTextBox(lastName);
	 registerPage.inputToEmailAddressTextBox(existingEmail);
	 registerPage.inputToPasswordTextbox(validPassword);
	 registerPage.inputToConfirmPasswordTextbox(validPassword);
	 
	 myDashboardPage = registerPage.ClickToRegisterButton();
	 
	 Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
	 
	 myDashboardPage.clickToAccount();
	 homePage = myDashboardPage.clickToLogoutLink();
	 
	 homePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL_LIVEGURU);
	 adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	 
	 adminManageCustomerspage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
	 Assert.assertTrue(adminManageCustomerspage.isManageCustomersDisplayed());
	 
	 adminLoginPage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL_LIVEGURU_MANAGE);
	 adminManageCustomerspage = PageGeneratorManager.getAdminManageCustomersPage(driver);
	 
	 adminManageCustomerspage.enterToHeaderTextboxByLabel("email", "2", existingEmail);
	 
	 adminManageCustomerspage.ClickToSearchAtManageCustomers();
	 
	Assert.assertTrue(adminManageCustomerspage.sucessEmailTextboxManage());
	
	adminManageCustomerspage.ClickToLogout();

	adminManageCustomerspage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL_LIVEGURU);
	adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
  }
  
  @Test
  public void User_03_Login_To_System() {
	  
	  	adminLoginPage.openPageUrl(driver, GlobalConstants.USER_LOGIN_DEV_URL_LIVEGURU);
		homePage = PageGeneratorManager.getHomePage(driver);
	  
		 loginPage = homePage.ClickToMyAccountLink();
		 
		 loginPage.inputToFirstNameTextBox(existingEmail);
		 
		 loginPage.inputToPasswordTextbox(validPassword);
		 
		 myDashboardPage = loginPage.ClickToLoginButton();
		 
		Assert.assertEquals(myDashboardPage.getLoginSuccessMessage(), "Hello, Mientay FC!");

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



	
