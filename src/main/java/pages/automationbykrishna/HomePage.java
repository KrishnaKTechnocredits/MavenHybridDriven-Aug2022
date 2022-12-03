package pages.automationbykrishna;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PredefinedActions {

    @FindBy(css = "div#indexBody")
    WebElement homePageLocator;

    @FindBy(css = "a#demotable")
    WebElement demoTableTab;

    private static HomePage homePage;

    private HomePage() {

    }

    public static HomePage getInstance() {
        if (homePage == null)
            homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        return homePage;
    }

    public boolean isHomePageDisplayed() {
        return isElementDisplayed(homePageLocator);
    }

    public void clickOnDemoTableTab(){
        clickOnElement(demoTableTab, false);
    }

}
