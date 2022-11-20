package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSreachPageUI;

public class AdminPostSreachPO extends BasePage {

	WebDriver driver;

	public AdminPostSreachPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddnewPO clickToAddnewButton() {
		waitForElementClickable(driver, AdminPostSreachPageUI.ADD_NEW_BUTYON);
		clickToElement(driver, AdminPostSreachPageUI.ADD_NEW_BUTYON);
		return PageGeneratorManager.getAdminPostAddnewPage(driver);
	}

	public void enterToSreachTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSreachPageUI.SREACH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSreachPageUI.SREACH_TEXTBOX, postTitle);
	}

	public void clickToSreachPostsTextbox() {
		waitForElementClickable(driver, AdminPostSreachPageUI.SREACH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSreachPageUI.SREACH_POSTS_BUTTON);
		
	}

	public boolean isPostSreachTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSreachPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) +1;
		waitForElementVisible(driver, AdminPostSreachPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSreachPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddnewPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSreachPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		clickToElement(driver, AdminPostSreachPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
		return PageGeneratorManager.getAdminPostAddnewPage(driver);
	}

	public void selectPostCheckboxByTitle(String editPostTitle) {
		waitForElementClickable(driver, AdminPostSreachPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSreachPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
	}

	public void selectTextItemActionropdown(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSreachPageUI.ACCTION_DROPDOWN);
		selectItemDefaultDropdown(driver, AdminPostSreachPageUI.ACCTION_DROPDOWN, dropdownItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSreachPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSreachPageUI.APPLY_BUTTON);
	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSreachPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSreachPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSreachPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSreachPageUI.NO_POST_FOUND_MESSAGE, message);
	}

	

}
