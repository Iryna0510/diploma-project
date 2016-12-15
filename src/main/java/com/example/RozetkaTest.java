package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Iterables;

public class RozetkaTest {
	private WebDriver driver = null;

	// private static final String SERVER_URL =
	// "http://192.168.17.11:8080/UMS/";
	// //private WebDriver driver;
	// private static final String SERVICE_NOT_ACTIVE = "rgba(233, 67, 67, 1)";
	// private static final String SERVICE_INITIAL_STATE = "rgba(178, 180, 191,
	// 1)";

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
	public void shouldCheckCorrectLogin() throws InterruptedException {
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
	public void shouldCheckWrongLogin() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
		boolean present;
		try {
			driver.findElement(By.className("popup-auth"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		System.out.println(present + "popup is visible");
		driver.findElement(By.name("login")).sendKeys("irina05101993@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("auth_submit")).click();
		Thread.sleep(4000);

		boolean present1;
		try {
			driver.findElement(By.className("auth-message"));
			present1 = true;
		} catch (NoSuchElementException e) {
			present1 = false;
		}
		System.out.println(present1 + "Error registration");
		WebElement atr = driver.findElement(By.className("auth-message-text"));
		String actualTitle = atr.getText();
		System.out.println(actualTitle);
		String expectedTitle = "Пользователь с логином irina05101993@gmail.com не зарегистрирован";

		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Registration unsuccessful");

	}

	@Test
	public void shouldCheckCorrectRegistration() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
		boolean present;
		try {
			driver.findElement(By.className("popup-auth"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		System.out.println(present + "popup is visible");
		driver.findElement(By.xpath("//*[@id='popup_signin']/div[2]/div[4]/a")).click();
		driver.findElement(By.name("title")).sendKeys("Andrii");
		driver.findElement(By.name("email")).sendKeys("test666@mail.ua");
		driver.findElement(By.name("password")).sendKeys("P666password");
		driver.findElement(By.xpath("//*[@id='signup_form']/div[4]/span/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("message-confirm-mail")).isDisplayed();
		driver.findElement(By.name("confirm_email")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='personal_information']/div/div/div[1]/div")).isDisplayed();
		Thread.sleep(4000);
	}

	@Test
	public void shouldCheckColorValidationOnRegistrationForm() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
		boolean present;
		try {
			driver.findElement(By.className("popup-auth"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		System.out.println(present + "popup is visible");
		driver.findElement(By.xpath("//*[@id='popup_signin']/div[2]/div[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='signup_form']/div[4]/span/button")).click();

		Thread.sleep(4000);
		String titleexpcolor = "rgba(255, 214, 214, 1)";
		WebElement titlefield = driver.findElement(By.name("title"));
		String titlecurrcolor = titlefield.getCssValue("background-color");

		Assert.assertEquals(titleexpcolor, titlecurrcolor);
		System.out.println(titlecurrcolor);

		String emailexpcolor = "rgba(255, 214, 214, 1)";
		WebElement emailfield = driver.findElement(By.name("email"));
		String emailcurrcolor = emailfield.getCssValue("background-color");

		Assert.assertEquals(emailexpcolor, emailcurrcolor);
		System.out.println(emailcurrcolor);

		String passwordexpcolor = "rgba(255, 214, 214, 1)";
		WebElement passwordfield = driver.findElement(By.name("password"));
		String passwordcurrcolor = passwordfield.getCssValue("background-color");
		Thread.sleep(4000);
		Assert.assertEquals(passwordexpcolor, passwordcurrcolor);
		System.out.println(passwordcurrcolor);

	}

	@Test
	public void shouldCheckColorValidationLoginForm() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='header_user_menu_parent']/a")).click();
		boolean present;
		try {
			driver.findElement(By.className("popup-auth"));
			present = true;

		}

		catch (NoSuchElementException e) {
			present = false;
		}
		driver.findElement(By.name("login")).clear();
		driver.findElement(By.name("password")).clear();

		driver.findElement(By.xpath("//*[@id='popup_signin']/div[1]/div[2]/div[1]/div[2]/div/span/button")).click();
		Thread.sleep(4000);

		String loginexpcolor = "rgba(255, 214, 214, 1)";
		WebElement loginfield = driver.findElement(By.name("login"));
		String currcolorlogin = loginfield.getCssValue("background-color");

		Assert.assertEquals(loginexpcolor, currcolorlogin);

		String passwdexpectedcolor = "rgba(255, 214, 214, 1)";
		WebElement passwdfield = driver
				.findElement(By.xpath("//*[@id='popup_signin']/div[1]/div[2]/div[1]/div[1]/input"));
		Thread.sleep(4000);
		String currentcolorpasswd = passwdfield.getCssValue("background-color");
		Assert.assertEquals(passwdexpectedcolor, currentcolorpasswd);

		System.out.println(present + "popup is visible");
		System.out.println(currcolorlogin);
		System.out.println(currentcolorpasswd);

	}

	@Test
	public void shouldFindElementsByKeyWord() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus k53s");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		driver.findElements(By.className("g-i-tile-catalog"));
		List<WebElement> listElement = driver.findElements(By.partialLinkText("Asus K53SM"));
		for (int i = 0; i < listElement.size(); i++) {
			String elementText = listElement.get(i).getText();
			System.out.println(elementText);
		}
	}

	@Test
	public void shouldGetElementsPrice() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		Thread.sleep(4000);

		driver.findElements(By.className("g-i-tile-catalog"));
		List<WebElement> listElement = driver.findElements(By.className("g-price"));
		for (int i = 0; i < listElement.size(); i++) {
			String elementText = listElement.get(i).getText();
			System.out.println(elementText);
			// Assert.assertEquals(s, elementText);

		}

	}

	@Test
	public void shouldFindElementsBySomePriceArea() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		Thread.sleep(4000);
		WebElement toClearMin = driver.findElement(By.name("price[min]"));
		toClearMin.sendKeys(Keys.CONTROL + "a");
		toClearMin.sendKeys(Keys.DELETE);

		Thread.sleep(4000);
		driver.findElement(By.name("price[min]")).sendKeys("13000");

		WebElement toClearMax = driver.findElement(By.name("price[max]"));
		toClearMax.sendKeys(Keys.CONTROL + "a");
		toClearMax.sendKeys(Keys.DELETE);

		driver.findElement(By.name("price[max]")).sendKeys("15000");

		driver.findElement(By.xpath("//*[@id='sort_price']/div[1]/span/span")).click();
		Thread.sleep(6000);
		driver.manage().window().maximize();
		driver.findElements(By.className("g-i-tile-catalog"));
		List<WebElement> listElement = driver.findElements(By.className("g-price"));

		for (int i = 0; i < listElement.size(); i++) {
			String elementText = listElement.get(i).getText();
			System.out.println(elementText);
			// Assert.assertEquals(s, elementText);
		}
	}

	@Test
	public void shouldCheckElementLocation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus k53s");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		driver.findElements(By.className("g-i-tile-catalog"));
		driver.findElement(By.xpath("//*[@id='image_item195323']")).click();

		WebElement element = driver.findElement(By.xpath("//*[@id='basic_image']/div"));
		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		System.out.println(xcord + ", " + ycord);
	}

	@Test
	public void shouldFindElementsByProcessorType() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus k53s");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		driver.findElement(By.xpath("//*[@id='sort_20862']/li[29]/label/a/span")).click();
	}

	@Test
	public void shouldFindElementsBySomeCategory() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus");
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[1]")).click();
		WebElement select = driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[1]"));
		List<WebElement> options = select.findElements(By.linkText("Телефоны, MP3, GPS"));
		Thread.sleep(5000);
		for (WebElement option : options) {
			if ("Телефоны, MP3, GPS".equals(option.getText()))
				option.click();
			System.out.println(option);
		}

	}

	@Test
	public void shouldMoveElementToBasket() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		driver.findElements(By.className("g-i-tile-catalog"));
		List<WebElement> listElement = driver.findElements(By.className("buy_search"));
		System.out.println("test");
		for (int i = 0; i < listElement.size(); i++) {
			WebElement elementText = listElement.get(1);

			elementText.click();
			Thread.sleep(4000);
		}
	}

	@Test
	public void shouldBeFailed() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='body-header']/div[3]/div/div[1]/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='head_banner_container']/div/div[2]/div")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='body-header']/div[3]/div/div[1]/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.id("deliveries-payments-container")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='body-header']/div[3]/div/div[1]/div[2]/ul/li[4]/a")).click();
		driver.findElement(By.className("c-cols-r-static")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='body-header']/div[3]/div/div[1]/div[2]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id='head_banner_container']/div/div[2]/div/div/div[2]")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='body-header']/div[3]/div/div[1]/div[2]/ul/li[7]/a")).click();
		driver.findElement(By.className("seller-registration")).isDisplayed();
	}

	@Test
	public void shouldShowDetailsOfItem() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.className("over-wraper")).isDisplayed()) {
			driver.findElement(By.className("g-i-tile-i-title")).click();
			Thread.sleep(4000);
			driver.findElement(By.className("container")).isDisplayed();
		} else {
			System.out.println("element is not visible");
		}

	}

	@Test
	public void shouldOpenTabFotoOnTheDetailsOfItem() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.className("over-wraper")).isDisplayed()) {
			driver.findElement(By.className("g-i-tile-i-title")).click();
			Thread.sleep(4000);
			driver.findElement(By.className("container")).isDisplayed();
		} else {
			System.out.println("element is not visible");
		}
		driver.findElement(By.name("photo")).click();
		String s = "Фотографии";
		WebElement elementText = driver.findElement(By.className("detail-tab-i-title"));
		elementText.getText();
		Assert.assertNotEquals(s, elementText);
		System.out.println(elementText);
	}

	@Test
	public void shouldOpenTabCharacteristicsOnTheDetailsOfItem() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("asus x5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.className("over-wraper")).isDisplayed()) {
			driver.findElement(By.className("g-i-tile-i-title")).click();
			Thread.sleep(4000);
			driver.findElement(By.className("container")).isDisplayed();
		} else {
			System.out.println("element is not visible");
		}
		Thread.sleep(4000);
		driver.findElement(By.name("characteristics")).click();
		Thread.sleep(4000);
		String s = "Двухъядерный Intel Celeron N3060 (1.6 - 2.48 ГГц)";

		String elementText = driver.findElement(By.className("pp-characteristics-tab-i-field")).getText();

		Assert.assertEquals(s, elementText);
		System.out.println(elementText);
	}

	@Test
	public void shouldCheckGreenColorOfSearchButtonBlockedTest() throws InterruptedException {
		String titleexpcolor = "rgba(115, 211, 106, 1)";
		WebElement titlefield = driver.findElement(By.className("rz-search-button-go-link"));
		String titlecurrcolor = titlefield.getCssValue("background-color");
		Thread.sleep(3000);
		Assert.assertEquals(titleexpcolor, titlecurrcolor);
		System.out.println(titlecurrcolor);
	}

	@Test
	public void shouldAddItemsToComparison() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input")).sendKeys("iphone 5");
		Thread.sleep(4000);
		driver.findElement(By.className("btn-link-green")).click();
		List<WebElement> listElement = driver.findElements(By.className("g-i-tile-catalog"));
		WebElement e = listElement.get(1);
		String s = e.getText();
		System.out.println(s);
		driver.findElement(By.className("g-compare-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("hub-i-comparison-link-count")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("comparison-one-goods")).isDisplayed();

	}
}

// public class RozetkaTest {

// public static void main(String[] args) {
// TODO Auto-generated method stub

// }

// }
