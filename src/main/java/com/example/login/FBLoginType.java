package com.example.login;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLoginType extends BaseLoginType {

	@Override
	public void login(String username, String password) {
		System.out.println("Yo, loginfromfacebook");
		System.setProperty("webdriver.chrome.driver", "E:\\dev\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://my.rozetka.com.ua");
		driver.findElement(By.xpath("//*[@id='header_user_menu_parent']")).click();
		driver.findElement(By.className("btn-auth-fb")).click();// fb

		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore))
				driver.switchTo().window(winHandle);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(winHandleBefore);
		driver.quit();
		// here should be search of elements
	}

}
