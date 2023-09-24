package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class LoginPageSteps {

	LoginPage login = new LoginPage();

	@When("user enter {string} and {string}")
	public void user_enter_and(String uname, String pass) {
		login.user_enter_and(uname, pass);

	}

	@And("user click on login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();

	}

	@Then("Validate user logged in sucessfullly")

	public void Validate_user_logged_in_sucessfullly() {
		login.Validate_user_logged_in_sucessfullly();

	}

	@Then("validate login error message")

	public void validate_login_error_message() {
      login.validate_login_error_message();
	}

}
