package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoHomePageFactory {

	WebDriver driver;
	//WebElement actualuser = driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a"));
	@FindBy(xpath = "//*[@id='header_user_menu_parent']/a")
	WebElement homePageName;

	public AutoHomePageFactory(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Get the User name from Home Page
	public String getHomePageDashboardName() {
		return homePageName.getText();
	}
}
