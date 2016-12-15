package com.example.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLogin<T extends BaseLoginType> {
	

	private T t;

	public BaseLogin(T t) {
		super();
		this.t = t;
	}

	public void login(String username, String password) throws InterruptedException {
		this.t.login(username, password);
		
	}
	// public void loginFB(String username, String password) throws
	// InterruptedException {
	// this.t.login(username, password);
	// System.setProperty("webdriver.chrome.driver",
	// "E:\\dev\\chromedriver.exe");
	// this.driver = new ChromeDriver();
	// driver.get("https://my.rozetka.com.ua");
	// driver.findElement(By.xpath("//*[@id='header_user_menu_parent']")).click();
	// driver.findElement(By.className("btn-auth-vk")).click();
	//
	// String winHandleBefore = driver.getWindowHandle();
	// //driver.findElement(By.name("btnSimulateDK")).click();
	//
	// for(String winHandle : driver.getWindowHandles()){
	// if (!winHandle.equals(winHandleBefore))
	// driver.switchTo().window(winHandle);
	// }
	// Thread.sleep(5000);
	// driver.findElement(By.name("email")).sendKeys(username);
	// driver.findElement(By.name("pass")).sendKeys(password);
	// driver.findElement(By.id("install_allow")).click();
	// Thread.sleep(4000);
	// driver.switchTo().window(winHandleBefore);
	// driver.quit();
	// //here should be search of elements
	// }
}
