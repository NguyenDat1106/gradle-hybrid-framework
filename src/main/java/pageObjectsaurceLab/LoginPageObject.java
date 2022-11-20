package pageObjectsaurceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saurceLab.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public ProductPageObject clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGINBUTTON);
		clickToElement(driver, LoginPageUI.LOGINBUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

}
