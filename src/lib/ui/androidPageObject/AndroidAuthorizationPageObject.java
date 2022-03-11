package lib.ui.androidPageObject;

import io.appium.java_client.AppiumDriver;
import lib.ui.AuthorizationPageObject;

public class AndroidAuthorizationPageObject extends AuthorizationPageObject {
    static {
       AUTHORIZATION = "id:com.onlinepbx.panel:id/button_login";
        REGISTRATION = "id:com.onlinepbx.panel:id/button_signup";
        LOGIN = "id:com.onlinepbx.panel:id/inputtext_email";
        PASSWORD = "id:com.onlinepbx.panel:id/inputtext_password";

    }
    public  AndroidAuthorizationPageObject(AppiumDriver driver){ super(driver);}
}
