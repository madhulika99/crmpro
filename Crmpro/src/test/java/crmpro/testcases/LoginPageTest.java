package crmpro.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmpro.base.TestBase;
import crmpro.pages.HomePage;
import crmpro.pages.LoginPage;
import crmpro.utilities.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();

	}

	@Test(priority = 1, description = "login test")
	public void loginpageTitleTest() {
		String title = loginpage.validateLoginPagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}

	@Test(priority = 2, description = "crmlogo test")
	public void crmlogotest() {
		boolean F = loginpage.validateCrmLogo();
		Assert.assertTrue(F, "logo not displayed");
	}

	@Test(priority = 3, description = "login test")
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
@AfterMethod
public void tearDown(ITestResult result) throws IOException {
	testutil.takesScreenShotAtEndOfTest(driver, result.getName());
	driver.quit();
}

}
