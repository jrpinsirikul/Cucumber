package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dhsFlashAcceptanceTest.Pages.GivePoint;
import dhsFlashAcceptanceTest.Pages.Login;

public class GivePointStepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WebDriverWait waitDriver;
	GivePoint givePoint;
	String username = "johndoe";
	String password = "letmein";
	String employeeName = "John Doe";
	Login loginPage;
	String loginPageTitle = "Sign In | kudos";
	String homePageTitle = "Home | kudos";
	String comment = "a comment here";

	/**
	 * Successfully give points to colleague
	 * @throws Throwable
	 */
	@Given ("^I navigate to the give point screen (.+)$")
	public void goToPointPage(String formUrl) throws Throwable {
		capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(formUrl);

		waitDriver = new WebDriverWait (driver, 15);
	}

	@And ("^I am logged in with username (.+) and password (.+)$")
	public void login(String username, String password) {
		loginPage = new Login(driver);
		assertEquals(loginPageTitle, loginPage.getPageTitle());
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		assertTrue(loginPage.getUsernameBox().isDisplayed());
		assertTrue(loginPage.getPasswordBox().isDisplayed());
		loginPage.login(username, password);
	}

	@When ("^I select a colleague from list (.+)$")
	public void selectColleague(String employeeName) throws Throwable {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.selectColleague(employeeName);
	}

	@When ("^I click give point button$")
	public void givePoint() {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getGivePointButton()));
		assertTrue(givePoint.getGivePointButton().isDisplayed());
		givePoint.clickGivePoint();
	}

	@Then ("^The form will not submit with missing category$")
	public void formSubmitted() {
		assertTrue(true);
		waitDriver.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("//*[@id='kudosSubmitForm']/kudos-form-short/div/form/div[2]/ul/li"))));
		driver.quit();
	}
	
	/**
	 * Submitting an empty form
	 */
	@Then ("^the form will not submit$")
	public void submitEmptyForm() {
		givePoint.clickGivePoint();
		driver.quit();
	}
	
	/**
	 * Clear form
	 */
	@When ("^I fill out form$")
	public void fillOutForm() {
		assertTrue(givePoint.getPointForm().isDisplayed());
		givePoint.submitComment(comment);
	}
	
	@And ("^I click the reset button$")
	public void resetForm() {
		givePoint.clickResetForm();
		assertEquals(homePageTitle, givePoint.getPageTitle());
	}
	
	@Then ("^the form will clear$")
	public void clearForm() {
		assertEquals(homePageTitle, givePoint.getPageTitle());
	}
}
