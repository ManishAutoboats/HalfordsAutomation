package stepDefination;

import io.cucumber.java.en.And;
import pageObject.CheckoutPage;

public class CheckoutPageSteps {
	  CheckoutPage checkout = new CheckoutPage();
	
	@And ("user enter firstname {string} lastname {string} and zipcode {string}")
	 public void enter_user_Deatials(String fname,String lname,String zcode) {
		 checkout.enter_user_Deatials(fname, lname, zcode);
	}
	@And ("click on continue button")
	public void click_on_continue_button() {
		checkout.click_on_continue_button();
	}
	@And ("Validate user navigate to overview page")
	public void Validate_user_navigate_to_overview_page() throws InterruptedException {
		Thread.sleep(5000);
		checkout.Validate_user_navigate_to_overview_page();
	}

}
