package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

 public class AccountPageObject extends MainPageObject{
    private  static final String
            DOMAIN = "id:com.onlinepbx.panel:id/textview_domain",
            PROFILE = "id:com.onlinepbx.panel:id/textview_profile",
            SUPPORT_CHAT = "id:com.onlinepbx.panel:id/textview_support_chat",
            SUPPORT_CALL= "id:com.onlinepbx.panel:id/textview_support_call",
            MESSAGE_ERROR= "id:com.onlinepbx.panel:id/textview_report_error",
            BUTTON_LOGOUT = "id:com.onlinepbx.panel:id/button_logout";

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
