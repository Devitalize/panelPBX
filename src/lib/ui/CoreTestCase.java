package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;;import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability("platformName", "Android");
        capabilites.setCapability("deviceName", "AND11");
        capabilites.setCapability("platformVersion", "11.0");
        capabilites.setCapability("automationName", "Appium");
        capabilites.setCapability("appPackage", "com.onlinepbx.panel");
        capabilites.setCapability("appActivity", ".ui.EntranceActivity");
        capabilites.setCapability("app", "C:/Users/pbx5/IdeaProjects/panelAndroid/panelPBX/apks/app-debug-65-dev.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilites);
    }

    @Override
    protected void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }
}
