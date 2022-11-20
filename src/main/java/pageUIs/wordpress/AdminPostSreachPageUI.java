package pageUIs.wordpress;

public class AdminPostSreachPageUI {
	
	public static final String ADD_NEW_BUTYON = "xpath=//a[@class='page-title-action']";
	public static final String SREACH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SREACH_POSTS_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class,'striped table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'striped table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'striped table-view-list posts')]/tbody/tr/th//label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACCTION_DROPDOWN = "xpath=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "xpath=//input[@id='doaction']";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//td[@class='colspanchange' and text()='%s']";
	
}
