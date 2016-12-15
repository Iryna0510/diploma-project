package testsPOM;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageFactory.AutoHomePageFactory;
import pageFactory.AutoLoginFactory;

public class TestAutoLoginWithPageFactory {

	WebDriver driver;
	AutoLoginFactory objLogin;
	AutoHomePageFactory objHomePage;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\dev\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://my.rozetka.com.ua");
	}

	@After
	public void cleanup() {
		driver.quit();
	}

	/**
	 * This test go to http://autoqa.pp.ua/wp-login.php Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test
	public void test_Home_Page_Appear_Correct() throws InterruptedException {
		// Create Login Page object
		objLogin = new AutoLoginFactory(driver);
		// login to application
		objLogin.loginToAutoQA("test666@mail.ua", "P666password");
		// go the next page
		Thread.sleep(5000);
		objHomePage = new AutoHomePageFactory(driver);
		String text = objHomePage.getHomePageDashboardName();
		Thread.sleep(4000);

		String username = "Andrii";

		System.out.println(text);
		Assert.assertEquals(username, text);

	}

}
