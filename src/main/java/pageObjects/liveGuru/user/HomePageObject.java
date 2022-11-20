package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject ClickToMyAccountLink() {
		waitForElementClickable(driver, pageUIs.liveGuru.HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, pageUIs.liveGuru.HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
