package crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crmpro.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement btn_contacts;

	/*
	 * @FindBy (xpath =
	 * "//a[@title = 'New Company']/parent::li/following-sibling::li/a[text() = 'Full Search Form']"
	 * ) WebElement btn_fullSearchform;
	 */

	@FindBy(xpath = "//a[@title = 'Contacts']//parent::li//child::ul//child::li/a[@title = 'Full Search Form']")
	WebElement btn_fullSearchform;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public ContactsPage contactsLink() throws InterruptedException {
		actions = new Actions(driver);
		actions.moveToElement(btn_contacts).build().perform();
		Thread.sleep(3000);
		newcontact.click();
		// btn_fullSearchform.click();
		return new ContactsPage();
	}

}
