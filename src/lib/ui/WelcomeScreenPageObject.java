package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

 public class WelcomeScreenPageObject extends MainPageObject{
    private  static final String
            TITLE = "id:com.onlinepbx.panel:id/textview_title",
    LOGIN = "id:com.onlinepbx.panel:id/button_login",
    REGISTER = "id:com.onlinepbx.panel:id/button_signup";
    public WelcomeScreenPageObject(AppiumDriver driver){super(driver);}

    //Возвращает заголовок приветственного экрана
    public String getTitleWelcomeScreen(){
        WebElement title_welcome_screen = this.waitForElementPresent(
                TITLE,
                "",
                10
        );
        return title_welcome_screen.getAttribute("text");
    }
}
