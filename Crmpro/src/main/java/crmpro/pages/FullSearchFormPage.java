package crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crmpro.base.TestBase;

public class FullSearchFormPage extends TestBase {

	@FindBy(xpath = "//select[@name='cs_title']")
	WebElement sel_title;

	@FindBy(xpath = "//input[@name='cs_first_name']")
	WebElement txt_firstname;

	@FindBy(xpath = "//input[@name='cs_middle_initial']")
	WebElement txt_midname;

	@FindBy(xpath = "//input[@name='cs_surname']")
	WebElement txt_lastname;

	@FindBy(xpath = "//input[@name='cs_company_name']")
	WebElement txt_company;

	@FindBy(xpath = "//input[@name='cs_company_position']")
	WebElement txt_position;

	@FindBy(xpath = "//input[@name='cs_home_phone']")
	WebElement txt_homephone;

	public FullSearchFormPage() {
		PageFactory.initElements(driver, this);
	}

	public FullSearchFormPage fullsearchformDetails(String title, String FSname, String Mname, String Lname,
			String comp, String dept, String phone) {
		Select S1 = new Select(sel_title);
		S1.selectByVisibleText(title);
		txt_firstname.clear();
		txt_midname.clear();
		txt_lastname.clear();
		txt_company.clear();
		txt_position.clear();
		txt_homephone.clear();

		txt_firstname.sendKeys(FSname);
		txt_midname.sendKeys(Mname);
		txt_lastname.sendKeys(Lname);
		txt_company.sendKeys(comp);
		txt_position.sendKeys(dept);
		txt_homephone.sendKeys(phone);
		return new FullSearchFormPage();
	}
}
