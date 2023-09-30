package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LanguagePage extends PageBase {

    WebDriver driver;

    private final String idLngAddBtn = ".oxd-button--secondary";

    private final String idLngTxtName ="div[class='oxd-form-row'] input[class*='oxd-input']";

    private final String idLngSaveBtn = "//button[@type='submit']";

    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";

    private final String getIdLngCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";

    private final String tblLanguage = ".oxd-table-body";

    private final String languages = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";

    @FindBy(xpath = languages)
    private List<WebElement> listLanguages;

    public LanguagePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void saveNewLanguage(String languageName) {
        click(By.cssSelector(idLngAddBtn));
        setText(By.cssSelector(idLngTxtName), languageName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdLngCancelBtn));
        } else {
            click(By.xpath(idLngSaveBtn));
        }
        isElementVisible(By.cssSelector(tblLanguage));

        for (WebElement Language : listLanguages) {
            String txtLanguage = Language.getText();
            System.out.println(txtLanguage);

        }
        Boolean match = listLanguages.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(languageName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(languageName + " is added successfully");
        System.out.println("\n");
    }
}
