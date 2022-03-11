package lib.ui.androidPageObject;

import io.appium.java_client.AppiumDriver;
import lib.ui.AccountPageObject;

public class AndroidAccountPageObject extends AccountPageObject {
    static {
        DOMAIN = "id:com.onlinepbx.panel:id/textview_domain";
        PROFILE = "id:com.onlinepbx.panel:id/textview_profile";
        SUPPORT_CHAT = "id:com.onlinepbx.panel:id/textview_support_chat";
        SUPPORT_CALL= "id:com.onlinepbx.panel:id/textview_support_call";
        MESSAGE_ERROR= "id:com.onlinepbx.panel:id/textview_report_error";
        BUTTON_LOGOUT = "id:com.onlinepbx.panel:id/button_logout";
    }
    public AndroidAccountPageObject(AppiumDriver driver){super(driver);}

}
