  package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.upLoadFile.HomePageObject;
import pageObjects.jQuery.upLoadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String vietnam = "vietnam.jpg";
	String thailan = "thailan.jpg";
	String indonesia = "indonesia.jpg";
	
	String[] multilpeFileName = {vietnam, thailan, indonesia};

	@Parameters({"browser", "url"})
	@BeforeClass 
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
} 
	@Test
  public void Upload_01_One_File_Per_Time() {
	  //step 01 - load single file 
	homePage.uploadMultipleFiles(driver, vietnam);
	// step 01 - verify single file loaded success
	Assert.assertTrue(homePage.isFileLoadedByName(vietnam));
	// step 03 - click to start button
	homePage.ClickToStartButton();
	// step 04 verify single file uploaded success
	Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnam));
	// step 05 verify single image uploaded success
	Assert.assertTrue(homePage.isFileImageUploadedByName(vietnam));

  }
  @Test
  public void Upload_02_Multiple_File_Per_Time() {
	  homePage.refreshToPage(driver);
	  //step 01 - load multiple file 
		homePage.uploadMultipleFiles(driver, multilpeFileName);
		// step 01 - verify multiple file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(vietnam));
		Assert.assertTrue(homePage.isFileLoadedByName(thailan));
		Assert.assertTrue(homePage.isFileLoadedByName(indonesia));
		// step 03 - click to start button
		homePage.ClickToStartButton();
		// step 04 verify multiple file uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnam));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(thailan));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(indonesia));
		// step 05 verify multiple image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(vietnam));
		Assert.assertTrue(homePage.isFileImageUploadedByName(thailan));
		Assert.assertTrue(homePage.isFileImageUploadedByName(indonesia));

  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}



	
