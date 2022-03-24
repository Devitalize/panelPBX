package tests;

import uiPageObject.AccountPageObject;
import uiPageObject.AuthorizationPageObject;
import uiPageObject.CoreTestCase;
import uiPageObject.NavigationUI;
import org.junit.Test;

public class AccountTest extends CoreTestCase {

    String login = "888-1@mailu.onlinepbx.ru";
    String password = "556898";

    //Смена имени в профиле
    @Test
    public void testProfileNameRename() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        AuthorizationPageObject.successfulAuthorization(login, password);
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        AccountPageObject.nameClick();
        String new_name = AccountPageObject.nameFromDate();
        AccountPageObject.editProfileSendKeys(new_name);
        AccountPageObject.buttonApplyClick();
        String name = AccountPageObject.getNameText();
        assertEquals(
                name,
                new_name
        );
    }

    //Смена номера телефона в профиле
    @Test
    public void testProfileNumberEdit() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        AuthorizationPageObject.successfulAuthorization(login, password);
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        String new_phone = AccountPageObject.getNewPhone();
        AccountPageObject.numberClick();
        AccountPageObject.editProfileSendKeys(new_phone);
        AccountPageObject.buttonApplyClick();
        String phone = AccountPageObject.getPhoneText();
        assertEquals(
                phone,
                new_phone
        );
    }

    //Смена почты в профиле

    //Смена пароля в профиле

    //Смена часового пояса в профиле
    @Test
    public void testProfileTimeZoneEdit() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        AuthorizationPageObject.successfulAuthorization(login, password);
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        String old_time_zone = AccountPageObject.getTimeZoneText();
       String time_zone = AccountPageObject.timeZoneSelect(old_time_zone);
        AccountPageObject.timeZoneClick();
        AccountPageObject.timeZoneSelectClick(time_zone);
        assertEquals(
                AccountPageObject.getTimeZoneText(),
                "UTC" + time_zone);
    }

    //Отображение часового пояса +0
    @Test
    public void testProfileTimeZoneEditForNull() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        AuthorizationPageObject.successfulAuthorization(login, password);
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        String old_time_zone = AccountPageObject.getTimeZoneText().replace("UTC", "");
        String time_zone = "+0";
        AccountPageObject.timeZoneClick();
        AccountPageObject.timeZoneSelectClick(time_zone);
        assertEquals(
                AccountPageObject.getTimeZoneText(),
                "UTC" + time_zone);
        AccountPageObject.timeZoneClick();
        AccountPageObject.timeZoneSelectClick(old_time_zone); //Возвращаем предыдущую тайм-зону для проверок остальных тайм-зон
    }


    //Смена режима защиты по айпи в профиле
}
