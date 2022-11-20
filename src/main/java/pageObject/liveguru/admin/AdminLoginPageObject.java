package pageObject.liveguru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageUIs.liveGuru.AdminLoginPageUI;
public class AdminLoginPageObject extends BasePage {
	 WebDriver driver;

		public AdminLoginPageObject(WebDriver driver) {
			this.driver = driver;
}
		public void inputToUsernameTextbox(String adminEmail) {
			waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
			sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
		}
		
		public void inputPasswordTextbox(String adminPassword) {
			waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
			sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		}
		
		public AdminManageCustomersPageObject clickToLoginButton() {
			waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
			clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
			return PageGeneratorManager.getAdminManageCustomersPage(driver);
		}
		

		public AdminManageCustomersPageObject loginAsAdmin(String adminEmail, String adminPassword) {
			inputToUsernameTextbox(adminEmail);
			inputPasswordTextbox(adminPassword);
			return clickToLoginButton();
		}
}
