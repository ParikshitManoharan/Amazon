package org.google.search;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojo.amzon.AllAmazonLinksPojo;
import org.pojo.amzon.GoogleSearchPojo;
import org.pojo.amzon.TodaysDealPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmzonGoogleSearch {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void enterTextInGoogle() {
		
  // From GoogleSearchPojo Class (Goto Google and Search For Amazon)
		GoogleSearchPojo search = new GoogleSearchPojo(driver);
		WebElement gogleSearch = search.googleSearch();
		gogleSearch.sendKeys("Amazon");
		search.clickGooglesearch();
		
		
		
  // From AllAmazonLinks Class (From that search Get all links and click Amazon.in link)
		AllAmazonLinksPojo allLinks = new AllAmazonLinksPojo(driver);
		allLinks.getAllLinksAndClick();
		
		
		
  // From Todays deal Mobiles 
		TodaysDealPojo mobiles = new TodaysDealPojo(driver);
		mobiles.allToday();		
	}
	
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
