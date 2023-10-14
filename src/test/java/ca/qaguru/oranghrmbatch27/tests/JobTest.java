package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.JobPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

    public class JobTest extends TestBase {
        @Test(priority = 1)
        public void addnewjobtitle(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123", true, null);
            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.selectMenu(MenuOptions.JOB_TITLES);
            JobPage jobpage = new JobPage(driver);
            jobpage.savenewjob("Civil Engineer_salin");


        }
        @Test(priority = 2)
        public void DuplicateJobtitle(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123", true, null);
            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.selectMenu(MenuOptions.JOB_TITLES);
            JobPage jobpage = new JobPage(driver);
            jobpage.duplicateJobTitle("Civil Engineer_salin");

        }
        @Test(priority = 3)
        public void editJobTitle(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123", true, null);
            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.selectMenu(MenuOptions.JOB_TITLES);
            JobPage jobpage = new JobPage(driver);
            jobpage.editJobTitle("123");

        }

        @Test(priority = 4)
        public void deleteJobTitle(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123", true, null);
            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.selectMenu(MenuOptions.JOB_TITLES);
            JobPage jobpage = new JobPage(driver);
            jobpage.deleteJobTitle("Civil Engineer");


        }
        @Test(priority = 5)
        public void ValidateJobTitle() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123", true, null);
            HeaderPage headerPage = new HeaderPage(driver);
            headerPage.selectMenu(MenuOptions.JOB_TITLES);
            JobPage jobpage = new JobPage(driver);
            jobpage.jobValidation("");
        }

    }


