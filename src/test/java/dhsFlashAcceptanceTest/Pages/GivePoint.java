package dhsFlashAcceptanceTest.Pages;

import java.util.List;

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

	@FindBy(xpath="//*[@id='kudosSubmitForm']/kudos-form-short/div/form/div[5]/button[1]")
	WebElement givePointButton;
	
	@FindBy(css="button[ng-click='resetForm()']")
	WebElement resetButton;

	@FindBy(id="kudosAwardList")
	WebElement kudosList;

	@FindBy(xpath="//div[@id='kudosAwardList']/kudos-award-list/div/h3")
	WebElement kudosListTitle;

	@FindBy(xpath="//div[@id='kudosAwardList']/kudos-award-list/div/ul/li")
	List<WebElement> usersInList;

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
	 * Submits the give point form
	 */
	public WebElement getGivePointButton() {
		return givePointButton;
	}
	
	/**
	 * Reset point form
	 */
	public void clickResetForm() {
		resetButton.click();
	}

	/**
	 * Get Kudos list
	 * @return the list element
	 */
	public WebElement getKudosList() {
		return kudosList;
	}

	/**
	 * Get list header
	 * @return the list header element
	 */
	public WebElement getListHeader() {
		return kudosListTitle;
	}

	/**
	 * Get users in list
	 * @return the list of users
	 */
	public List<WebElement> getUsers() {
		return usersInList;
	}

	/**
	 * If the users list is not empty, checks if the
	 * users have kudos listed next to them
	 */
	public boolean usersHaveKudos() {
		String user = usersInList.get(0).getText();
		String[] userAndKudos = user.split(",");
		if (userAndKudos.length > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the give point page title
	 * @return the title of the page
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
}
