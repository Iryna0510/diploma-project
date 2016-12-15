package forPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//public class AutoLogin {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	public class AutoLogin{
		WebDriver driver;
		By userName = By.name("login");
		By password = By.name("password");
		By login = By.className("btn-link-blue");
		
		public AutoLogin(WebDriver driver){
			this.driver = driver;
		}
		
		//Set user name in textbox
		public void setUserName(String strUserName){
			driver.findElement(userName).sendKeys(strUserName);
		}
		
		//Set password in password textbox
		public void setPassword(String strPassword){
			 driver.findElement(password).sendKeys(strPassword);
		}
		
		//Click on login button
		public void clickLogin(){
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(login).click();
		}
	 
		/**
		 * This POM method will be exposed in test case to login in the application
		 * @param strUserName
		 * @param strPasword
		 * @return
		 */
		public void loginToAutoQA(String strUserName,String strPasword){
			//Fill user name
			this.setUserName(strUserName);
			//Fill password
			this.setPassword(strPasword);
			//Click Login button
			this.clickLogin();			
		}
	}
		
	


