package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoLoginFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(name = "login")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(className = "btn-link-blue")
	WebElement login;

	public AutoLoginFactory(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void AutoLoginFactory1(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void AutoLoginFactory11(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	// Set user name in textbox
	public void setUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	// Click on login button
	public void clickLogin() {
		login.click();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void loginToAutoQA(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();

	}
}
