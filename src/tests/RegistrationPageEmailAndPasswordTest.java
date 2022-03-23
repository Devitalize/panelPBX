package tests;

import lib.ui.CoreTestCase;
import lib.ui.RegistrationPageObject;
import lib.ui.SystemSettingsPageObject;
import lib.ui.WelcomeScreenPageObject;
import org.junit.Test;

public class RegistrationPageEmailAndPasswordTest extends CoreTestCase {
    String email = "noRegisterEmail@test.com";
    String password = "test888TEST";

    //Отображение ошибки “Введите email-адрес” при клике на “Продолжить” при пустых полях почты и пароля.
    @Test
    public void testEmptyEmailAndPassword(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Введите email-адрес",
                text_error
        );
    }

    //Отображение ошибки “Введите email-адрес” при клике на “Продолжить” при пустом поле почты, но заполненном пароле.
    @Test
    public void testEmptyEmail(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.passwordSendKeys(password);
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Введите email-адрес",
                text_error
        );
    }

    //Отображение ошибки “Введите пароль” при клике на “Продолжить” при пустом поле пароля.
    @Test
    public void testEmptyPassword(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Введите пароль",
                text_error
        );
    }

    //Отображение ошибки “Уже есть аккаунт с таким email-адресом” при вводе почты, на которую уже зарегистрирован аккаунт и валидного пароля.
    @Test
    public void testEmailIsUsed(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys("888-1@mailu.onlinepbx.ru");
        RegistrationPageObject.passwordSendKeys(password);
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Уже есть аккаунт с таким email-адресом",
                text_error
        );
    }

    //Отображение ошибки “Кажется, вы ошиблись при вводе email-адреса” при вводе невалидной почты. ТУТ ЖДУ РЕШЕНИЯ ПО КОЛИЧЕСТВУ ТЕСТОВ НА ВАЛИДАЦИЮ
    @Test
    public void testEmailInvalid(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys("888mailu.onlinepbx.ru");
        RegistrationPageObject.passwordSendKeys(password);
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Кажется, вы ошиблись при вводе email-адреса",
                text_error
        );
    }

    //Отображение ошибки “Допустимы символы только латинского алфавита” при вводе почты с русскими символами.
    @Test
    public void testEmailInvalidRus(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys("888@почта.ru");
        RegistrationPageObject.passwordSendKeys(password);
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Допустимы символы только латинского алфавита",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль короче шести символов. Отображение ошибки “Пароль должен быть не менее 6 символов”.
    @Test
    public void testPasswordShort(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("qwer");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Пароль должен быть не менее 6 символов",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль > 6 символов, содержит спец.символы. Отображение ошибки “Используйте только латинские символы и цифры".
    @Test
    public void testPasswordSpecialCharacters(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("qwer!@#$");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Используйте только латинские символы и цифры",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль > 6 символов, не содержит числа. Отображение ошибки “Пароль должен содержать минимум 1 цифру”.
    @Test
    public void testPasswordNoNumbers(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("qwerTYqwerty");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Пароль должен содержать минимум 1 цифру",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль > 6 символов, не содержит строчную букву латинского алфавита. Отображение ошибки “Пароль должен содержать строчную букву”.
    @Test
    public void testPasswordNoLowercaseLetter(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("qwer123qwerty");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Добавьте в пароль латинскую прописную букву",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль > 6 символов, не содержит прописную букву латинского алфавита. Отображение ошибки “Пароль должен содержать прописную букву”.
    @Test
    public void testPasswordNoUppercaseLetter(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("QWE123QWERTY");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Добавьте в пароль латинскую прописную букву",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль < 6 символов, содержит 1 цифру, одну строчную и одну прописную буквы латинского алфавита. Отображение ошибки “Пароль должен быть не менее 6 символов”.
    @Test
    public void testPasswordShortValid(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("12qwE");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Пароль должен быть не менее 6 символов",
                text_error
        );
    }

    //Проверка сложности пароля. Пароль содержит русские буквы. Ошибка “Используйте для пароля только латинские символы и цифры.”.
    @Test
    public void testPasswordRus(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("12Русский");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTextError();
        assertEquals(
                "Используйте только латинские символы и цифры",
                text_error
        );
    }

    //Отображение ошибки при отсутствии интернета
    @Test
    public void testNoConnection(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        SystemSettingsPageObject SystemSettingsPageObject = new SystemSettingsPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        SystemSettingsPageObject.switchingAirplaneMode();
        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.emailSendKeys(email);
        RegistrationPageObject.passwordSendKeys("123QWerty");
        RegistrationPageObject.continueClick();
        String text_error = RegistrationPageObject.getTitleError();
        assertEquals(
                "Отсутствует подключение",
                text_error
        );
        SystemSettingsPageObject.switchingAirplaneMode();
    }

    //Отображение пароля точками.
    //Смена видимости пароля при клике на иконку глазика

    //Возвращение на приветственный экран при клике на крестик
    @Test
    public void testClickButtonX(){
        WelcomeScreenPageObject WelcomeScreenPageObject = new WelcomeScreenPageObject(driver);
        RegistrationPageObject RegistrationPageObject = new RegistrationPageObject(driver);

        WelcomeScreenPageObject.buttonRegisterClick();
        RegistrationPageObject.buttonXclick();
        String text_title_welcome_page = WelcomeScreenPageObject.getTitleWelcomeScreen();
        assertEquals(
                "Добро пожаловать!",
                text_title_welcome_page
        );
    }
}
