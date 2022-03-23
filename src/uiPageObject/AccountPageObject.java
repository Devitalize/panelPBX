package uiPageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import java.util.Date;

public class AccountPageObject extends MainPageObject {
    private static final String
            DOMAIN = "id:com.onlinepbx.panel:id/textview_domain",
            PROFILE = "id:com.onlinepbx.panel:id/textview_profile",
            SUPPORT_CHAT = "id:com.onlinepbx.panel:id/textview_support_chat",
            SUPPORT_CALL = "id:com.onlinepbx.panel:id/textview_support_call",
            MESSAGE_ERROR = "id:com.onlinepbx.panel:id/textview_report_error",
            BUTTON_LOGOUT = "id:com.onlinepbx.panel:id/button_logout",
            NAME = "id:com.onlinepbx.panel:id/linearlayout_name",
            NUMBER = "id:com.onlinepbx.panel:id/linearlayout_phone",
            EMAIL = "id:com.onlinepbx.panel:id/linearlayout_email",
            PASSWORD = "id:com.onlinepbx.panel:id/linearlayout_password",
            TIME_ZONE = "id:com.onlinepbx.panel:id/imageview_timezone",
            SWITCH_IP_SECURE = "id:com.onlinepbx.panel:id/switch_ip_secure",
            ACCOUNT_TEXT = "id:com.onlinepbx.panel:id/textview_account",
            NAME_TEXT = "id:com.onlinepbx.panel:id/textview_name",
            PHONE_TEXT = "id:com.onlinepbx.panel:id/textview_phone",
            EMAIL_TEXT = "id:com.onlinepbx.panel:id/textview_email",
            PASSWORD_TEXT = "id:com.onlinepbx.panel:id/textview_password",
            BUTTON_GOOGLE = "id:com.onlinepbx.panel:id/button_google",
            BUTTON_BACK = "id:com.onlinepbx.panel:id/imageview_back",
            EDIT_PROFILE_INPUT = "id:com.onlinepbx.panel:id/edittext",
            BUTTON_APPLY = "id:com.onlinepbx.panel:id/imageview_apply";

    public AccountPageObject(AppiumDriver driver) {
        super(driver);
    }

    //Ожидание появления названия домена
    public WebElement waitForTextDomain() {
        return this.waitForElementPresent(
                DOMAIN,
                "Не найдено поле с названием домена",
                15
        );
    }

    //Возвращает текст домена
    public String getDomainText() {
        WebElement domain_text = waitForTextDomain();
        return domain_text.getAttribute("text");
    }

    //Переход в профиль
    public void profileClick() {
        this.waitForElementAndClick(
                PROFILE,
                "Не удалось кликнуть на раздел Профиль",
                10
        );
    }

    //Клик в поле Имя
    public void nameClick() {
        this.waitForElementAndClick(
                NAME,
                "Не удалось кликнуть в поле имени",
                10
        );
    }

    //Создание уникального имени в виде текущей даты
    public String nameFromDate(){
        Date date = new Date();
        String str_date = String.valueOf(date);
        return str_date;
    }

    //Клик в поле Номер
    public void numberClick() {
        this.waitForElementAndClick(
                NUMBER,
                "Не удалось кликнуть в поле номера",
                10
        );
    }

    //Приводит номер телефона к числовому формату и возвращает результат -1
    public String getNewPhone(){
        String old_phone = getPhoneText();
        long old_phone_int = Long.parseLong(old_phone);
        long new_phone_int = old_phone_int - 1;
        String new_phone = String.valueOf(new_phone_int);
        return new_phone;
    }

    //Клик в поле Email
    public void emailClick() {
        this.waitForElementAndClick(
                EMAIL,
                "Не удалось кликнуть в поле почты",
                10
        );
    }

    //Клик в поле Пароль
    public void passwordClick() {
        this.waitForElementAndClick(
                PASSWORD,
                "Не удалось кликнуть в поле пароля",
                10
        );
    }

    //Клик в поле Часовой пояс
    public void timeZoneClick() {
        this.waitForElementAndClick(
                TIME_ZONE,
                "Не удалось кликнуть в поле часового пояса",
                10
        );
    }

    //Клик на переключатель Защиты по IP
    public void ipSecureClick() {
        this.waitForElementAndClick(
                SWITCH_IP_SECURE,
                "Не удалось кликнуть на переключатель защиты по IP ",
                10
        );
    }

    //Редактирование данных в профиле (НАЗВАНИЕ ИНПУТА ДЛЯ ВСЕХ ПОЛЕЙ ОДНО)
    public void editProfileSendKeys(String new_text) {
        this.waitForElementAndClear(
                EDIT_PROFILE_INPUT,
                "Не удалось очистить поле",
                10
        );
        this.waitForElementAndSendKeys(
                EDIT_PROFILE_INPUT,
                new_text,
                "Не удалось ввести текст",
                10
        );
    }

    //Клик на кнопку Назад
    public void buttonBackClick() {
        this.waitForElementAndClick(
                BUTTON_BACK,
                "Не удалось нажать на кнопку Назад",
                10
        );
    }

    //Клик на кнопку сохранения изменений
    public void buttonApplyClick() {
        this.waitForElementAndClick(
                BUTTON_APPLY,
                "Не удалось нажать на кнопку сохранения изменений",
                10
        );
    }

    //Возвращает текст имени
    public String getNameText() {
        WebElement name_text = this.waitForElementPresent(
                NAME_TEXT,
                "Не найдено имя",
                15
        );
        return name_text.getAttribute("text");
    }

    //возвращает текст телефона
    public String getPhoneText() {
        WebElement phone_text = this.waitForElementPresent(
                PHONE_TEXT,
                "Не найден телефон",
                15
        );
        return phone_text.getAttribute("text");
    }

    //Возвращает текст почты
    public String getEmailText() {
        WebElement email_text = this.waitForElementPresent(
                EMAIL_TEXT,
                "Не найдена почта",
                15
        );
        return email_text.getAttribute("text");
    }

    //Проверка соответствия почты, имени и телефона, указанных при регистрации
    public void assertNamePhoneEmail(String name, String phone, String email) {
        Assert.assertEquals(
                name,
                getNameText()
        );
        Assert.assertEquals(
                phone,
                getPhoneText()
        );
        Assert.assertEquals(
                email,
                getEmailText()
        );
    }

}
