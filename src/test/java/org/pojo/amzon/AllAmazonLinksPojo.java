package org.pojo.amzon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllAmazonLinksPojo {

	WebDriver driver;

	// Constructor for this AllAmazonLinks PageFactory
	public AllAmazonLinksPojo(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[@class='LC20lb MBeuO DKV0Md']")
	private List<WebElement> links;

	public void getAllLinksAndClick() {

		for (WebElement webElement : links) {

			if (webElement.getText().equalsIgnoreCase("Amazon.in")) {
				webElement.click();
				break;
			}

		}
	}

}
