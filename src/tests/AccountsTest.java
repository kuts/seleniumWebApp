package tests;

import utility.Constant;
import pages.LoginPage;
import pages.AccountsPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AccountsTest extends FunctionalTest {

    @Test
    public void ViewAccountsForUser() {
        FunctionalTest.driver.get(Constant.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.loginAndAuthenticate(Constant.USER1, Constant.USER1PASSWORD);

        AccountsPage accountsPage = new AccountsPage(FunctionalTest.driver);
        assertTrue(accountsPage.isInitialized());
        accountsPage.checkAccountsTableData(Constant.USER1ACCOUNT1BALANCE);
        accountsPage.checkAccountsTableData(Constant.USER1ACCOUNT2BALANCE);
    }
}
