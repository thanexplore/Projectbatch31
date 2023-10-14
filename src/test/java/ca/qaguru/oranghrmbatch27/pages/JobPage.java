package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

    public class JobPage extends PageBase {
        WebDriver driver;
        private final String jobAddBtn = "button.oxd-button.oxd-button--medium.oxd-button--secondary";
        private final String jobtitleinpt = "input.oxd-input.oxd-input--active";
        private final String jobSaveBtn = "//button[@type='submit']";
        private final String jobAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
        private final String jobEditBtn = "(//button[contains(@class, 'oxd-icon-button') and contains(@class, 'oxd-table-cell-action-space') and .//i[contains(@class, 'oxd-icon') and contains(@class, 'bi-pencil-fill')]])[5]";
        private final String jobbtn = "//span[@class='oxd-topbar-body-nav-tab-item'and text()='Job']";
        private final String jobCancelbtn = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']";
        private final String tblJob = ".oxd-table-body";
        private final String jobDeleteBtn ="(//i[contains(@class, 'oxd-icon bi-trash')])[5]";
        private final String jobs = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
        private final String jobErrorMsg= "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
        private final String jobDelConfBtn ="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";

        @FindBy(xpath = jobs)
        private List<WebElement> listjob;

        public JobPage(WebDriver driver) {
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }


        public void savenewjob(String jobtitle) {
            click(By.cssSelector(jobAddBtn));
            setText(By.cssSelector(jobtitleinpt), jobtitle);
            if (getText(By.xpath(jobAlreadyExistsMessage)).contains("Already exists")) {
                click(By.xpath(jobCancelbtn));
            } else {
                click(By.xpath(jobSaveBtn));
            }
            isElementVisible(By.cssSelector(tblJob));

            for (WebElement Job : listjob) {
                String txtJob = Job.getText();
                System.out.println(txtJob);
            }

            System.out.println("\n");
            System.out.println( jobtitle + " is added successfully");
            System.out.println("\n");
        }
        public void editJobTitle(String Jobtitle){
            click(By.xpath(jobEditBtn));
            WebElement jobTitleInput = new WebDriverWait(driver, Duration.ofSeconds(500))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(jobtitleinpt)));
            jobTitleInput.clear();
            String JobTitle = jobTitleInput.getText();
            System.out.println("clear text" +JobTitle );
            jobTitleInput.sendKeys(Jobtitle);
            System.out.println("Jobtitle"+Jobtitle);
            setText(By.cssSelector(jobtitleinpt), Jobtitle);
            if (getText(By.xpath(jobAlreadyExistsMessage)).contains("Already exists")) {
                click(By.xpath(jobCancelbtn));
            } else {
                click(By.xpath(jobSaveBtn));
            }
            isElementVisible(By.cssSelector(tblJob));

            for (WebElement Job : listjob) {
                String txtJob = Job.getText();
                System.out.println(txtJob);
            }

            System.out.println("\n");
            System.out.println( Jobtitle + " is edited successfully");
            System.out.println("\n");
        }
        public void deleteJobTitle(String Jobtitle){
            click(By.xpath(jobDeleteBtn));
            click(By.xpath(jobDelConfBtn));
            isElementVisible(By.cssSelector(tblJob));

            for (WebElement Job : listjob) {
                String txtJob = Job.getText();
                System.out.println(txtJob);
            }

            System.out.println("\n");
            System.out.println( Jobtitle + " is deleted successfully");
            System.out.println("\n");




        }
        public void duplicateJobTitle(String Jobtitle){
            click(By.cssSelector(jobAddBtn));
            setText(By.cssSelector(jobtitleinpt), Jobtitle);
            getText(By.xpath(jobAlreadyExistsMessage)).contains("Already exists"); {
                click(By.xpath(jobCancelbtn));
            }
            for (WebElement Job : listjob) {
                String txtJob = Job.getText();
                System.out.println(txtJob);
            }

            System.out.println("\n");
            System.out.println( Jobtitle + " is Already Exist");
            System.out.println("\n");

        }
        public void jobValidation(String jobtitle) {
            click(By.cssSelector(jobAddBtn));
            click(By.xpath(jobSaveBtn));

            if (getText(By.xpath(jobErrorMsg)).contains("Required"))


                isElementVisible(By.cssSelector(tblJob));


            for (WebElement Job : listjob) {

            }

            System.out.println("\n");
            System.out.println("Validation is successfull");
            System.out.println("\n");
        }
    }



