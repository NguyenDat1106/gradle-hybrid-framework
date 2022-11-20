package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserSearchPageObject {
	private WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.driver.toString());
	}
}
