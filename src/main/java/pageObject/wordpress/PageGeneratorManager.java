package pageObject.wordpress;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminPostSreachPO getAdminPostSreachPage(WebDriver driver) {
		return new AdminPostSreachPO(driver);
	}
	
	public static AdminPostAddnewPO getAdminPostAddnewPage(WebDriver driver) {
		return new AdminPostAddnewPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}
	
	public static UserSreachPostPO getUserSreachPostPage(WebDriver driver) {
		return new UserSreachPostPO(driver);
	}
	
	}

