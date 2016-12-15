package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class VchenaRadaTests {
	private WebDriver driver = null;

	@Before
	public void preinit() {
		System.setProperty("webdriver.chrome.driver", "E:\\dev\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("http://vchena-rada.collectedpapers.com.ua/");
	}

	@After
	public void cleanup() {
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void shouldCheckTitleWords() throws InterruptedException {
		WebElement e = driver.findElement(By.xpath("/html/body/div[1]/div/h3"));
		String actualstring = e.getText();
		String expectedstring = "—пец≥ал≥зована вчена рада к76.051.02 в";
		Assert.assertEquals(actualstring, expectedstring);
		System.out.println(actualstring);
		System.out.println(expectedstring);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void shouldCheckHederLinks() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/h4[1]/a")).click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		// check is it correct page opened or not (e.g. check page's title)
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://www.chnu.cv.ua/index.php?page=ua");
		System.out.println(URL);
		// then close tab and get back
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

		// department link
		driver.findElement(By.xpath("/html/body/div[1]/div/h4[2]/a")).click();
		List<String> browserTabsNew = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(browserTabsNew.get(1));
		// check is it correct page opened or not (e.g. check page's title)
		String URLNew = driver.getCurrentUrl();
		Assert.assertEquals(URLNew, "http://www.dfe2016.fmi.org.ua/");
		System.out.println(URLNew);
	}

	@Test
	public void shouldCheckCorrectRegistration() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div/a[3]")).click();
		driver.findElement(By.name("second_name")).sendKeys("Ovchynnikova");
		driver.findElement(By.name("first_name")).sendKeys("Iryna");
		driver.findElement(By.name("parent_name")).sendKeys("Valeriivna");
		driver.findElement(By.name("email")).sendKeys("ovchinnikova_ira@mail.ua");
		driver.findElement(By.name("topic")).sendKeys("test");
		driver.findElement(By.name("science_director")).sendKeys("test");
		driver.findElement(By.name("organization")).sendKeys("test");
		driver.findElement(By.name("profession")).sendKeys("test");
		Select dropdown = new Select(driver.findElement(By.name("position")));
		dropdown.selectByVisibleText("Ќауковий сп≥вроб≥тник");
		driver.findElement(By.name("count_articles")).sendKeys("0");
		driver.findElement(By.name("count_specialist")).sendKeys("0");
		driver.findElement(By.name("count_factor")).sendKeys("0");
		driver.findElement(By.name("count_scopus")).sendKeys("0");
		driver.findElement(By.className("btn-primary")).click();
		WebElement wer = new WebDriverWait(driver, 5)
				.until((WebDriver dr1) -> dr1.findElement(By.className("alert-success")));
		driver.findElement(By.className("alert-success")).isDisplayed();
	}

	@Test
	public void shouldCheckSpecialitiesPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div/a[2]")).click();
		if (driver.findElement(By.className("col-xs-12")).isDisplayed()) {
			String s = driver.findElement(By.xpath("//*[@id='post-165']/div/div/ul")).getText().toString();
			System.out.println(s);
			String expected = "01.01.01 Ц математичний анал≥з" + '\n' + "01.01.02 Ц диференц≥альн≥ р≥вн€нн€" + '\n'
					+ "01.05.02 Ц математичне моделюванн€ та обчислювальн≥ методи";
			Assert.assertEquals(s, expected);
		} else {
			System.out.println("Element is not visible");
		}
	}

	@Test
	public void shouldCheckAboutRadaPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div/a[1]")).click();
		if (driver.findElement(By.id("panel-35-0-0-0")).isDisplayed()) {
			driver.findElement(By.className("galery-list")).isDisplayed();
		} else {
			System.out.println("Specialities tab is not displayed");
		}
		if (driver.findElement(By.id("panel-35-0-1-0")).isDisplayed()) {

		} else {
			System.out.println("Sklad rady tab is not displayed");
		}
	}

}
