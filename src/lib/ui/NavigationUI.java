package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{
    protected static String
    CALLS,
    STATISTIC,
    BILLING,
    ACCOUNT;

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
