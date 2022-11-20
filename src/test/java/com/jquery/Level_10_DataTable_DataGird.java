  package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGird extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser", "url"})
	@BeforeClass 
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
    
} 
	
  public void Table_01_Paging() {
	
	  homePage.openPagingByPageNumber("10");
	  homePage.sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActived("18"));
	  
	  homePage.openPagingByPageNumber("20");
	  homePage.sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActived("7"));

	  homePage.openPagingByPageNumber("7");
	  homePage.sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActived("20"));

	  homePage.openPagingByPageNumber("18");
	  homePage.sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActived("10"));
	  

  }
  
  
  public void Table_02_Enter_To_Header() {
	  homePage.refreshToPage(driver);
	  
	  homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
	  homePage.enterToHeaderTextboxByLabel("Females", "338282");
	  homePage.enterToHeaderTextboxByLabel("Males", "349238");
	  homePage.enterToHeaderTextboxByLabel("Total", "687522");
	  homePage.sleepInSecond(3);
	  
	  homePage.enterToHeaderTextboxByLabel("Country", "Aruba");
	  homePage.enterToHeaderTextboxByLabel("Females", "750");
	  homePage.enterToHeaderTextboxByLabel("Males", "756");
	  homePage.enterToHeaderTextboxByLabel("Total", "1504");
	  homePage.sleepInSecond(3);
  }
 

  public void Table_03_Enter_To_Header() {
	  // Đọc dữ liệu của file country.txt ra
	  // lưu vào 1 List<String> = Expected Value = expectedAllCountryValues
	  
	  actualAllCountryValues = homePage.getvalueEachRowAtAllpage();
	  
	  Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
  }
 
  @Test
  public void Table_04_Enter_To_Textbox_At_Any_row() {
	  homePage.clickToLoadButton();
	  homePage.sleepInSecond(3);

	  // value để nhập liệu - tham số 1
	  // row number: tai row nào
	  // Ex: Nhập vào textbox tại dòng số 3/ 5/ 2
	  // Colum name: Album/ Artist/ Year/ Price
//	  homePage.enterToTextboxByColumNameAtRowNumber("Album", "2", "Micheal 97");
//	  
//	  homePage.enterToTextboxByColumNameAtRowNumber("Artist", "4", "Micheal Jackson");
//	  
//	  homePage.enterToTextboxByColumNameAtRowNumber("Year", "3", "1997");
//	  
//	  homePage.enterToTextboxByColumNameAtRowNumber("Price", "5", "150");
//	  
	  homePage.selectDropdowByColumNameAtRowNumber("Origin", "5", "Korea");
//	  homePage.sleepInSecond(1);
//	  
//	  homePage.selectDropdowByColumNameAtRowNumber("Origin", "3", "Hong Kong");
//	  homePage.sleepInSecond(1);
//	  
//	  homePage.selectDropdowByColumNameAtRowNumber("Origin", "1", "Japan");
//	  homePage.sleepInSecond(1);
//	  
//	  homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "3");
//	  homePage.checkToCheckboxByColumNameAtRowNumber("With Poster?", "5");
//	  
//	  homePage.unCheckToCheckboxByColumNameAtRowNumber("With Poster?", "1");
//	  homePage.unCheckToCheckboxByColumNameAtRowNumber("With Poster?", "2");
//	  homePage.unCheckToCheckboxByColumNameAtRowNumber("With Poster?", "4");
	  
	  homePage.clickToIconByRowNumber("1", "Remove Current Row");
	  homePage.sleepInSecond(1);
	  
	  homePage.clickToIconByRowNumber("1", "Insert Row Above");
	  homePage.sleepInSecond(1);
	  
	  homePage.clickToIconByRowNumber("3", "Move Up");
	  homePage.sleepInSecond(1);
	  
	  homePage.clickToIconByRowNumber("5", "Remove Current Row");
	  homePage.sleepInSecond(1);
	  homePage.clickToIconByRowNumber("4", "Remove Current Row");
	  homePage.sleepInSecond(1);
	  homePage.clickToIconByRowNumber("3", "Remove Current Row");
	  homePage.sleepInSecond(1);
	  homePage.clickToIconByRowNumber("2", "Remove Current Row");
	  homePage.sleepInSecond(1);
	  homePage.clickToIconByRowNumber("1", "Remove Current Row");
	  homePage.sleepInSecond(1);

  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}



	
