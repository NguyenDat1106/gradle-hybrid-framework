package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailAddressTextBox(String existingEmail) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, existingEmail);
		
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, validPassword);
		
	}

	public void inputToConfirmPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, validPassword);
		
	}

	public MyDashboardPageObject ClickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}

}
