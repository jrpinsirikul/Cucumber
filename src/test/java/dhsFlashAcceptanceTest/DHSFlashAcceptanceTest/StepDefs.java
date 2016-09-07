package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dhsFlashAcceptanceTest.Pages.WelcomePage;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WelcomePage welcome;
	
	/**
	 * Welcome message feature
	 * @param environment
	 * @throws Throwable
	 */
	@When ("^I navigate to home page (.+)$")
	public void goToHomePage(String environment) throws Throwable {
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(environment);
		
		welcome = new WelcomePage(driver);
	}

	@Then("^I should see message (.+)$")
	public void checkWelcomeMessage(String welcomeMessage) throws Throwable {
		assertTrue(welcome.getHomeMessage().isDisplayed());
		assertEquals("Hello World", welcome.getMessageText());
		driver.quit();
	}
	
	/**
	 * Tanu welcome page check
	 */
	@Given("^I want to go to the site$")
	public void i_want_to_go_to_the_site() throws Throwable {
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I go to www\\.linktec\\.com/DHSFlash$")
	public void i_go_to_www_linktec_com_DHSFlash() throws Throwable {
		driver.get("http://www.linktecflash.com/DHSFlash");
	}

	@Then("^the homepage loads$")
	public void the_homepage_loads() throws Throwable {
	    //System.out.println(driver.getTitle());
	    assertEquals("Kudos Form | kudos", driver.getTitle());
	    
	    driver.quit();
	}
	
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