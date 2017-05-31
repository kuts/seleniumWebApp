package tests;

import utility.Constant;
import pages.LoginPage;
import pages.ChangePasswordPage;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginTest extends FunctionalTest {

    @Test
    public void LogInAsExistingUser(){
        FunctionalTest.driver.get(Constant.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.loginAndAuthenticate(Constant.USER1, Constant.USER1PASSWORD);
    }

    @Test
    public void LogInAsNewUser(){

        FunctionalTest.driver.get(Constant.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);
        assertTrue(loginPage.isInitialized());

        loginPage.enterUserCredentials(Constant.NEWUSER1, Constant.NEWUSER1PASSWORD);

        Random rand = new Random(System.currentTimeMillis());
        int num = rand.nextInt(1000);

        ChangePasswordPage changePasswordPage = loginPage.submitAndChangePassword();
        assertTrue(changePasswordPage.isInitialized());
        changePasswordPage.enterPasswords(Constant.NEWUSER1PASSWORD + num ,Constant.NEWUSER1PASSWORD + num);
        // actually change the password for the user
        // LoginPage reloginPage = changePasswordPage.changePassword();
        // reloginPage.loginAndAuthenticate(Constant.NEWUSER1, Constant.NEWUSER1PASSWORD + num);
    }

    @Test
    public void LogInAsAdminUser(){
        FunctionalTest.driver.get(Constant.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.loginAndAuthenticate(Constant.ADMIN1, Constant.ADMIN1PASSWORD);
    }
}
