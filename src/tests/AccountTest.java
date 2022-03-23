package tests;

import lib.ui.AccountPageObject;
import lib.ui.AuthorizationPageObject;
import lib.ui.CoreTestCase;
import lib.ui.NavigationUI;
import org.junit.Test;

public class AccountTest extends CoreTestCase {

    String login = "888-1@mailu.onlinepbx.ru";
    String password = "556898";
    @Test
    public void testProfileNameRename(){
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        AuthorizationPageObject.successfulAuthorization(login, password);
        NavigationUI.clickNavigationAccount();
    }
}
