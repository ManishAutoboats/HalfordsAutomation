package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {

	
	
	public void user_enter_and(String uname, String pass) {
		
	WebElement username=driver.findElement(By.cssSelector("#user-name"));
	  cleanAndEnterText(username, uname);
	  
	 WebElement password= driver.findElement(By.cssSelector("#password"));
	 cleanAndEnterText(password, pass);
		   
	}
	
 public void user_click_on_login_button() {
	 
	WebElement loginBtn= driver.findElement(By.cssSelector("#login-button"));
	clickOnElement(loginBtn, 10);
		   
		}
 public void Validate_user_logged_in_sucessfullly() {
 WebElement productHeading= driver.findElement(By.xpath("//span[@class='title']"));
	  validateText(productHeading,"Products");
	  
	}
 
 public void validate_login_error_message() {
    WebElement errorMessage= driver.findElement(By.xpath("//h3[@data-test='error']"));
      Assert.assertTrue(errorMessage.isDisplayed());
    
	}

}
