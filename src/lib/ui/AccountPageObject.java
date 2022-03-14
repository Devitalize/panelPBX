package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

abstract public class AccountPageObject extends MainPageObject{
    protected static String
    DOMAIN,
    PROFILE,
    SUPPORT_CHAT,
    SUPPORT_CALL,
    MESSAGE_ERROR,
    BUTTON_LOGOUT;

    public AccountPageObject(AppiumDriver driver){super(driver);}

    //Ожидание появления названия домена
    public WebElement waitForTextDomain(){
        return this.waitForElementPresent(
                DOMAIN,
                "Не найдено поле с названием домена",
                15
                );
    }
    //Возвращает текст домена
    public String getDomainText(){
        WebElement domain_text = waitForTextDomain();
        return domain_text.getAttribute("text");
    }
}
