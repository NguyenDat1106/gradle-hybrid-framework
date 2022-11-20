package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject ClickToCreateAnAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToFirstNameTextBox(String existingEmail) {
		waitForElementVisible(driver, LoginPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.FIRST_NAME_TEXTBOX, existingEmail);
		
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, validPassword);
		
	}

	public MyDashboardPageObject ClickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}

}
