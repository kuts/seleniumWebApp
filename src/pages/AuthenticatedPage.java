package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import components.NavigationMenu;

public class AuthenticatedPage extends PageObject {

    private final NavigationMenu navigationMenu;

    @FindBy(xpath = ("//p[@class='navbar-text navbar-right']"))
    private WebElement navBarText;

    public AuthenticatedPage(WebDriver driver) {

        super(driver);
        this.navigationMenu = new NavigationMenu(driver);
    }

    public boolean isInitialized() {
        return navBarText.isDisplayed();
    }

    public String confirmationGreeting(){
        return navBarText.getText();
    }

    public NavigationMenu navigationMenu() {

        return navigationMenu;
    }

}
