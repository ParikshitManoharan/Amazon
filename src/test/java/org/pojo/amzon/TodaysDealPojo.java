package org.pojo.amzon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDealPojo {
	
	WebDriver driver;
	
	public TodaysDealPojo(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='Today’s Deals']/parent::div/following-sibling::div//li//span[@class='a-truncate-full a-offscreen']")
	private List<WebElement> allMobileDeals;
	
	@FindBy(xpath="//h2[text()='Today’s Deals']//following::a[@class='a-link-normal feed-carousel-control feed-right'][1]")
	private WebElement rightArrowTodaysDeal;
	
	public void allToday() {
		
		   boolean result = false;
		   
      		for (WebElement mobile : allMobileDeals) {
				if (mobile.getText().contains("Nokia G42 5G")) {
					result = true;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					mobile.click();
					break;
				}
				
			}
      		
      		if (result==false) {
      			rightArrowTodaysDeal.click();
			}

	}
}
