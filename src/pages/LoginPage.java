package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

public class LoginPage extends PageObject {

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public boolean isInitialized() {
        return username.isDisplayed();
    }

    public void enterUserCredentials(String username, String password){
        this.username.clear();
        this.username.sendKeys(username);

        this.password.clear();
        this.password.sendKeys(password);
    }

    public AuthenticatedPage submit(){
        submitButton.click();
        return new AuthenticatedPage(driver);
    }

    public ChangePasswordPage submitAndChangePassword(){
        submitButton.click();
        return new ChangePasswordPage(driver);
    }

    public AuthenticatedPage loginAndAuthenticate(String username, String password){
        assertTrue(this.isInitialized());
        this.enterUserCredentials(username, password);
        AuthenticatedPage authenticatedPage = this.submit();
        assertTrue(authenticatedPage.isInitialized());
        assertTrue(authenticatedPage.confirmationGreeting().contains(username));
        return new AuthenticatedPage(driver);
    }
}
