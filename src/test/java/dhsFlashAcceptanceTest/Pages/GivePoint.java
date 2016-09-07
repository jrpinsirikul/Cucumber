package dhsFlashAcceptanceTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class GivePoint {
	WebDriver driver;

	@FindBy(id="kudosSubmitForm")
	WebElement form;

	@FindBy(xpath="//div[@id='kudosSubmitForm']/kudos-form-short/div/form/div/select")
	WebElement nameDropdown;

	@FindBy(css="button[title='Log In']")
	WebElement givePointButton;

	@FindBy(xpath="//div[@id='content-wrapper']/div/h1")
	WebElement successMessage;

	@FindBy(xpath="//div[@id='content-wrapper']/div/h1")
	WebElement errorMessage;

	/**
	 * Initializes give point page element
	 * @param driver the driver to interact with browser
	 */
	public GivePoint(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}

	/**
	 * Get form element
	 * @return the form element
	 */
	public WebElement getPointForm() {
		return form;
	}

	/**
	 * Select the colleague name from a list
	 * @param employeeName to be selected
	 */
	public void selectColleague(String employeeName) {
		Select dropDown = new Select(nameDropdown);  
		dropDown.selectByVisibleText(employeeName);
	} 

	/**
	 * Submits the give point form
	 */
	public void clickGivePoint() {
		givePointButton.click();
	}

	/**
	 * Gets the notification message element from the screen
	 * @return the web element of the notification message
	 */
	public WebElement getSuccessMessage() {
		return successMessage;
	}

	/**
	 * Returns the text of the notification message
	 * @return the message text
	 */
	public String getSuccessText() {
		return successMessage.getText();
	}

	/**
	 * Gets the notification message element from the screen
	 * @return the web element of the notification message
	 */
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Returns the text of the notification message
	 * @return the message text
	 */
	public String getErrorText() {
		return errorMessage.getText();
	}

	/**
	 * Gets the give point page title
	 * @return the title of the page
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
}
