package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	 WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(WebDriver driver, String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
		
	}

	public void enterToPasswordTextbox(WebDriver driver2, String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_TEXTBOX);
		clickToElement(driver, AdminLoginPageUI.LOGIN_TEXTBOX);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
}
