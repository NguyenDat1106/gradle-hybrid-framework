package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver; 
	}
	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to FirstName textbox with value is {0}")
	public void inputToFirstNameTextbox(String firstName) {
	waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
	sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}
	
	@Step("Enter to LastName textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
	waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
	sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}
	
	@Step("Enter to EmailAddress textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
			
		
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
	waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Enter to ConfirmPassword textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
	waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}
	@Step("Verify register success message is displayed")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	@Step("Click to Logout link")
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR__MASSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR__MASSAGE);
	}
	
	
	
	
	
	
	
}
