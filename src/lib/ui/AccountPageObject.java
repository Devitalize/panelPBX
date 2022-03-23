package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

 public class AccountPageObject extends MainPageObject{
    private  static final String
            DOMAIN = "id:com.onlinepbx.panel:id/textview_domain",
            PROFILE = "id:com.onlinepbx.panel:id/textview_profile",
            SUPPORT_CHAT = "id:com.onlinepbx.panel:id/textview_support_chat",
            SUPPORT_CALL= "id:com.onlinepbx.panel:id/textview_support_call",
            MESSAGE_ERROR= "id:com.onlinepbx.panel:id/textview_report_error",
            BUTTON_LOGOUT = "id:com.onlinepbx.panel:id/button_logout",
     ACCOUNT_TEXT = "id:com.onlinepbx.panel:id/textview_account",
     NAME_TEXT = "id:com.onlinepbx.panel:id/textview_name",
     PHONE_TEXT = "id:com.onlinepbx.panel:id/textview_phone",
     EMAIL_TEXT = "id:com.onlinepbx.panel:id/textview_email",
     PASSWORD_TEXT = "",
     TIME_ZONE = "",
     SWITCH_IP_SECURE = "",
     BUTTON_GOOGLE = "",
     BUTTON_BACK = "";

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

    //Переход в профиль
     public void profileClick(){
        this.waitForElementAndClick(
                PROFILE,
                "Не удалось кликнуть на раздел Профиль",
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
     public void assertNamePhoneEmail(String name, String phone, String email){
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
