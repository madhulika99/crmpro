package crmpro.testcases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import crmpro.base.TestBase;
import crmpro.pages.ContactsPage;
import crmpro.pages.FullSearchFormPage;
import crmpro.pages.HomePage;
import crmpro.pages.LoginPage;
import crmpro.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	FullSearchFormPage fullpage;
	public static ResultSet rs;
	public Statement stmnt;
	public Connection con;
	public ArrayList<Object> dataar;
	public ExtentHtmlReporter htmlreporter;
	public ExtentTest logger;
	public ExtentReports extent;

	public ContactsPageTest() {
		super(); /*
					 * to call the constructor of super class that is TestBase Class as we have to
					 * initialise properties of file to, to avoid null point exception
					 */
	}
	
	@BeforeTest
	public void extentSetup() {
		String Datenam = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String currentDir = System.getProperty("user.dir");
		htmlreporter = new ExtentHtmlReporter(currentDir + "\\test-output\\" + Datenam + ".html");
		htmlreporter.config().setDocumentTitle("Autoamtion report");
		htmlreporter.config().setReportName("functional testing");
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("tester", "Madhulika");

	}

	@BeforeClass // The annotated method will be run before the first test method in the current
					// class is invoked.

	// @BeforeTest
	// @BeforeMethod ----- The annotated method will be run before each test method.

	public void setup() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactsdetails", "root", "munmun86");
		stmnt = con.createStatement();
		String Query1 = "select * from listofcontacts;";
		rs = stmnt.executeQuery(Query1);
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		fullpage = new FullSearchFormPage();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactspage = homepage.contactsLink();
	}

	// Data driven framework to get data from excel to create new contacts

	@Test(priority = 1)

	public void createNewContactsTest() throws SQLException {
		logger = extent.createTest("Create New Test");
		while (rs.next()) {
			String Title = rs.getString("Title");
			String FirstName = rs.getString("FirstName");
			String MiddleName = rs.getString("Middlename");
			String LastName = rs.getString("Lastname");
			String Company = rs.getString("Company");
			//String Postion = rs.getString("Postion");
			String Birthday = rs.getString(8);

			contactspage.createContacts(Title, FirstName, MiddleName, LastName, Company);
			contactspage.selDateByJS(driver, Birthday);
			contactspage.saveBtn();

		}
	}

	@AfterMethod // The annotated method will be run after all the test methods in the current `E
					// class have been run.
	public void tearDown(ITestResult result) throws IOException, SQLException {
		testutil.takesScreenShotAtEndOfTest(driver, result.getName());
		String screenshotpath = testutil.takesScreenShotForLogging(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test case failed is " + result.getName()); // to log method name which failed
			logger.log(Status.FAIL, "Test Case failed is " + result.getThrowable()); // to log all exceptions and errors
			logger.addScreenCaptureFromPath(screenshotpath); // add screenshot in the extentreport

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "TestCase skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "TestCase passed is " + result.getName());
		}
		//extent.flush();

		rs.close();
		con.close();
		stmnt.close();
		// driver.quit();
	}
	@AfterTest
	public void extentClose() {
		extent.flush();
	}

}
