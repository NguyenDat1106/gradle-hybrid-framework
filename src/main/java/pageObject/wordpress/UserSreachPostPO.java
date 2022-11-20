package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserSreachPostPageUI;

public class UserSreachPostPO extends BasePage {
	WebDriver driver;

	public UserSreachPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String mesaage) {
		waitForElementVisible(driver, UserSreachPostPageUI.NOTHING_FOUND_MESSAGE, mesaage);
		return isElementDisplayed(driver, UserSreachPostPageUI.NOTHING_FOUND_MESSAGE, mesaage);
	}
}
