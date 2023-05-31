package myapp.tests.smoketests.logintests;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day20_Bad_Credentials {

    @Test
    public void US103208_Bad_Credentials(){

        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));

        rentalHomePage.loginLink.click();
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");//Correct email
        rentalLoginPage.userPassword.sendKeys("fakepass");//Incorrect password
        rentalLoginPage.loginButton.click();

        ReusableMethods.verifyExpectedAndActualTextsMatch("Bad credentials",rentalLoginPage.errorMessage_incorrectEmailAndPassword);
        Driver.closeDriver();
    }

}
