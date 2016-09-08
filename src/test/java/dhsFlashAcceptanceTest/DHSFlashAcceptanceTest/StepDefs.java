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
		
		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(environment);
		
		welcome = new WelcomePage(driver);
	}

	@Then("^I should see message (.+)$")
	public void checkWelcomeMessage(String welcomeMessage) throws Throwable {
		assertTrue(welcome.getHomeMessage().isDisplayed());
		assertEquals(welcomeMessage, welcome.getMessageText());
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
		
		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		welcome = new WelcomePage(driver);
	}

	@When("^I go to www\\.linktec\\.com/DHSFlash$")
	public void i_go_to_www_linktec_com_DHSFlash() throws Throwable {
		driver.get("http://www.linktecflash.com/DHSFlash");
	}

	@Then("^the homepage loads$")
	public void the_homepage_loads() throws Throwable {
	    //System.out.println(driver.getTitle());
	    assertEquals("Home | kudos", welcome.getPageTitle());  
	    driver.quit();
	}
}