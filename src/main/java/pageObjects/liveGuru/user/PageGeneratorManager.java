package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import pageObject.liveguru.admin.AdminLoginPageObject;
import pageObject.liveguru.admin.AdminManageCustomersPageObject;

public class PageGeneratorManager {
public static HomePageObject getHomePage(WebDriver driver) {
	return new HomePageObject(driver);
}

public static LoginPageObject getLoginPage(WebDriver driver) {
	return new LoginPageObject(driver);
}

public static RegisterPageObject getRegisterPage(WebDriver driver) {
	return new RegisterPageObject(driver);
}

public static MyDashboardPageObject getDashboardPage(WebDriver driver) {
	return new MyDashboardPageObject(driver); 
}

public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
	return new AdminLoginPageObject(driver);

}

public static AdminManageCustomersPageObject getAdminManageCustomersPage(WebDriver driver) {
	return new AdminManageCustomersPageObject(driver);
}


}
