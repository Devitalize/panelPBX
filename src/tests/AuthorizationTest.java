package tests;

import lib.ui.*;
import lib.ui.androidPageObject.AndroidAccountPageObject;
import lib.ui.androidPageObject.AndroidAuthorizationPageObject;
import lib.ui.androidPageObject.AndroidNavigationUI;
import lib.ui.androidPageObject.AndroidSystemSettingsPageObject;
import org.junit.Test;

public class AuthorizationTest extends CoreTestCase {
    String login = "888-1@mailu.onlinepbx.ru";
    String password = "556898";
    String domain = "test8test8.test.onpbx.ru";
    @Test
    //Успешная авторизация
    public void testSuccessfulAuthorization(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);
        NavigationUI NavigationUI = new AndroidNavigationUI(driver);
        AccountPageObject AccountPageObject = new AndroidAccountPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys(login);
        AuthorizationPageObject.passwordSendKeys(password);
        AuthorizationPageObject.buttonLoginClick();

        NavigationUI.clickNavigationAccount();
        String domain_text = AccountPageObject.getDomainText();
        assertEquals(
                domain,
                domain_text
        );
    }

    //Отображение ошибки при пустом логине
    @Test
    public void testEmptyLogin() {
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordSendKeys(password);
        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTextError();
        assertEquals(
                "Введите email-адрес",
                error_text
        );
    }

    //Отображение ошибки при пустом пароле
    @Test
    public void testEmptyPassword() {
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys(login);
        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTextError();
        assertEquals(
                "Введите пароль",
                error_text
        );
    }

    //Отображение ошибки при вводе невалидного логина
    @Test
    public void testLoginInvalid(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys("111");
        AuthorizationPageObject.passwordSendKeys(password);
        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTextError();
        assertEquals(
                "Кажется, вы ошиблись при вводе email-адреса",
                error_text
        );
    }

    //Отображение ошибки при отсутствии данной почты в системе
    @Test
    public void testLoginDoesNotExist(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys("111@nologin.com");
        AuthorizationPageObject.passwordSendKeys(password);
        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTextError();
        assertEquals(
                "Аккаунта с таким email-адресом нет в системе",
                error_text
        );
    }

    //Отображение ошибки при неверном пароле
    @Test
    public void testIncorrectPassword(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys(login);
        AuthorizationPageObject.passwordSendKeys("1234567890");
        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTextError();
        assertEquals(
                "Неправильный пароль",
                error_text
        );
    }

    //Отображение ошибки при отсутствии интернета
    @Test
    public void testNoConnection(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);
        SystemSettingsPageObject SystemSettingsPageObject = new AndroidSystemSettingsPageObject(driver);

        SystemSettingsPageObject.enableAirplaneMode();
        AuthorizationPageObject.buttonLoginClick();
        AuthorizationPageObject.loginSendKeys(login);
        AuthorizationPageObject.passwordSendKeys("1234567890");

        AuthorizationPageObject.buttonLoginClick();
        String error_text = AuthorizationPageObject.getTitleError();
        assertEquals(
                "Отсутствует подключение",
                error_text
        );
        SystemSettingsPageObject.disableAirplaneMode();
    }

    //Возврат на приветственный экран
    @Test
    public void testReturnToWelcomeScreen(){
        AuthorizationPageObject AuthorizationPageObject = new AndroidAuthorizationPageObject(driver);

        AuthorizationPageObject.buttonLoginClick();

    }
}
