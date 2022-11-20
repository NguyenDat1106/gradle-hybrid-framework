package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameEorrrMesaage;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameEorrrMesaage;
	
	@FindBy(id = "Email-error")
	private WebElement emailEorrrMesaage;
	
	@FindBy(id = "Password-error")
	private WebElement passwordEorrrMesaage;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordEorrrMesaage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMesaage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameEorrrMesaage);
		return getElementText(driver, firstNameEorrrMesaage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameEorrrMesaage);
		return getElementText(driver, lastNameEorrrMesaage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailEorrrMesaage);
		return getElementText(driver, emailEorrrMesaage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordEorrrMesaage);
		return getElementText(driver, passwordEorrrMesaage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordEorrrMesaage);
		return getElementText(driver, confirmPasswordEorrrMesaage);
	}

	public void inputToFirstNameTextbox(String firstName) {
	waitForElementVisible(driver, firstNameTextbox);
	sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
	waitForElementVisible(driver, lastNameTextbox);
	sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, emailTextbox);
	sendkeyToElement(driver, emailTextbox, emailAddress);
			
		
	}

	public void inputToPasswordTextbox(String password) {
	waitForElementVisible(driver, passwordTextbox);
	sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
	waitForElementVisible(driver, confirmPasswordTextbox);
	sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMesaage);
		return getElementText(driver, registerSuccessMesaage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}
}
