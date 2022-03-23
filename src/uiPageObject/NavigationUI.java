package uiPageObject;

import io.appium.java_client.AppiumDriver;

 public class NavigationUI extends MainPageObject{
    private  static final String
            CALLS = "id:com.onlinepbx.panel:id/nav_graph_calls",
    STATISTIC = "id:com.onlinepbx.panel:id/nav_graph_statistic",
    BILLING = "id:com.onlinepbx.panel:id/nav_graph_payment",
    ACCOUNT = "id:com.onlinepbx.panel:id/nav_graph_account";

    public NavigationUI(AppiumDriver driver){super(driver);}
    //Клик на вкладку Звонки
    public void clickNavigationCalls(){
        this.waitForElementAndClick(
                CALLS,
                "Не удалось кликнуть на вкладку Звонки",
                10
        );
    }
    //Клик на вкладку Статистика
    public void clickNavigationStatistic() {
        this.waitForElementAndClick(
                STATISTIC,
                "Не удалось кликнуть на вкладку Статистики",
                10
        );
    }

    //Клик на вкладку Оплат
        public void clickNavigationBilling() {
            this.waitForElementAndClick(
                    BILLING,
                    "Не удалось кликнуть на вкладку Оплат",
                    10
            );
        }

    //Клик на вкладку Аккаунт
            public void clickNavigationAccount() {
                this.waitForElementAndClick(
                        ACCOUNT,
                        "Не удалось кликнуть на вкладку Аккаунт",
                        10
                );
            }
}
