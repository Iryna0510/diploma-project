package com.example.login;

import org.openqa.selenium.WebDriver;

abstract class BaseLoginType {
	protected WebDriver driver = null;
	public abstract void login(String username, String password);
	
}
