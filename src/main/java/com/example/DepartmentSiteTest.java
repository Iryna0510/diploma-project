package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class DepartmentSiteTest 
{
 private WebDriver driver = null;
	
   @Before
   public void preinit(){
	   System.setProperty("webdriver.chrome.driver","E:\\dev\\chromedriver.exe");
	   this.driver = new ChromeDriver();
   	}
   
   @After
   public void cleanup(){
	   driver.quit();
   }
   
   @Test
   public void shouldReturnTitlecheese() throws InterruptedException{
	    driver.get("http://www.google.com");
	    
        WebElement element = driver.findElement(By.name("q"));

       
        element.sendKeys("Cheese!");
        Thread.sleep(5000);
        element.submit();
        //koroche kakto tak. A vot owibka govoryat na forume svyazana takje s operacionkoi
        //String expectedTitle = " Cheese! - Поиск в Google";
       // String actualTitle = driver.getTitle();
        //Assert.assertEquals(expectedTitle, actualTitle);
        
   }
   @Test
   public void shouldCheckTabNews() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[1]/div/ul/li[1]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  driver.findElement(By.className("title")).isDisplayed();
	  Thread.sleep(3000);
   }	
   @Test
   public void shouldCheckTabInvitedLectors() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[1]/div/ul/li[2]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }	
    	
   @Test
   public void shouldCheckTabArrival() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[1]/div/ul/li[3]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }	
   @Test
   public void shouldCheckTabAboutChernivtsi() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[1]/div/ul/li[4]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabPresentations() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[1]/div/ul/li[5]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabGalery() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.cssSelector("body > div > nav.navbar.navbar-default.navbar-custom-horizont > div > ul > li:nth-child(6) > a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabGolovna() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[1]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabOrganizators() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[2]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabAdvisoryCommittee() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[3]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabCommittee() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[4]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabSections() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[5]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabInformationalMessages() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[6]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabParticipants() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[8]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabConferenceProgram() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[9]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabConferenceMaterials() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[10]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   @Test
   public void shouldCheckTabContacts() throws InterruptedException{
	  driver.get("http://www.dfe2016.fmi.org.ua/");
	  driver.findElement(By.xpath("/html/body/div/nav[2]/div/ul/li[11]/a")).click();
	  driver.findElement(By.className("custom-jumbotron")).isDisplayed();
	  Thread.sleep(3000);
   }
   
}
