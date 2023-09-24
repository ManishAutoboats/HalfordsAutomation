package stepDefination;

import org.apache.commons.lang3.Validate;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BasketPage;

public class BasketPageSteps {

	BasketPage basket = new BasketPage();

	@Then("validate cart count is {string}")
	public void validate_cart_count_is(String cartNum) {
		basket.validate_cart_count_is(cartNum);
	}

	@When("user click on add to cart button product1")
	public void user_click_on_add_to_cart_button_product1() {
		basket.user_click_on_add_to_cart_button_prodcut1();
	}

	@When("user click on add to cart button product2")
	public void user_click_on_add_to_cart_button_product2() {
		basket.user_click_on_add_to_cart_button_prodcut2();
	}

	@And("click On Cart Icon")
	public void click_On_Cart_Icon() {
      basket.click_On_Cart_Icon();
	}

	@And("click On Checkout Button")
	public void click_On_Checkout_Button() {
    basket.click_On_Checkout_Button();
	}
	


}
