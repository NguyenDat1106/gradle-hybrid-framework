package pageObject.liveguru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AdminManageCustomersUI;

public class AdminManageCustomersPageObject extends BasePage {
	WebDriver driver;

	public AdminManageCustomersPageObject(WebDriver driver) {
		this.driver = driver;
}

	public boolean isManageCustomersDisplayed() {
		waitForElementVisible(driver, AdminManageCustomersUI.CUSTOMERS_HEADER);
		return isElementDisplayed(driver, AdminManageCustomersUI.CUSTOMERS_HEADER);
		
	}

	public void enterToHeaderTextboxByLabel(String columName, String rowNumber, String value) {
		int columIndex = getElementSize(driver, AdminManageCustomersUI.HEADER_TEXTBOX_BY_LABEL, columName) + 1;
		waitForElementVisible(driver, AdminManageCustomersUI.INPUT_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		sendkeyToElement(driver, AdminManageCustomersUI.INPUT_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columIndex));
		

	}

	public void ClickToSearchAtManageCustomers() {
		waitForElementClickable(driver, AdminManageCustomersUI.CLICK_BUTTON_SEARCH_AT_MANAGE);
		clickToElement(driver, AdminManageCustomersUI.CLICK_BUTTON_SEARCH_AT_MANAGE);
	}

	public boolean sucessEmailTextboxManage() {
		waitForElementVisible(driver, AdminManageCustomersUI.SCUSSE_EMAIL_TEXTBOX_MANAGE);
		return isElementDisplayed(driver, AdminManageCustomersUI.SCUSSE_EMAIL_TEXTBOX_MANAGE);
		
	}

	public void ClickToLogout() {
		waitForElementClickable(driver, AdminManageCustomersUI.CLICK_TO_LOGOUT);
		clickToElement(driver, AdminManageCustomersUI.CLICK_TO_LOGOUT);
	}

}
