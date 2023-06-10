package myapp.tests.reportstests;

import myapp.pages.OrangeHRMDashboardPage;
import myapp.pages.OrangeHRMLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day25_ExtentReports {

    @Test
    public void extentReportsTest() throws IOException {

        ExtentReportUtils.info("Starting test ...");
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        OrangeHRMDashboardPage orangeHRMDashboardPage = new OrangeHRMDashboardPage();
//        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Driver.getDriver().get(ConfigReader.getProperty("orange_app_url"));
        ExtentReportUtils.pass("Going to Homepage: " + ConfigReader.getProperty("orange_app_url"));

        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("On the homepage");

        orangeHRMLoginPage.username.sendKeys("Admin");
        ExtentReportUtils.pass("Entered the username");

        orangeHRMLoginPage.password.sendKeys("admin123");
        ExtentReportUtils.pass("Entered the password");

        orangeHRMLoginPage.login.click();
        ExtentReportUtils.pass("Clicked on (login)submit button");

//      Verify the login is successful
        Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());
        ExtentReportUtils.pass("Verified the login");

        ExtentReportUtils.passAndCaptureScreenshot("Signed in the app");

//        Close the driver
        Driver.closeDriver();
        ExtentReportUtils.pass("Test completed!");

        ExtentReportUtils.flush();//To generate the report...

    }
}