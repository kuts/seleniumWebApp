package tests;

import utility.Constant;
import pages.LoginPage;
import pages.AuthenticatedPage;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LogoutTest extends FunctionalTest {

    @Test
    public void LogOut(){
        FunctionalTest.driver.get(Constant.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        AuthenticatedPage authenticatedPage = loginPage.loginAndAuthenticate(Constant.USER1, Constant.USER1PASSWORD);

        LoginPage reloginPage = authenticatedPage.navigationMenu().logout();
        assertTrue(reloginPage.isInitialized());
    }
}