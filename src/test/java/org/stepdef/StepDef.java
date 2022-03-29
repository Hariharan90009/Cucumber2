package org.stepdef;

import org.baseclass.BaseClasss;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends BaseClasss {

	@Given("user is on adactin page on chrome")
	public void user_is_on_adactin_page_on_chrome() {
		launchUrl();
		getUrl("https://adactinhotelapp.com/");
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		WebElement name = toFindById("username");
		toSendKeys(name, string);

		WebElement pass = toFindById("password");
		toSendKeys(pass, string2);
	}

	@When("user should click on login page")
	public void user_should_click_on_login_page() {
		WebElement btnLogin = toFindById("login");
		toClick(btnLogin);
	}

	@Then("user should validate home page screen visible or not")
	public void user_should_validate_home_page_screen_visible_or_not() {

		System.out.println(" Invalid username and Password ");
	}

}
