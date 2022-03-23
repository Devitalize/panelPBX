package uiPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObject extends MainPageObject {
    private static final String
            EMAIL = "id:com.onlinepbx.panel:id/inputtext_email",
            PASSWORD = "id:com.onlinepbx.panel:id/inputtext_password",
            CONTINUE = "id:com.onlinepbx.panel:id/button_continue",
            TITLE_TEXT = "id:com.onlinepbx.panel:id/textview_title",
            ERROR_MESSAGE = "id:com.onlinepbx.panel:id/textinput_error",
            ERROR_NOT_CONNECTION = "id:com.onlinepbx.panel:id/alertTitle",
            EYE_BUTTON = "id:com.onlinepbx.panel:id/text_input_end_icon",
            BUTTON_X = "id:com.onlinepbx.panel:id/imageview_close",
            CONTINUE_WITH_GOOGLE = "id:com.onlinepbx.panel:id/button_google",
            OFFER = "id:com.onlinepbx.panel:id/textview_offer",
            NAME = "id:com.onlinepbx.panel:id/inputtext_name",
            PHONE = "id:com.onlinepbx.panel:id/inputtext_phone",
            PROMOCODE_BUTTON = "id:com.onlinepbx.panel:id/linearlayout_promo",
            PROMOCODE_INPUT = "id:com.onlinepbx.panel:id/inputtext_promo",
            CREATE_ACCOUNT_BUTTON = "id:com.onlinepbx.panel:id/button_create_account",
            SIGNUP_WITHOUT_PROMOCODE = "id:com.onlinepbx.panel:id/button_signup_without_promocode",
            BUTTON_BACK = "id:com.onlinepbx.panel:id/imageview_back";


    public RegistrationPageObject(AppiumDriver driver) {
        super(driver);
    }

    //Ввод в поле Email
    public void emailSendKeys(String email) {
        this.waitForElementAndSendKeys(
                EMAIL,
                email,
                "Не удалось ввести почту в поле Email",
                10
        );
    }

    //Возвращает текст из поля почты
    public String getEmailText() {
        WebElement email_text = this.waitForElementPresent(
                EMAIL,
                "Не найден текст поля почты",
                15
        );
        return email_text.getAttribute("text");
    }

    //Возвращает текст из поля пароля
    public String getPasswordText() {
        WebElement password_text = this.waitForElementPresent(
                PASSWORD,
                "Не найден текст поля пароля",
                15
        );
        return password_text.getAttribute("text");
    }

    //Клик на иконку глазика
    public void buttonEyeClick(){
        this.waitForElementAndClick(
                EYE_BUTTON,
                "Не удалось кликнуть по кнопку отображения пароля",
                10
        );
    }

    //Создание уникальной почты
    public String generatorEmail() {
        long timestamp = System.currentTimeMillis();
        String strTimestamp = String.valueOf(timestamp) + "@" + "8autotestpbx8.com";
        return strTimestamp;
    }

    //Ввод в поле пароля
    public void passwordSendKeys(String password) {
        this.waitForElementAndSendKeys(
                PASSWORD,
                password,
                "Не удалось ввести почту в поле пароля",
                10
        );
    }

    //Клик на кнопку ПРОДОЛЖИТЬ
    public void continueClick() {
        this.waitForElementAndClick(
                CONTINUE,
                "Не удалось нажать на кнопку ПРОДОЛЖИТЬ",
                10
        );
    }

    //Возвращает текст ошибки
    public String getTextError() {
        WebElement error_text = this.waitForElementPresent(
                ERROR_MESSAGE,
                "Не найдено поле с ошибкой",
                15
        );
        return error_text.getAttribute("text");
    }

    //Возвращает заголовок модального окна
    public String getTitleError() {
        WebElement title_error = this.waitForElementPresent(
                ERROR_NOT_CONNECTION,
                "Не найден заголовок модального окна при отсутствии интернета",
                10
        );
        return title_error.getAttribute("text");
    }

    //Клик на кнопку крестика
    public void buttonXclick() {
        this.waitForElementAndClick(
                BUTTON_X,
                "Не удалось кликнуть на кнопку крестика",
                10
        );
    }

    //Клик на кнопку Назад
    public void buttonBackClick() {
        this.waitForElementAndClick(
                BUTTON_BACK,
                "Не удалось кликнуть на кнопку назад",
                10
        );
    }

    //Возвращает заголовок экрана Новой аккаунт
    public String getTitleText() {
        WebElement title_text = this.waitForElementPresent(
                TITLE_TEXT,
                "Не найден заголовок Новый аккаунт",
                15
        );
        return title_text.getAttribute("text");
    }

    //Заполнение полей для перехода на экран ввода имени и телефона
    public String emailAndPasswordSendKeysAndContinue() {
        String random_email = generatorEmail();
        emailSendKeys(random_email);
        passwordSendKeys("test888TEST");
        continueClick();
        return random_email;
    }

    //Ввод в поле имени
    public void nameSendKeys(String name) {
        this.waitForElementAndSendKeys(
                NAME,
                name,
                "Не удалось ввести имя",
                10
        );
    }

    //Ввод в поле телефона
    public void phoneSendKeys(String phone) {
        this.waitForElementAndSendKeys(
                PHONE,
                phone,
                "Не удалось ввести телефон",
                10
        );
    }

    //Возвращает введённый текст из поля телефона
    public String getPhoneText() {
        WebElement text_phone = this.waitForElementPresent(
                PHONE,
                "Не найдено поле номера телефона",
                10
        );
        return text_phone.getAttribute("text");
    }

    //Клик по кнопку промокода
    public void promocodeButtonClick() {
        this.waitForElementAndClick(
                PROMOCODE_BUTTON,
                "Не удалось кликнуть на кнопку промокода",
                10
        );
    }

    //Ввод промокода
    public void promocodeSendKeys(String promocode) {
        this.waitForElementAndSendKeys(
                PROMOCODE_INPUT,
                promocode,
                "Не удалось ввести промокод",
                10
        );
        ((AndroidDriver) driver).hideKeyboard();
    }

    //Клик на СОЗДАТЬ АККАУНТ
    public void createAccountClick() {
        this.waitForElementAndClick(
                CREATE_ACCOUNT_BUTTON,
                "Не удалось кликнуть на СОЗДАТЬ АККАУНТ",
                10
        );
    }

    //Клик на кнопку создания без промокода
    public void signupWithoutPromocodeClick() {
        this.waitForElementAndClick(
                SIGNUP_WITHOUT_PROMOCODE,
                "Не удалось кликнуть на кнопку СОЗДАТЬ БЕЗ ПРОМОКОДА",
                10
        );
    }

}
