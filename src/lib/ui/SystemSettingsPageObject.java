package lib.ui;

import io.appium.java_client.AppiumDriver;

 public class SystemSettingsPageObject extends MainPageObject{
    private  static final String
            SYSTEM_SETTING = "xpath://android.widget.TextView[@content-desc=\"Settings\"]",
    NETWORK = "xpath://android.widget.TextView[@text='Network & internet']",
    AIRPLANE_MODE = "id:android:id/switch_widget";

    public SystemSettingsPageObject(AppiumDriver driver) {
        super(driver);}

    //Включение режима полёта
    public void enableAirplaneMode(){
        driver.closeApp();
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
        driver.resetApp();
    }

    //Отключение режима полёта
    public void disableAirplaneMode(){
        driver.closeApp();
        this.waitForElementAndClick(
                AIRPLANE_MODE,
                "Не удалось кликнуть на переключатель режима полёта",
                10
        );
    }
}
