package dhsFlashAcceptanceTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WelcomePage {
	WebDriver driver;

	@FindBy(xpath="//div[@id='content-wrapper']/div/h1")
	WebElement homeMessage;

	/**
	 * Initializes home page element
	 * @param driver the driver to interact with browser
	 */
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}

	/**
	 * Gets the text of main message on form
	 * @return the message of the form
	 */
	public String getMessageText() {
		return homeMessage.getText();
	}

	/**
	 * Getter for the home message element to be interacted
	 * with in the test class
	 * @return the home message element
	 */
	public WebElement getHomeMessage() {
		return homeMessage;
	}
	
	/**
	 * Gets the home page title
	 * @return the title of the page
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
}
