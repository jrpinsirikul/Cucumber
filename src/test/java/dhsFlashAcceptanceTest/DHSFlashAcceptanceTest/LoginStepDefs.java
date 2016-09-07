package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs {
	/**
	 * Login Feature
	 * @throws Throwable
	 */
	@Given("^I have a valid username and password$")
	public void startUpApp() throws Throwable {
		assertTrue(true);
	}
	
	@When ("^I input my username and password (.+) (.+)$")
	public void inputUsername(String username, String password) throws Throwable {
		assertTrue(true);
	}
	
	@Then("^I should be logged in$")
	public void checkLogin() throws Throwable {
		assertTrue(true);
	}
}
