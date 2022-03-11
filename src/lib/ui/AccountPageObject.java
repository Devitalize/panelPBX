package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class AccountPageObject extends MainPageObject{
    protected static String
    DOMAIN,
    PROFILE,
    SUPPORT_CHAT,
    SUPPORT_CALL,
    MESSAGE_ERROR,
    BUTTON_LOGOUT;

    public AccountPageObject(AppiumDriver driver){super(driver);}
}
