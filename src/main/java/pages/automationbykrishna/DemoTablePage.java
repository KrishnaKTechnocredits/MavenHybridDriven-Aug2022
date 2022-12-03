package pages.automationbykrishna;

import base.PredefinedActions;
import entity.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoTablePage extends PredefinedActions {

    @FindBy(xpath = "//table[@id='table1']")
    WebElement employeeBasicInfo;


    private static DemoTablePage demoTablePage;

    private DemoTablePage() {

    }

    public static DemoTablePage getInstance() {
        if (demoTablePage == null)
            demoTablePage = new DemoTablePage();
        PageFactory.initElements(driver, demoTablePage);
        return demoTablePage;
    }


    public List<Employee> capatureBassicEmployeeDetails() {
        List<Employee> employeeList = new ArrayList<>();
        waitForVisibilityOfElement(employeeBasicInfo);

        List<WebElement> totalRowElements = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        List<WebElement> totalColums = driver.findElements(By.xpath("//table[@id='table1']//thead/tr[1]/th"));

        for (int i = 1; i <= totalRowElements.size(); i++) {
            String empNum = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[1]")).getText();
            String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[2]")).getText();
            String lastName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[3]")).getText();
            String userName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[4]")).getText();
            employeeList.add(new Employee(empNum, firstName, lastName, userName));
        }
        return employeeList;
    }
}
