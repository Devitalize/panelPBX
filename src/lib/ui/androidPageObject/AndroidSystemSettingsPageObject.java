package lib.ui.androidPageObject;

import io.appium.java_client.AppiumDriver;
import lib.ui.SystemSettingsPageObject;

public class AndroidSystemSettingsPageObject extends SystemSettingsPageObject {
    static {
        SYSTEM_SETTING = "xpath://android.widget.TextView[@content-desc=\"Settings\"]";
        NETWORK = "xpath://android.widget.TextView[@text='Network & internet']";
        AIRPLANE_MODE = "id:android:id/switch_widget";


    }
    public AndroidSystemSettingsPageObject(AppiumDriver driver){super(driver);}
}
