  package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsaurceLab.LoginPageObject;
import pageObjectsaurceLab.PageGeneratorManager;
import pageObjectsaurceLab.ProductPageObject;
@Listeners
public class Level_19_Sort_Asc_Desc extends BaseTest {
	 WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

	@Parameters({"browser", "appUrl"})
	@BeforeClass 
	 public void beforeClass(String browserName, String saurcelapUrl) {
	driver = getBrowserDriver(browserName, saurcelapUrl);
	loginPage = PageGeneratorManager.getLoginPage(driver);
	
	loginPage.enterToUserNameTextbox("standard_user");
	
	loginPage.enterToPasswordTextbox("secret_sauce");
	
	productPage = loginPage.clickLoginButton();
	
	
} 

  public void Sort_01_Name() {
	  //Ascending
	  productPage.selectItemProductSortDropdown("Name (A to Z)");
	  productPage.sleepInSecond(3);
	  
	  Assert.assertTrue(productPage.isProductNameSortByAscending());
	  //Descending
	  productPage.selectItemProductSortDropdown("Name (Z to A)");
	  productPage.sleepInSecond(3);
	  
	  Assert.assertTrue(productPage.isProductNameSortByDescending());
  }
  
  @Test
  public void Sort_02_Price() {
	//Ascending
	  productPage.selectItemProductSortDropdown("Price (low to high)");
	  productPage.sleepInSecond(3);
	  
	  Assert.assertTrue(productPage.isProductPriceSortByAscending());
	  
	  //Descending
	  productPage.selectItemProductSortDropdown("Price (high to low)");
	  productPage.sleepInSecond(3);
	  
	  Assert.assertTrue(productPage.isProductPriceSortByDescending());
  }
  
  
  
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	 closeBrowserAndDriver();
  }


}



	
