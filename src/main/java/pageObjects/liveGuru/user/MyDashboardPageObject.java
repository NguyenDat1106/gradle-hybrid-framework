package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver; 
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTERSUCCESSMESSAGE);
		return getElementText(driver, MyDashboardPageUI.REGISTERSUCCESSMESSAGE);
	}

	public void clickToAccount() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_TEXTBOX);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_TEXTBOX);
		
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGINSUCCESSMESSAGE);
		return getElementText(driver, MyDashboardPageUI.LOGINSUCCESSMESSAGE);
	}
	
	public String getLoginFalseMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGINFALSEMESSAGE);
		return getElementText(driver, MyDashboardPageUI.LOGINFALSEMESSAGE);
	}

}
