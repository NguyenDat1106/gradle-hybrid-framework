package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddnewPageUI;

public class AdminPostAddnewPO extends BasePage {

	WebDriver driver;

	public AdminPostAddnewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddnewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddnewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddnewPostBody(String postBodyvalue) {
		waitForElementClickable(driver, AdminPostAddnewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddnewPageUI.BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX, postBodyvalue);
		
	}
	
	public void enterToEditPostBody(String postBodyvalue) {
		waitForElementClickable(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		
		waitForElementVisible(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX, postBodyvalue);
		
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddnewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddnewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddnewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddnewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishMessage);
	}

	public AdminPostSreachPO openSreachPostPageUrl(String sreachPostUrl) {
		openPageUrl(driver, sreachPostUrl);
		return PageGeneratorManager.getAdminPostSreachPage(driver);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddnewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddnewPageUI.PRE_PUBLISH_BUTTON);
		
	}

}
