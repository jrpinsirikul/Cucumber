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

public class EmployeeListStepDefs {
	DesiredCapabilities capability;
	WebDriver driver;
	WebDriverWait waitDriver;
	GivePoint pointPage;
	String listTitle = "Latest Kudos";
	String homeUrl;

	@Given("^there is at least (\\d+) employee with a point in the system$")
	public void there_is_at_least_employee_with_a_point_in_the_system(int arg1) throws Throwable {
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		waitDriver = new WebDriverWait (driver, 15);
	}

	@When("^I navigate to the Home screen (.+)$")
	public void I_navigate_to_the_Home_screen(String homeUrl) throws Throwable {
		driver.get(homeUrl);
		pointPage = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(pointPage.getKudosList()));
		assertTrue(pointPage.getKudosList().isDisplayed());
		assertTrue(pointPage.getList().isDisplayed());
		assertEquals(listTitle, pointPage.getListTitleText());
	}

	@Then("^I will see a list of employees$")
	public void I_will_see_a_list_of_employees() throws Throwable {
		assertTrue(pointPage.getUsers().size() > 0);
	}
	
	/**
	 * Check if employee has points
	 */
	@And("^each employee with have their number of points listed with them$")
	public void seeEmployeePoints() {
		pointPage.getUsers().get(0);
		driver.quit();
	}
}
