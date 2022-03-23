package tests;

import org.junit.Test;
import uiPageObject.*;

public class RegistrationPageNameAndPhoneTest extends CoreTestCase {

    String name = "Test Имя Владельца аккаунта123";
    String phone = "79827216281";

    //Успешная регистрация
    @Test
    public void testSuccessfulRegistrations() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        String email = RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.createAccountClick();
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        AccountPageObject.assertNamePhoneEmail(name, phone, email);
    }

    //Отображение ошибки при пустом поле имени
    @Test
    public void testEmptyName() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.createAccountClick();
        String error_text = RegistrationPageObject.getTextError();
        assertEquals(
                "Укажите имя",
                error_text
        );
    }

    //Отображение ошибки при пустом поле телефона
    @Test
    public void testEmptyPhone() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.createAccountClick();
        String error_text = RegistrationPageObject.getTextError();
        assertEquals(
                "Укажите номер телефона",
                error_text
        );
    }

    //Отображение ошибки при номере телефона из 10 цифр
    @Test
    public void testPhone10Digits() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys("1234567890");
        RegistrationPageObject.createAccountClick();
        String error_text = RegistrationPageObject.getTextError();
        assertEquals(
                "В номере должно быть не менее 11 цифр",
                error_text
        );
    }

    //Ограничение на ввод в поле номера телефона 14 цифр
    @Test
    public void testPhoneFrom14Numbers() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys("12345678901234");
        String phone_text = RegistrationPageObject.getPhoneText();
        assertEquals(
                "1234567890123",
                phone_text
        );
    }

    //Отсутствие ошибки при вводе телефона из 12 цифр

    //Отсутствие ошибки при вводе телефона из 13 цифр

    //Отсутствие ошибки при номере телефона с + в начале

    //Спец.символы не считаются при вводе номера телефона
    @Test
    public void testPhoneSymbol() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys("12345%^^&*12");
        RegistrationPageObject.createAccountClick();
        String error_text = RegistrationPageObject.getTextError();
        assertEquals(
                "В номере должно быть не менее 11 цифр",
                error_text
        );
    }

    //Отображение ошибки при вводе несуществующего промокода
    @Test
    public void testPromocodeDoesNotExist() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.promocodeButtonClick();
        RegistrationPageObject.promocodeSendKeys("NOTPROMOCODE987");
        RegistrationPageObject.createAccountClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Вы указали недействительный промокод",
                text_error
        );
    }

    //Отображение ошибки при вводе деактивированного промокода
    @Test
    public void testPromocodeDeactivated() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.promocodeButtonClick();
        RegistrationPageObject.promocodeSendKeys("QWER123");
        RegistrationPageObject.createAccountClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Вы указали недействительный промокод",
                text_error
        );
    }

    //Создание аккаунта при клике на кнопку СОЗДАТЬ БЕЗ ПРОМОКОДА
    @Test
    public void testSuccessfulRegistrationsNotPromocode() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        AccountPageObject AccountPageObject = new AccountPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        String email = RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.promocodeButtonClick();
        RegistrationPageObject.promocodeSendKeys("QWER123");
        RegistrationPageObject.createAccountClick();
        RegistrationPageObject.signupWithoutPromocodeClick();
        NavigationUI.clickNavigationAccount();
        AccountPageObject.profileClick();
        AccountPageObject.assertNamePhoneEmail(name, phone, email);
    }

    //Создание аккаунта с действующим промокодом

    //Возвращение на приветственный экран при клике на крестик
    public void testReturnToWelcomeScreen() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.buttonXclick();
        String title_text = WelcomeScreenPageObject.getTitleWelcomeScreen();
        assertEquals(
                "ов",
                title_text
        );
    }

    //Возвращение на предыдущий экран с предзаполненными полями при клике на стрелку назад
    public void testReturnToMailInputScreen() {
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        String email = RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        RegistrationPageObject.buttonBackClick();
        assertEquals(
                RegistrationPageObject.getEmailText(),
                email
        );
        RegistrationPageObject.buttonEyeClick(); //В ДАННЫЙ МОМЕНТ ЭТО НЕ ОБЯЗАТЕЛЬНО Т.К. ДАЖЕ ПРИ СКРЫТОМ ПАРОЛЕ ТЕКСТ ВИДЕН В АТРИБУТЕ text
        String password = RegistrationPageObject.getPasswordText();
        assertEquals(
                "test888TEST",
                password
        );
    }

    //Отображение ошибки при отсутствии интернета
    public void testNoConnection(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);
        SystemSettingsPageObject SystemSettingsPageObject = new SystemSettingsPageObject(driver);

        SystemSettingsPageObject.switchingAirplaneMode();
        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailAndPasswordSendKeysAndContinue();
        SystemSettingsPageObject.switchingAirplaneMode();
        RegistrationPageObject.nameSendKeys(name);
        RegistrationPageObject.phoneSendKeys(phone);
        RegistrationPageObject.createAccountClick();
        String text_error = RegistrationPageObject.getTitleError();
        assertEquals(
                "Отсутствует подключение",
                text_error
        );
        SystemSettingsPageObject.switchingAirplaneMode();

    }

}
