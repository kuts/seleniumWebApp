package components;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.PageObject;
import org.openqa.selenium.WebDriver;

public class NavigationMenu extends PageObject {

    @FindBy(linkText = ("Logout"))
    private WebElement logoutLink;

    public NavigationMenu (WebDriver driver) {
        super(driver);
    }

    public LoginPage logout(){
        logoutLink.click();
        return new LoginPage(driver);
    }
}

