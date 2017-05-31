package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageObject {

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name="change")
    private WebElement changeButton;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return header.isDisplayed();
    }

    public void enterPasswords(String password, String confirmPassword){
        this.password.clear();
        this.password.sendKeys(password);

        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public LoginPage changePassword(){
        changeButton.click();
        return new LoginPage(driver);
    }
}
