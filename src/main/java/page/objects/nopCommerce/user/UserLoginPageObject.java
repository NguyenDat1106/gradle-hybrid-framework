package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage  {
private WebDriver driver;

public UserLoginPageObject(WebDriver driver) {
	this.driver = driver;
}
@Step("Click to Login button")
public UserHomePageObject clickToLoginButton() {
	waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getUserHomePage(driver);
}
@Step("Enter to EmailAddress textbox with value is {0}")
public void inputToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
}
@Step("Enter to Password textbox with value is {0}")
public void inputToPasswordTextbox(String password) {
	waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);	
}

public String getErrorMessageUnsuccessfull() {
	waitForElementVisible(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	return getElementText(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
}

public String getErrorMessageAtEmailTextbox() {
	waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
}

public UserHomePageObject loginAsUser(String emailAddress, String password) {
	inputToEmailTextbox(emailAddress);
	inputToPasswordTextbox(password);
	return clickToLoginButton();
}

}

