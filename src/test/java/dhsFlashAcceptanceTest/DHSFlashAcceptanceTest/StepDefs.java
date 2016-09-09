package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dhsFlashAcceptanceTest.Pages.Login;
import dhsFlashAcceptanceTest.Pages.WelcomePage;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WebDriverWait waitDriver;
	WelcomePage welcome;
	String username = "johndoe";
	String password = "letmein";
	Login loginPage;
	String loginPageTitle = "Sign In | kudos";

	/**
	 * Welcome message feature
	 * @param environment
	 * @throws Throwable
	 */
	@When ("^I login to the application (.+)$")
	public void goToHomePage(String environment) throws Throwable {
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitDriver = new WebDriverWait (driver, 15);
		driver.get(environment);

		//Login
		loginPage = new Login(driver);
		assertEquals(loginPageTitle, loginPage.getPageTitle());
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		assertTrue(loginPage.getUsernameBox().isDisplayed());
		assertTrue(loginPage.getPasswordBox().isDisplayed());
		loginPage.login(username, password);
		//End Login
		welcome = new WelcomePage(driver);
	}

	@Then("^I should see the home page$")
	public void checkWelcomeMessage(String welcomeMessage) throws Throwable {
		assertEquals("Home | kudos", welcome.getPageTitle());  
		driver.quit();
	}
}