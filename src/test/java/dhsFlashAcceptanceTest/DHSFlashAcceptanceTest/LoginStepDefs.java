package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dhsFlashAcceptanceTest.Pages.Login;
import dhsFlashAcceptanceTest.Pages.WelcomePage;

public class LoginStepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WebDriverWait waitDriver;
	Login loginPage;
	String homePageTitle = "Home | kudos";
	String loginPageTitle = "Sign In | kudos";
	String homeUrl = "http://devint-elb-311533204.us-east-1.elb.amazonaws.com/DHSFlash/#/home";
	
	/**
	 * Login Feature
	 * @throws Throwable
	 */
	@Given("^I have a valid username and password$")
	public void startUpApp() throws Throwable {
		capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		waitDriver = new WebDriverWait (driver, 15);
		driver.get(homeUrl);
	}
	
	@When ("^I input my username and password (.+) (.+)$")
	public void inputUsername(String username, String password) throws Throwable {
		loginPage = new Login(driver);
		assertEquals(loginPageTitle, loginPage.getPageTitle());
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		assertTrue(loginPage.getUsernameBox().isDisplayed());
		assertTrue(loginPage.getPasswordBox().isDisplayed());
		loginPage.login(username, password);
	}
	
	@Then("^I should be logged in$")
	public void checkLogin() throws Throwable {
		assertTrue(true);
		WelcomePage homePage = new WelcomePage(driver);
		assertEquals(homePageTitle, homePage.getPageTitle());
	}
}
