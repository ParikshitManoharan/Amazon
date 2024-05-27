package org.google.search;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.pojo.amzon.AllAmazonLinksPojo;
import org.pojo.amzon.GoogleSearchPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mobiles {

	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}

	
	
	@Test
	private void getMobiles() throws AWTException {

		GoogleSearchPojo search = new GoogleSearchPojo(driver);
		WebElement gogleSearch = search.googleSearch();
		gogleSearch.sendKeys("Amazon");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		gogleSearch.sendKeys(Keys.ENTER);

		// From AllAmazonLinks Class (From that search Get all links and click Amazon.in
		// link)
		AllAmazonLinksPojo allLinks = new AllAmazonLinksPojo(driver);
		allLinks.getAllLinksAndClick();

		WebElement searchAmzon = driver.findElement(By.id("twotabsearchtextbox"));
		searchAmzon.sendKeys("Mobiles Under 10000");
		searchAmzon.sendKeys(Keys.ENTER);
		
		List<WebElement> mobilesUnder10k = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int count = 0;
		for (WebElement mobile : mobilesUnder10k) {
			String mobileName = mobile.getText();
			count++;
			System.out.println(count + ": " + mobileName);
			
			if (mobileName.contains("POCO C65 Matte Black 8GB RAM")) {
				WebElement findMobile = mobile.findElement(By.xpath("//span[@class='a-price']//following-sibling::span[@class='a-price-whole']"));
				String mobilePrice = findMobile.getText();
				System.out.println(mobileName +" This Mobile Price is "+ mobilePrice + " Rupees");
			}
		}
	}
	


	@AfterClass
	public void closeDriver() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.quit();
	}

}
