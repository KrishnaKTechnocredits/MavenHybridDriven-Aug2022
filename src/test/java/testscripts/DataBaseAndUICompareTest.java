package testscripts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.SQLQuery;
import entity.Employee;
import pages.automationbykrishna.DemoTablePage;
import pages.automationbykrishna.HomePage;
import utility.DataBaseConnection;

public class DataBaseAndUICompareTest extends TestBase {

	@Test
	public void compareUIandDBDatab() throws SQLException {
		HomePage home = HomePage.getInstance();
		Assert.assertTrue(home.isHomePageDisplayed(), "Home page not displayed");

		home.clickOnDemoTableTab();

		DemoTablePage demo = DemoTablePage.getInstance();
		List<Employee> uiEmpList = demo.capatureBassicEmployeeDetails();

		DataBaseConnection connection = new DataBaseConnection();
		ResultSet resultSet = connection.execuetSelectQuery(SQLQuery.SELECT_EMPLOYEE_BASIC_INFORMATION);

		List<Employee> dbEmployeeList = new ArrayList<>();
		while (resultSet.next()) {
			String empNum = resultSet.getString("num");
			String firstName = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String username = resultSet.getString("username");
			dbEmployeeList.add(new Employee(empNum, firstName, lastname, username));
		}
		connection.closeConnection();
		Assert.assertEquals(dbEmployeeList, uiEmpList, "Data mis-matched");
	}

}
