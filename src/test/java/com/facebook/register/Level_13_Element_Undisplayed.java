  package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Facebook.LoginPageObject;
import pageObject.Facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass 
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
} 
	@Test
	public void TC_01_Verify_Element_Displayed() {
	
		loginPage.clickToCreateNewAccount();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		
  }
	
	@Test
	public void TC_02_Verify_Element_In_Displayed() {
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextBoxDisplayed());

		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextBoxUndisplayed());
		
	  }
	
	@Test
	public void TC_03_Verify_Element_Not_Displayed() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		
		verifyTrue(loginPage.isConfirmEmailAddressTextBoxUndisplayed());

		
	  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}



	
