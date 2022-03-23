package uiPageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.time.Duration;

public class SystemSettingsPageObject extends MainPageObject{
    private  static final String
            SYSTEM_SETTING = "xpath://android.widget.TextView[@content-desc=\"Settings\"]",
    NETWORK = "xpath://android.widget.TextView[@text='Network & internet']",
    AIRPLANE_MODE = "id:android:id/switch_widget";

    public SystemSettingsPageObject(AppiumDriver driver) {
        super(driver);}

     //Клик на кнопку HOME для сворачивания
     public void buttonHomeClick(){((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);

     }
    //Включение режима полёта
    public void switchingAirplaneMode(){
       // buttonHomeClick();
        driver.runAppInBackground(Duration.ofSeconds(15));
        this.waitForElementAndClick(SYSTEM_SETTING,
                "Не удалось кликнуть на иконку Настройки",
        10);
        this.waitForElementAndClick(
                NETWORK,
                "Не удалось кликнуть в поле Network & internet",
                10
        );
        this.waitForElementAndClick(
                AIRPLANE_MODE,
                "Не удалось кликнуть на переключатель режима полёта",
                10
        );
       // driver.resetApp();
        driver.runAppInBackground(Duration.ofSeconds(5));
    }
}
