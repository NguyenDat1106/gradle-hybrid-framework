package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {

	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT, postBody);
	}



	public boolean isPostInforDisplayedWithPostAuthor(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTitle, authorName);
	}



	public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}
	
	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}



	public boolean isPostInforUnDisplayedWithPostTitle(String editPostTitle) {
		//waitForElementInVisible(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}



	public void enterToSreachTextbox(String editPostTitle) {
		waitForElementVisible(driver, UserHomePageUI.SREACH_TEXTBOX, editPostTitle);
		sendkeyToElement(driver, UserHomePageUI.SREACH_TEXTBOX, editPostTitle);
	}

	public UserSreachPostPO clickSreachButton() {
		waitForElementClickable(driver, UserHomePageUI.SREACH_BUTTON);
		clickToElement(driver, UserHomePageUI.SREACH_BUTTON);
		return PageGeneratorManager.getUserSreachPostPage(driver);
	}

}
