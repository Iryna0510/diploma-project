package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.login.BaseLogin;
import com.example.login.FBLoginType;
import com.example.login.VKLoginType;

public class LoginTestWithGenerics {
	public WebDriver driver = null;

	// @Before
	// public void preinit() {
	// System.setProperty("webdriver.chrome.driver",
	// "E:\\dev\\chromedriver.exe");
	// this.driver = new ChromeDriver();
	// driver.get("https://my.rozetka.com.ua");
	// }
	//
	// @After
	// public void cleanup() {
	// driver.quit();
	// }

	@Test
	public void testFromVkLogin() throws InterruptedException {
		VKLoginType vkLoginType = new VKLoginType();
		// FBLoginType fbLoginType = new FBLoginType();

		BaseLogin<VKLoginType> baseLogin = new BaseLogin<VKLoginType>(vkLoginType);
		baseLogin.login("380964069259", "irinaovchinnikova05");// add correct
																// data

		// BaseLogin<FBLoginType> fbBaseLogin = new
		// BaseLogin<FBLoginType>(fbLoginType);
		// fbBaseLogin.login(null, null);
	}

	@Test
	public void testFromFBLogin() throws InterruptedException {
		// VKLoginType vkLoginType = new VKLoginType();
		FBLoginType fbLoginType = new FBLoginType();

		BaseLogin<FBLoginType> baseLogin = new BaseLogin<FBLoginType>(fbLoginType);
		baseLogin.login("irina05101993@gmail.com", "irinaovchinnikova");// add
																		// correct
																		// data

		// BaseLogin<FBLoginType> fbBaseLogin = new
		// BaseLogin<FBLoginType>(fbLoginType);
		// fbBaseLogin.login(null, null);
	}

}
