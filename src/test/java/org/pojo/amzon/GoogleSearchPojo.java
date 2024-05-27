package org.pojo.amzon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPojo {

	WebDriver driver;

	// Constructor for this GoogleSearchPojo PageFactory
	public GoogleSearchPojo(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "gLFyf")
	private WebElement googleSearch;

	@FindBy(xpath = "(//input[@name='btnK'])[2]")
	private WebElement clickGooglesearch;

	public WebElement googleSearch() {
		
		return googleSearch;
	}

	public void clickGooglesearch() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		clickGooglesearch.click();

	}
}
