package equivalenceclasses;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EquivalenceClasses {
	private WebDriver driver = null;

	@Before
	public void preinit() {
		System.setProperty("webdriver.chrome.driver", "E:\\dev\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://my.rozetka.com.ua");
	}

	@After
	public void cleanup() {
		driver.quit();
	}


		@Test
		public void shouldCheckValidLogin() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
			boolean present;
			try {
				driver.findElement(By.className("popup-auth"));
				present = true;
			} catch (NoSuchElementException e) {
				present = false;
			}
			System.out.println(present + "popup is visible");
			driver.findElement(By.name("login")).sendKeys("test666@mail.ua");
			driver.findElement(By.name("password")).sendKeys("P666password");
			driver.findElement(By.name("auth_submit")).click();
			Thread.sleep(4000);
			driver.manage().window().maximize();
			String username = "Andrii";
			WebElement actualuser = driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a"));
			String act = actualuser.getText();
			System.out.println(act);
			Assert.assertEquals(username, act);

		}
	

		@Test
		public void shouldCheckNotValidLogin() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
			boolean present;
			try {
				driver.findElement(By.className("popup-auth"));
				present = true;
			} catch (NoSuchElementException e) {
				present = false;
			}
			System.out.println(present + "popup is visible");
			driver.findElement(By.name("login")).sendKeys("Vasia@gmail.com");
			driver.findElement(By.name("password")).sendKeys("");
			driver.findElement(By.name("auth_submit")).click();
			Thread.sleep(4000);
			String passwdexpectedcolor = "rgba(255, 214, 214, 1)";
			WebElement passwdfield = driver
					.findElement(By.xpath("//*[@id='popup_signin']/div[1]/div[2]/div[1]/div[1]/input"));
			Thread.sleep(4000);
			String currentcolorpasswd = passwdfield.getCssValue("background-color");
			Assert.assertEquals(passwdexpectedcolor, currentcolorpasswd);

		}
	}
	


