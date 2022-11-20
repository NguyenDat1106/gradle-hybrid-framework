package commons;

import org.openqa.selenium.WebDriver;

import page.objects.nopCommerce.user.UserAddressPageObject;
import page.objects.nopCommerce.user.UserCustomerInforPageObject;
import page.objects.nopCommerce.user.UserHomePageObject;
import page.objects.nopCommerce.user.UserLoginPageObject;
import page.objects.nopCommerce.user.UserMyProductReviewPageObject;
import page.objects.nopCommerce.user.UserRegisterPageObject;
import page.objects.nopCommerce.user.UserRewardPointPageObject;
import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
	return new UserRegisterPageObject(driver);
}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
	return new UserCustomerInforPageObject(driver);
}
	
	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	
	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	
	}

