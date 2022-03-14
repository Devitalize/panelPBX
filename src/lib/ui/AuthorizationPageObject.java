package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

 public class AuthorizationPageObject extends MainPageObject {
   private  static final String
         AUTHORIZATION = "id:com.onlinepbx.panel:id/button_login",
         REGISTRATION = "id:com.onlinepbx.panel:id/button_signup",
         LOGIN = "id:com.onlinepbx.panel:id/inputtext_email",
         PASSWORD = "id:com.onlinepbx.panel:id/inputtext_password",
         TEXT_ERROR = "id:com.onlinepbx.panel:id/textinput_error",
     TITLE = "id:com.onlinepbx.panel:id/textview_title",
         ERROR_NOT_CONNECTION = "id:com.onlinepbx.panel:id/alertTitle",
         BUTTON_X = "id:com.onlinepbx.panel:id/button_close",
           PASSWORD_RECOVERY_BUTTON = "id:com.onlinepbx.panel:id/textview_forgot_password";


    public AuthorizationPageObject(AppiumDriver driver) {
        super(driver);
    }

    //Клик на кнопку Войти
    public void buttonLoginClick() {
        this.waitForElementAndClick(
                AUTHORIZATION,
                "Не удалось кликнуть на кнопку ВОЙТИ",
                10
        );
    }

    //Ввод в поле Email
    public void loginSendKeys(String login) {
        this.waitForElementAndSendKeys(
                LOGIN,
                login,
                "Не удалось ввести логин в поле Email",
                10
        );
    }

    //Ввод в поле Password
    public void passwordSendKeys(String password) {
        this.waitForElementAndSendKeys(
                PASSWORD,
                password,
                "Не удалось ввести пароль в поле password",
                10
        );
    }

    //Возвращает текст ошибки
    public String getTextError() {
        WebElement error_text = this.waitForElementPresent(
                TEXT_ERROR,
                "Не найдено поле с ошибкой",
                15
        );
        return error_text.getAttribute("text");
    }

    //Ожидание появления модального окна с сообщением об отсутствии интернета
    public WebElement waitForErrorNotConnection(){
        return this.waitForElementPresent(
                ERROR_NOT_CONNECTION,
                "Не найден заголовок модального окна при отсутствии интернета",
                10
        );
    }

    //Возвращает заголовок модального окна
    public String getTitleError(){
        WebElement title_error = waitForErrorNotConnection();
        return title_error.getAttribute("text");
    }

    //Клин на крестик для возвращения на приветственный экран
     public void buttonXclick(){
        this.waitForElementAndClick(
                BUTTON_X,
                "Не удалось кликнуть на кнопку крестика",
                10
        );
     }

     //Клик на кнопку восстановления пароля
     public void passwordRecoveryClick(){
        this.waitForElementAndClick(
                PASSWORD_RECOVERY_BUTTON,
                "Не удалось кликнуть на кнопку восстановления пароля",
                10
        );
     }
     //Возвращает текст ошибки
     public String getTitleText() {
         WebElement title_text = this.waitForElementPresent(
                 TITLE,
                 "Не найден заголовок Вход",
                 15
         );
         return title_text.getAttribute("text");
     }
}