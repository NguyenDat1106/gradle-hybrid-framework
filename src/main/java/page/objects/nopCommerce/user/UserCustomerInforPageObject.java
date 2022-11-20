package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	 WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver; 
	}

	@Step("Verify Customer Info success message is displayed")
	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}


	

}
