package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecoveryPageObject extends MainPageObject{
    private static final String
    EMAIL = "id:com.onlinepbx.panel:id/inputtext_email",
    RECOVERY_BUTTON = "id:com.onlinepbx.panel:id/button_recover",
    TEXT_ERROR = "id:com.onlinepbx.panel:id/textinput_error",
    BUTTON_X = "id:com.onlinepbx.panel:id/imageview_close",
    DESCRIPTION_PASSWORD_RECOVERY = "id:com.onlinepbx.panel:id/textview_result",
    BUTTON_LOGIN = "id:com.onlinepbx.panel:id/button_login";

    public PasswordRecoveryPageObject(AppiumDriver driver){super(driver);}

    //Ввод почты для восстановления
    public void emailSendKeys(String email){
        this.waitForElementAndSendKeys(
                EMAIL,
                email,
                "Не удалось ввести почту в поле email",
                10
        );
    }

    //Клик на кнопку Восстановить
    public void buttonRecoveryClick(){
        this.waitForElementAndClick(
                RECOVERY_BUTTON,
                "Не удалось кликнуть на кнопку Восстановить",
                10
        );
    }

    //Возвращает заголовок об отправленном сообщении для смены пароля
    public String getDescriptionPasswordRecovery(){
        WebElement description_password_recovery = this.waitForElementPresent(
                DESCRIPTION_PASSWORD_RECOVERY,
                "",
                10
        );
        return description_password_recovery.getAttribute("text");
    }

    //Возвращает текст ошибки при вводе некорректной почты
    public String getTextErrorEmail(){
        WebElement text_error = this.waitForElementPresent(
                TEXT_ERROR,
                "Не найдено поле с ошибкой в поле почты для восстановления",
                10
        );
        return text_error.getAttribute("text");
    }

    //Клик на кнопку крестика для возврата на экран авторизации
    public void buttonXclick(){
        this.waitForElementAndClick(
                BUTTON_X,
                "Не удалось кликнуть на кнопку крестика",
                10
        );
    }

    //Клик на кнопку Войти для возврата на экран авторизации
    public void buttonLoginClick(){
        this.waitForElementAndClick(
                BUTTON_LOGIN,
                "Не удалось кликнуть на кнопку Войти",
                10
        );
    }
}
