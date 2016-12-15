package testsPOM;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class NoPOMTestAutoLogin {
	
//	@After
//	public void cleanup() {
//		driver.quit();
//	}

		/**
		 * This test case will login in http://rozetka.com.ua/
		 * Login to application
		 * Verify the home page using Dashboard message
		 * @throws InterruptedException 
		 */
		//@SuppressWarnings("deprecation")
		@Test
		public void test_Home_Page_Appear_Correct() throws InterruptedException{
			System.setProperty("webdriver.chrome.driver", "E:\\dev\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://rozetka.com.ua/");
			//Find user name and fill user name
			driver.findElement(By.name("signin")).click();
		    driver.findElement(By.name("login")).sendKeys("test666@mail.ua");
		    //find password and fill it
		    driver.findElement(By.name("password")).sendKeys("P666password");
		    //click login button
		    driver.findElement(By.className("btn-link-blue")).click(); 
		    Thread.sleep(4000);
		    String text = driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).getText();
		    //verify login success
			//Assert.assertTrue(!homeText.toLowerCase().contains("profile"));
		    String username = "Andrii";

			System.out.println(text);
			Assert.assertEquals(username, text);
			driver.close();
		}
		
	}


