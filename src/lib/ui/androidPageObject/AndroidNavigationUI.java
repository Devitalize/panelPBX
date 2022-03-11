package lib.ui.androidPageObject;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {
    static {
        CALLS = "id:com.onlinepbx.panel:id/nav_graph_calls";
        STATISTIC = "id:com.onlinepbx.panel:id/nav_graph_statistic";
        BILLING = "id:com.onlinepbx.panel:id/nav_graph_payment";
        ACCOUNT = "id:com.onlinepbx.panel:id/nav_graph_account";
    }
    public AndroidNavigationUI(AppiumDriver driver){super(driver);}
}
