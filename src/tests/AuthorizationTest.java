package tests;

import lib.ui.AuthorizationPageObject;
import lib.ui.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.androidPageObject.AndroidAuthorizationPageObject;
import lib.ui.androidPageObject.AndroidNavigationUI;
import org.junit.Test;

public class AuthorizationTest extends CoreTestCase {
    String login = "888-1@mailu.onlinepbx.ru";
    String password = "556898";
    String domain = "test8test8.test.onpbx.ru";
    @Test
    public void testSuccessfulAuthorization(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);
        NavigationUI NavigationUI = new AndroidNavigationUI(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys(login);
        AuthorizationPageObject.passwordSendKeys(password);
        AuthorizationPageObject.buttonLoginClick();

        NavigationUI.clickNavigationAccount();



    }
}
