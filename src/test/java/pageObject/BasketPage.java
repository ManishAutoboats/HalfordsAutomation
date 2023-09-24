package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class BasketPage extends Base {

	public void user_click_on_add_to_cart_button_prodcut1() {
		WebElement prodcut1Btn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		clickOnElement(prodcut1Btn, 10);
	}

	public void user_click_on_add_to_cart_button_prodcut2() {
		WebElement prodcut2Btn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
		clickOnElement(prodcut2Btn, 10);
	}

	public void validate_cart_count_is(String cartCountNum) {
      WebElement cartCount=driver.findElement(By.cssSelector("span.shopping_cart_badge"));
       validateText(cartCount, cartCountNum);
      
        
	}
	public void click_On_Cart_Icon() {
	WebElement cartLink=driver.findElement(By.cssSelector("a.shopping_cart_link"));
	clickOnElement(cartLink, 10);
	}
	public void click_On_Checkout_Button() {
	WebElement checkoutBtn=	driver.findElement(By.cssSelector("button#checkout"));
	  clickOnElement(checkoutBtn, 10);
	}
	

}
