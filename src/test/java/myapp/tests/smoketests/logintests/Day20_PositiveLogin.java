package myapp.tests.smoketests.logintests;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day20_PositiveLogin {

        @Test
        public void US100201_Admin_Login(){
//    As admin, I should be able to log in the application
            RentalHomePage rentalHomePage = new RentalHomePage();
            RentalLoginPage rentalLoginPage = new RentalLoginPage();

            Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
            rentalHomePage.loginLink.click();

//    Admin email: jack@gmail.com
            rentalLoginPage.userEmail.sendKeys("jack@gmail.com");

//    Admin password: 12345
            rentalLoginPage.userPassword.sendKeys("12345");
            rentalLoginPage.loginButton.click();

            ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);

            Driver.closeDriver();
        }


}
