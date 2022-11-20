package pageUIs.wordpress;

public class UserPostDetailPageUI {
	
	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//h1[text()='%s']//following-sibling::div//a[text()='%s']";
}
