package dhsFlashAcceptanceTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {
	WebDriver driver;

	@FindBy(id="loginbox")
	WebElement loginBox;
	
	@FindBy(id="user_id")
	WebElement userID;
	
	@FindBy(id="user_password")
	WebElement userPassword;

	@FindBy(css="button[title='Log In']")
	WebElement loginButton;

	/**
	 * Initializes give point page element
	 * @param driver the driver to interact with browser
	 */
	public Login(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}
	
	/**
	 * Inputs username
	 * @param the username of the login user
	 */
	public void inputUsername(String username) {
		userID.sendKeys(username);
	}
	
	/**
	 * Inputs password
	 * @param the password of the login user
	 */
	public void inputPassword(String password) {
		userPassword.sendKeys(password);
	}
	
	/**
	 * Submits the username and password
	 * @param the username and password
	 */
	public void login(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		loginButton.click();
	}

	/**
	 * Get login box element
	 * @return the login box element
	 */
	public WebElement getLoginBox() {
		return loginBox;
	}
	
	/**
	 * Get username box element
	 * @return the username box element
	 */
	public WebElement getUsernameBox() {
		return loginBox;
	}
	
	/**
	 * Get password box element
	 * @return the password box element
	 */
	public WebElement getPasswordBox() {
		return loginBox;
	}

	/**
	 * Gets the give point page title
	 * @return the title of the page
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
}
