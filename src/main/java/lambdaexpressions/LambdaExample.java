/**
 * 
 */
package lambdaexpressions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Iðà
 *
 */
public class LambdaExample {
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
		// for (int i = 0; i < listElement.size(); i++) {
		// String elementText = listElement.get(i).getText();
		// System.out.println(elementText);

		// lambda expression
		listElement.stream().filter(element -> Integer.parseInt(element.getText()) > 13000)
				.filter(element -> Integer.parseInt(element.getText()) < 15000);

		System.out.println(listElement);

	}

}

// public static void main(String[] args) {
//
// Map<String, String> items = new HashMap<String, String>();
// items.put("one", "fdhgfxgdgfxc");
// items.put("two", "cghfgbcgfcfbv");
// items.put("three", "fgdfdg");
//
// //standary way
// for (String key : items.keySet()) {
// if (key.equals("two")) {
// System.out.println(items.get(key));
// }
// }

// Optional<Integer> resultPromise = items.entrySet().stream().filter(p -> p
// >13000).filter(p -> p < 15000);
// System.out.println(resultPromise.get());
// read about filters
// stream api
