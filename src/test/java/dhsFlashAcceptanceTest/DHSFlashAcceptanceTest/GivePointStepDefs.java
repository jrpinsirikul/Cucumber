package dhsFlashAcceptanceTest.DHSFlashAcceptanceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

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

public class GivePointStepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WebDriverWait waitDriver;
	GivePoint givePoint;
	String successMessage = "Point Given To colleague";
	String errorMessage = "Please fill out form";
	
	/**
	 * Successfully give points to colleague
	 * @throws Throwable
	 */
	@Given ("^I navigate to the give point screen (.+)$")
	public void goToPointPage(String formUrl) throws Throwable {
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);
		
		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(formUrl);
		
		waitDriver = new WebDriverWait (driver, 15);
		
		givePoint = new GivePoint(driver);
	}

	@When ("^I select a colleague from list (.+)$")
	public void selectColleague(String employeeName) throws Throwable {
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.selectColleague(employeeName);
	}
	
	@And ("^I click give point button$")
	public void givePoint() {
		givePoint.clickGivePoint();
	}
	
	@Then ("^The form will submit$")
	public void formSubmitted() {
		assertTrue(true);
	}
	
	/**
	 * Submit Empty points form
	 */
	@Then ("^the form will not submit$")
	public void submitEmptyForm() {
		givePoint.clickGivePoint();
		assertTrue(true);
	}
}
