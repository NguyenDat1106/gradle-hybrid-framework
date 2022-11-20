package pageUIs.wordpress;

public class UserHomePageUI {
	
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//a[text()='%s']";
	public static final String SREACH_TEXTBOX = "xpath=//div[@class='wp-block-search__inside-wrapper ']/input[@name='s']";
	public static final String SREACH_BUTTON = "xpath=//button[@class='wp-block-search__button wp-element-button']";
	
}
