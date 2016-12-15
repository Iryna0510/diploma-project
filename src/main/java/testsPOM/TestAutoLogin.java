package testsPOM;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import forPOM.AutoHomePage;
import forPOM.AutoLogin;

public class TestAutoLogin {

	WebDriver driver;
	AutoLogin objLogin;
	AutoHomePage objHomePage;
	
	@Before
	public void setup(){
		//System.setProperty("webdriver.chrome.driver", 
		          // "E:\\chrome_driver");
		System.setProperty("webdriver.chrome.driver","E:\\dev\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://my.rozetka.com.ua");
	}
	@After
	public void cleanup() {
		driver.quit();
	}
 
	/**
	 * This test case will login in https://my.rozetka.com.ua
	 * Login to application
	 * Verify the home page using Dashboard message
	 * @throws InterruptedException 
	 */
	@Test
	public void test_Home_Page_Appear_Correct() throws InterruptedException{
		//Create Login Page object
	objLogin = new AutoLogin(driver);
	//login to application
	objLogin.loginToAutoQA("test666@mail.ua", "P666password");
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println("good");
	// go the next page
	objHomePage = new AutoHomePage(driver);
//	Thread.sleep(4000);
	//Verify home page
	String text = objHomePage.getHomePageDashboardName().toString();
	Thread.sleep(4000);
	

	//Assert.assertTrue("Item Found", objHomePage.getHomePageDashboardName().contains(text));
	Assert.assertTrue(objHomePage.getHomePageDashboardName().toLowerCase().contains(text));
	System.out.println(text);
	}	
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	}

