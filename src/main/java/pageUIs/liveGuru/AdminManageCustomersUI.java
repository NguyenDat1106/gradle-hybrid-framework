package pageUIs.liveGuru;

public class AdminManageCustomersUI {
	
	public static final String CUSTOMERS_HEADER = "xpath=//div[@id='anchor-content']/div//h3[@class='icon-head head-customer']";
	public static final String POPUP_MANAGE = "xpath=//a[@title='close']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//tr[@class='headings']//a[@name='%s']/ancestor::th/preceding-sibling::th";
	public static final String INPUT_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath=//table[@class='data']//tr[%s]/th[%s]/div/input";
	public static final String CLICK_BUTTON_SEARCH_AT_MANAGE = "xpath=//button[@title='Search']/span";
	public static final String SCUSSE_EMAIL_TEXTBOX_MANAGE = "xpath=//div[@id='page:main-container']//h3[contains(text(),'Manage Customers')]";
	public static final String DROPDOWN_AT_MANAGE_CUSTOMERS = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String CLICK_TO_DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String CLICK_TO_LOGOUT = "xpath=//a[@class='link-logout']";
}
