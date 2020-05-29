package crmpro.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmpro.base.TestBase;
import crmpro.pages.ContactsPage;
import crmpro.pages.HomePage;
import crmpro.pages.LoginPage;
import crmpro.utilities.TestUtil;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, description = "homepage test")

	public void contactsLinkTest() throws InterruptedException {
		testutil.switchtoframe();
		contactspage = homepage.contactsLink();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		testutil.takesScreenShotAtEndOfTest(driver, result.getName());
		//driver.quit();
	}
}
