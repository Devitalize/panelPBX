package tests;

import org.junit.Assert;
import org.junit.Test;
import uiPageObject.ATSPageObject;
import uiPageObject.AuthorizationPageObject;
import uiPageObject.CoreTestCase;
import uiPageObject.NavigationUI;

public class ATSTest extends CoreTestCase {
    String name = "new name number";
    String display_name = "Новое отображаемое имя номера";
    String number = "987654321";
    String login = "login";
    String password = "test8TEST";
    String server = "404test";
    String sip_proxy = "proxy";
    String number_redirect = "12345";


    //Успешное добавление транка с валидными данными !!!ДОРАБОТАТЬ
    @Test
    public void testSuccessfulAddNumberWithValidField() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName(name);
        ATSPageObject.editNumberDisplayName(display_name);
        ATSPageObject.editNumberNumber(number);
        ATSPageObject.editNumberLogin(login);
        ATSPageObject.editNumberPassword(password);
        ATSPageObject.editNumberServer(server);
        ATSPageObject.editNumberSipProxy(sip_proxy);
        ATSPageObject.editNumberRedirect(number_redirect);
        ATSPageObject.clickButtonSaveNumber();
        System.out.println("Дописать проверку сохранения номера");
    }

    //Успешное добавление номера с максимальной длиной всех полей
    //ДОПИСАТЬ ПРОВЕРКУ СОХРАНЕНИЯ
    @Test
    public void testSuccessfulAddNumberWithMaxLengthField() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName("12345678901234567890123456789012");
        ATSPageObject.editNumberDisplayName("12345678901234567890123456789012");
        ATSPageObject.editNumberNumber("12345678901234567890123456789012");
        ATSPageObject.editNumberLogin("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");
        ATSPageObject.editNumberPassword("1234567890123456789012345678901234567890123456789012345678901234");
        ATSPageObject.editNumberServer("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");
        ATSPageObject.editNumberSipProxy("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");
        ATSPageObject.editNumberRedirect("12345678901234567890123456789012");
        ATSPageObject.clickButtonSaveNumber();
        System.out.println("Дописать проверку сохранения номера");
    }

    //Успешное добавление транка с пустыми необязательными полями
    // (название, отображаемое имя, сип-прокси, перенаправить на)
    //ДОПИСАТЬ ПРОВЕРКУ СОХРАНЕНИЯ
    @Test
    public void testSuccessfulNumberOnlyWithRequiredField(){
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberNumber(number);
        ATSPageObject.editNumberLogin(login);
        ATSPageObject.editNumberPassword(password);
        ATSPageObject.editNumberServer(server);
        ATSPageObject.clickButtonSaveNumber();
        System.out.println("Дописать проверку сохранения номера");

    }
    //Отображение ошибки при всех пустых полях при добавлении
    //ПРИДУМАТЬ КАК ПРОВЕРИТЬ ВЫДЕЛЕНИЕ ПУСТОГО ПОЛЯ ЦВЕТОМ. ПРОБЛЕМА: СТИЛИ ПРОПИСЫВАЮТСЯ В xml
    @Test
    public void testErrorWithEmptyRequiredData(){
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.clickButtonSaveNumber();
        ATSPageObject.clickButtonCloseError();
    }

    //Отображение ошибки при пустом поле Номер
    //ПРИДУМАТЬ КАК ПРОВЕРИТЬ ВЫДЕЛЕНИЕ ПУСТОГО ПОЛЯ ЦВЕТОМ. ПРОБЛЕМА: СТИЛИ ПРОПИСЫВАЮТСЯ В xml
    @Test
    public void testErrorWithEmptyRequiredNumber(){
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName(name);
        ATSPageObject.editNumberDisplayName(display_name);
        ATSPageObject.editNumberLogin(login);
        ATSPageObject.editNumberPassword(password);
        ATSPageObject.editNumberServer(server);
        ATSPageObject.editNumberSipProxy(sip_proxy);
        ATSPageObject.editNumberRedirect(number_redirect);
        ATSPageObject.clickButtonSaveNumber();
        ATSPageObject.clickButtonCloseError();
    }
    //Отображаение ошибки при пустом поле Логина
    //ПРИДУМАТЬ КАК ПРОВЕРИТЬ ВЫДЕЛЕНИЕ ПУСТОГО ПОЛЯ ЦВЕТОМ. ПРОБЛЕМА: СТИЛИ ПРОПИСЫВАЮТСЯ В xml
    @Test
    public void testErrorWithEmptyRequiredLogin() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName(name);
        ATSPageObject.editNumberDisplayName(display_name);
        ATSPageObject.editNumberNumber(number);
        ATSPageObject.editNumberPassword(password);
        ATSPageObject.editNumberServer(server);
        ATSPageObject.editNumberSipProxy(sip_proxy);
        ATSPageObject.editNumberRedirect(number_redirect);
        ATSPageObject.clickButtonSaveNumber();
        ATSPageObject.clickButtonCloseError();
    }

    //Отображение ошибки при пустом поле пароля
    //ПРИДУМАТЬ КАК ПРОВЕРИТЬ ВЫДЕЛЕНИЕ ПУСТОГО ПОЛЯ ЦВЕТОМ. ПРОБЛЕМА: СТИЛИ ПРОПИСЫВАЮТСЯ В xml
    @Test
    public void testErrorWithEmptyRequiredPassword() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName(name);
        ATSPageObject.editNumberDisplayName(display_name);
        ATSPageObject.editNumberNumber(number);
        ATSPageObject.editNumberLogin(login);
        ATSPageObject.editNumberServer(server);
        ATSPageObject.editNumberSipProxy(sip_proxy);
        ATSPageObject.editNumberRedirect(number_redirect);
        ATSPageObject.clickButtonSaveNumber();
        ATSPageObject.clickButtonCloseError();
    }

    //Отображение ошибки при пустом поле адреса сервера
    //ПРИДУМАТЬ КАК ПРОВЕРИТЬ ВЫДЕЛЕНИЕ ПУСТОГО ПОЛЯ ЦВЕТОМ. ПРОБЛЕМА: СТИЛИ ПРОПИСЫВАЮТСЯ В xml
    @Test
    public void testErrorWithEmptyRequiredServer() {
        AuthorizationPageObject AuthorizationPageObject = new AuthorizationPageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        ATSPageObject ATSPageObject = new ATSPageObject(driver);

        AuthorizationPageObject.successfulAuthorization();
        NavigationUI.clickNavigationATS();
        ATSPageObject.clickAddModule();
        ATSPageObject.clickAddNumber();
        ATSPageObject.editNumberName(name);
        ATSPageObject.editNumberDisplayName(display_name);
        ATSPageObject.editNumberNumber(number);
        ATSPageObject.editNumberLogin(login);
        ATSPageObject.editNumberPassword(password);
        ATSPageObject.editNumberSipProxy(sip_proxy);
        ATSPageObject.editNumberRedirect(number_redirect);
        ATSPageObject.clickButtonSaveNumber();
        ATSPageObject.clickButtonCloseError();
    }


}
