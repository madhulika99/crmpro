package crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import crmpro.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password;

	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement btn_login;

	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive'] ")
	WebElement img_crmlogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPagetitle() {
		return driver.getTitle();
	}

	public boolean validateCrmLogo() {
		return img_crmlogo.isDisplayed(); // this will return boolean value so return type is boolean

	}

	public HomePage login(String uname, String pwd) {
		txt_username.sendKeys(uname);
		txt_password.sendKeys(pwd);
		btn_login.click();
		return new HomePage();

	}
}
