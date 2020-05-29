package crmpro.testcases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmpro.base.TestBase;
import crmpro.pages.ContactsPage;
import crmpro.pages.FullSearchFormPage;
import crmpro.pages.HomePage;
import crmpro.pages.LoginPage;
import crmpro.utilities.TestUtil;

public class FullSearchFormPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	FullSearchFormPage fullpage;
	public static ResultSet rs;
	public Statement stmnt;
	public Connection con;
	public ArrayList<Object> dataar;

	public FullSearchFormPageTest() {
		super();
	}

	@BeforeClass
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

	@Test(priority = 1, description = "full search form details filling")

	public void fullseaarchformDetailsTest() throws SQLException {
		dataar = new ArrayList<Object>();
		while (rs.next()) {
			String title = rs.getString("Title");
			String FSname = rs.getString("FirstName");
			String Mname = rs.getString("Middlename");
			String Lname = rs.getString("Lastname");
			String comp = rs.getString("Company");
			String dept = rs.getString("Postion");
			String phone = rs.getString("Home_phone");

			fullpage.fullsearchformDetails(title, FSname, Mname, Lname, comp, dept, phone);
			dataar.add(title);
			dataar.add(FSname);
			dataar.add(Mname);
			dataar.add(Lname);
			dataar.add(comp);
			dataar.add(dept);
			dataar.add(phone);

		}
		System.out.println("data in web arraylist " + dataar);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, SQLException {
		testutil.takesScreenShotAtEndOfTest(driver, result.getName());
		rs.close();
		con.close();
		stmnt.close();
	}
}
