package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import components.NavigationMenu;
import static org.junit.Assert.assertTrue;
import static java.lang.System.out;

public class AccountsPage extends AuthenticatedPage {

    private final NavigationMenu navigationMenu;

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(tagName = "table")
    private WebElement accountsTable;

    public AccountsPage(WebDriver driver) {

        super(driver);
        this.navigationMenu = new NavigationMenu(driver);
    }

    public boolean isInitialized() {
        return header.isDisplayed();
    }

    public void checkAccountsTableData(String [] accountAndBalance) {

        WebElement row = accountsTable.findElement(By.xpath("//tr[td[contains(text(),'" + accountAndBalance[0] + "')]]"));
        //System.out.println(row.getText());
        assertTrue(row.getText().contains(accountAndBalance[1]));
    }

}
