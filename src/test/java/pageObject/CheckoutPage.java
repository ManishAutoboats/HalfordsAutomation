package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class CheckoutPage extends Base {
	
	
	
	 public void enter_user_Deatials(String fname,String lname,String zcode) {
	WebElement firstName= driver.findElement(By.cssSelector("input#first-name"));
	   firstName.sendKeys(fname);
	   WebElement lastName= driver.findElement(By.cssSelector("input#last-name"));
	   lastName.sendKeys(lname);
	   WebElement zipCode= driver.findElement(By.cssSelector("input#postal-code"));
	   zipCode.sendKeys(zcode);
	   
		 
		
	}
	
	public void click_on_continue_button() {
	WebElement continueBtn=	driver.findElement(By.cssSelector("input#continue"));
	clickOnElement(continueBtn, 10);
	}

	public void Validate_user_navigate_to_overview_page() {
	Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
	}

}
