package forPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoHomePage {
	WebDriver driver;
	By homePageName = By.className("logo");
	
	
	public AutoHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//Get the Page name from Home Page
	public String getHomePageDashboardName(){
		 return	driver.findElement(homePageName).getText();
		}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
