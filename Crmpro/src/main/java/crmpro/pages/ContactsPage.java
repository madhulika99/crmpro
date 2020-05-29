package crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crmpro.base.TestBase;
import crmpro.utilities.TestUtil;

public class ContactsPage extends TestBase {

	ContactsPage contactspage;
	TestUtil testutil;

	@FindBy(xpath = ("//select[@name='title']"))
	WebElement tit;

	@FindBy(xpath = ("//input[@id='first_name']"))
	WebElement Fstname;

	@FindBy(xpath = ("//input[@id='middle_initial']"))
	WebElement Midname;

	@FindBy(xpath = ("//input[@id='surname']"))
	WebElement Lasname;

	@FindBy(xpath = "//input[@id='company_position']")
	WebElement Comp;

	@FindBy(xpath = "//select[@name='category']")
	WebElement Catgry;

	@FindBy(xpath = "//input[@id='fieldId_birthday']")
	WebElement bday;
	
	@FindBy(xpath = "//input[@value ='Save and Create Another (same company)']")
	WebElement Save;

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public void createContacts(String Title, String FirstName, String MiddleName, String LastName,
			String Company) {

		// tit.clear();
		Select S1 = new Select(tit);
		S1.selectByVisibleText(Title);

		Fstname.clear();
		Midname.clear();
		Lasname.clear();
		Comp.clear();
		//Catgry.clear();
		
		
		Fstname.sendKeys(FirstName);
		Midname.sendKeys(MiddleName);
		Lasname.sendKeys(LastName);
		Comp.sendKeys(Company);
		//Catgry.sendKeys(Position);
		

		
		//return new ContactsPage();

	}
	public void selDateByJS(WebDriver driver,  String Dateval) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		//js.executeScript(script, args)
		 js.executeScript("arguments[0].setAttribute('value','" + Dateval + "');", bday);
		 
		// return;
	}
	public  ContactsPage saveBtn() {
		Save.click();
		return new ContactsPage();
		
	}
}
