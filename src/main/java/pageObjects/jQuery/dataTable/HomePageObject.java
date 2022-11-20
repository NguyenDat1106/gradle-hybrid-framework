package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getvalueEachRowAtAllpage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size" +totalPage );
		
		List<String> allRowValueAllPage = new ArrayList<String>();
				
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());

			}
		}
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumNameAtRowNumber(String columName, String rowNumber, String value) {
		
		// Colun Index dựa vào tên cột
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		
		// Sendkey vào dòng nào
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columIndex));
	}

	public void selectDropdowByColumNameAtRowNumber(String columName, String rowNumber, String valueToSelect) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;

		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		selectItemDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

		
	}

	public void checkToCheckboxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		
	}

	public void unCheckToCheckboxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		
	}

	
}
