package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LanguagePage;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

import java.util.UUID;

public class LanguageTests extends TestBase{

    @Test

    public void addNewLanguage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagePage languagePage=new LanguagePage(driver);
        languagePage.saveNewLanguage("Malayalam");
        String uuid= UUID.randomUUID().toString();
        languagePage.saveNewLanguage("Malayalam" + uuid);
    }


}
