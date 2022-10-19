package uiPageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ATSPageObject extends MainPageObject {
    private static final String
            ADD_MODULE = "id:imageview_add",
            ADD_NUMBER = "id:linearlayout_number",
            NUMBER_NAME = "id:edittext_name",
            NUMBER_DISPLAY_NAME = "id:edittext_display_name",
            NUMBER_OPERATOR = "id:textview_operator",
            NUMBER_NUMBER = "id:edittext_number",
            NUMBER_LOGIN = "id:edittext_login",
            NUMBER_PASSWORD = "id:edittext_password",
            NUMBER_TOGGLE_PASSWORD = "id:imageview_toggle_password",
            NUMBER_SERVER = "id:edittext_address",
            NUMBER_PROXY = "id:edittext_proxy",
            NUMBER_REDIRECT = "id:edittext_redirect",
            NUMBER_SWITCH_REDIRECT = "id:switch_redirect",
            NUMBER_BUTTON_ADD = "id:button_apply",
            NUMBER_VOX_URL = "id:textview_vox",
            NUMBER_BMI_URL = "id:textview_bmi",
            NUMBER_TITLE_ERROR = "xpath://*[@text='Заполните обязательные поля']",
            NUMBER_ERROR_CLOSE = "xpath://*[@text='ЗАКРЫТЬ']",
            ADD_USER = "",
            ADD_IVR = "";

    public ATSPageObject(AppiumDriver driver) {
        super(driver);
    }


    //Клик по кнопке добавления нового модуля
    public void clickAddModule() {
        this.waitForElementAndClick(
                ADD_MODULE,
                "Не удалось кликнуть на кнопку добавления нового модуля",
                10
        );
    }

    //Клик в поле добавления нового номера
    public void clickAddNumber() {
        this.waitForElementAndClick(
                ADD_NUMBER,
                "",
                10
        );
    }

    //Редактирование названия номера
    public void editNumberName(String new_name) {
        this.waitForElementAndClear(
                NUMBER_NAME,
                "Не удалось очистить поле названия",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_NAME,
                new_name,
                "Не удалось ввести текст названия",
                10
        );
    }

    //Редактирование отображаемого имени номера
    public void editNumberDisplayName(String new_name) {
        this.waitForElementAndClear(
                NUMBER_DISPLAY_NAME,
                "Не удалось очистить поле отображаемого имени",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_DISPLAY_NAME,
                new_name,
                "Не удалось ввести текст отображаемого имени",
                10
        );
    }

    //Редактирование оператора связи у номера


    //Редактирование номера транка
    public void editNumberNumber(String new_number) {
        this.waitForElementAndClear(
                NUMBER_NUMBER,
                "Не удалось очистить поле номера",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_NUMBER,
                new_number,
                "Не удалось ввести текст номера",
                10
        );
    }

    //Редактирование логина номера
    public void editNumberLogin(String new_login) {
        this.waitForElementAndClear(
                NUMBER_LOGIN,
                "Не удалось очистить поле логина",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_LOGIN,
                new_login,
                "Не удалось ввести текст логина",
                10
        );
    }

    //Редактирование пароля номера
    public void editNumberPassword(String new_password) {
        this.waitForElementAndSendKeys(
                NUMBER_PASSWORD,
                new_password,
                "Не удалось ввести текст пароля",
                10
        );
    }

    //Редактирование адреса сервера номера
    public void editNumberServer(String new_server) {
        this.waitForElementAndClear(
                NUMBER_SERVER,
                "Не удалось очистить поле сервера",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_SERVER,
                new_server,
                "Не удалось ввести текст сервера",
                10
        );
    }

    //Редактирование сип-прокси номера
    public void editNumberSipProxy(String new_sip_proxy) {
        this.waitForElementAndClear(
                NUMBER_PROXY,
                "Не удалось очистить поле sip-proxy",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_PROXY,
                new_sip_proxy,
                "Не удалось ввести текст sip-proxy",
                10
        );
    }

    //Редактирование поля Перенаправить на у номера
    public void editNumberRedirect(String new_redirect) {
        this.swipeUpToFindElement(
                NUMBER_REDIRECT,
                "Не удалось найти поле Перенаправить на",
                3,
                0.6,
                0.2
        );
        this.waitForElementAndClear(
                NUMBER_REDIRECT,
                "Не удалось очистить поле Перенаправить на",
                10
        );
        this.waitForElementAndSendKeys(
                NUMBER_REDIRECT,
                new_redirect,
                "Не удалось ввести текст в поле Перенаправить на",
                10
        );
    }

    //Переключение переадресации через этот номер

    //Клик на сохранение модуля номера
    public void clickButtonSaveNumber() {
        this.waitForElementAndClick(
                NUMBER_BUTTON_ADD,
                "Не удалось кликнуть на кнопку сохранения номера",
                10
        );
    }

    //Ожидание появления модального окна с сообщением о пустых обязательных полях
    public WebElement waitForErrorEmptyRequiredData(){
        return this.waitForElementPresent(
                NUMBER_TITLE_ERROR,
                "Не найден заголовок модального окна при пустых обязательных полях",
                10
        );
    }

    //Закрытие модального окна о пустых обязательеых полях
    public void clickButtonCloseError(){
        waitForErrorEmptyRequiredData();
        this.waitForElementAndClick(
                NUMBER_ERROR_CLOSE,
                "Не удалось нажать на кнопку закрытия модалки",
                10
        );
    }

}
