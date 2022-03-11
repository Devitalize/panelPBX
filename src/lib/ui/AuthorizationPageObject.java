package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class AuthorizationPageObject extends MainPageObject{
    protected static String
            AUTHORIZATION,
            REGISTRATION,
            LOGIN,
            PASSWORD;
    public AuthorizationPageObject(AppiumDriver driver){super(driver);}

    //Клик на кнопку Войти
    public void buttonLoginClick(){
        this.waitForElementAndClick(
                AUTHORIZATION,
                "Не удалось кликнуть на кнопку ВОЙТИ",
                10
        );
    }
    //Ввод в поле Email
    public void loginSendKeys(String login){
        this.waitForElementAndSendKeys(
                LOGIN,
                login,
                "Не удалось ввести логин в поле Email",
                10
        );
    }
    //Ввод в поле Password
    public void passwordSendKeys(String password){
        this.waitForElementAndSendKeys(
                PASSWORD,
                password,
                "Не удалось ввести пароль в поле password",
                10
        );
    }
}
