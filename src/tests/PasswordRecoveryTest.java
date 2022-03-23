package tests;

import uiPageObject.AuthorizationPageObject;
import uiPageObject.CoreTestCase;
import uiPageObject.PasswordRecoveryPageObject;
import uiPageObject.WelcomeScreenPageObject;
import org.junit.Test;

public class PasswordRecoveryTest extends CoreTestCase {

    String login = "888-1@mailu.onlinepbx.ru";

    //Восстановление пароля ДОПИСАТЬ, КОГДА ПОЯВИТСЯ РЕШЕНИЕ ДЛЯ ПРОВЕРКИ ОТПРАВЛЕННОГО ЗАПРОСА
    @Test
    public void testPasswordRecovery(){
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        PasswordRecoveryPageObject PasswordRecoveryPageObject = new PasswordRecoveryPageObject(driver);

        WelcomeScreenPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordRecoveryClick();
        PasswordRecoveryPageObject.emailSendKeys(login);
        PasswordRecoveryPageObject.buttonRecoveryClick();
        String description_successfully_password_recovery = PasswordRecoveryPageObject.getDescriptionPasswordRecovery();
        assertEquals(
                "Мы отправили ссылку для восстановления доступа на адрес " + login,
                description_successfully_password_recovery
        );
        System.out.println("ДОПИСАТЬ, КОГДА ПОЯВИТСЯ РЕШЕНИЕ ДЛЯ ПРОВЕРКИ ОТПРАВЛЕННОГО ЗАПРОСА");
    }

    //Отображение ошибки при отсутствии почты в системе на экране восстановления пароля(НЕТ ПРОВЕРКИ НА ВАЛИДНОСТЬ ПОЧТЫ)
    @Test
    public void testIncorrectPasswordRecovery() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        PasswordRecoveryPageObject PasswordRecoveryPageObject = new PasswordRecoveryPageObject(driver);

        WelcomeScreenPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordRecoveryClick();
        PasswordRecoveryPageObject.emailSendKeys("вапро");
        PasswordRecoveryPageObject.buttonRecoveryClick();
        String text_error = PasswordRecoveryPageObject.getTextErrorEmail();
        assertEquals(
                "Аккаунта с таким email-адресом нет в системе",
                text_error
        );
    }

    //Возвращение на экран авторизации при клике на крестик на странице восстановления пароля
    @Test
    public void testReturnLoginScreen() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        PasswordRecoveryPageObject PasswordRecoveryPageObject = new PasswordRecoveryPageObject(driver);

        WelcomeScreenPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordRecoveryClick();
        PasswordRecoveryPageObject.buttonXclick();
        String title_text = AuthorizationPageObject.getTitleText();
        assertEquals(
                "Вход",
                title_text
        );
    }
    //Возвращение на экран авторизации при клике на крестик на странице восстановления пароля после успешной отправки запроса на восстановление
    @Test
    public void testReturnLoginScreenFromButtonXSuccessfullPasswordRecovery() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        PasswordRecoveryPageObject PasswordRecoveryPageObject = new PasswordRecoveryPageObject(driver);

        WelcomeScreenPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordRecoveryClick();
        PasswordRecoveryPageObject.emailSendKeys(login);
        PasswordRecoveryPageObject.buttonRecoveryClick();
        String description_successfully_password_recovery = PasswordRecoveryPageObject.getDescriptionPasswordRecovery();
        assertEquals(
                "Мы отправили ссылку для восстановления доступа на адрес " + login,
                description_successfully_password_recovery
        );
        PasswordRecoveryPageObject.buttonXclick();
        String title_text = AuthorizationPageObject.getTitleText();
        assertEquals(
                "Вход",
                title_text
        );
    }

    //Переход на экран авторизации при клике на кнопку Войти с экрана успешной отправки сообщения для смены пароля
    @Test
    public void testReturnLoginScreenFromButtonLoginSuccessfullPasswordRecovery() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        PasswordRecoveryPageObject PasswordRecoveryPageObject = new PasswordRecoveryPageObject(driver);

        WelcomeScreenPageObject.buttonLoginClick();
        AuthorizationPageObject.passwordRecoveryClick();
        PasswordRecoveryPageObject.emailSendKeys(login);
        PasswordRecoveryPageObject.buttonRecoveryClick();
        PasswordRecoveryPageObject.buttonLoginClick();
        String title_text = AuthorizationPageObject.getTitleText();
        assertEquals(
                "Вход",
                title_text
        );
    }

}
