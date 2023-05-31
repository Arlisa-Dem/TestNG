package myapp.tests.smoketests.logintests;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ReusableMethods;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day20_NegativeLogin {
    //As admin or customer, I should be able to see error message, when I do not provide a correct email address or password in a pop up window

    @Test
    public void US100208_Negative_Login() {
        //As admin or customer, I should be able to see error message, when I do not provide a correct email address or password in a pop up window
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));

        rentalHomePage.loginLink.click();

        rentalLoginPage.userEmail.sendKeys("fake@bluerentalcars.com");
        rentalLoginPage.userPassword.sendKeys("fakepass");
        rentalLoginPage.loginButton.click();

        //Without waiting, test case fails because the alert element cause a synchronization issue.
        //There are 2 types waits we can use:
        //1st: Hard Wait
        //WaitUtils.waitFor(3); //--> This uses hard wait, it is NOT recommended
        //2nd: Explicit Wait
        //WaitUtils.waitForVisibility(rentalLoginPage.errorMessage_incorrectEmailAndPassword,5); -->This uses explicit wait, it is recommended

        //Error Message: User with email fake@bluerentalcars.com not found

        //After using waits the assertion below will pass
        String expectedErrorText ="User with email fake@bluerentalcars.com not found";
//        String actualErrorText = rentalLoginPage.errorMessage_incorrectEmailAndPassword.getText();
//        assertEquals(expectedErrorText, actualErrorText);

        //We can also use a reusable method to do text assertion quicker
        ReusableMethods.verifyExpectedAndActualTextsMatch(expectedErrorText, rentalLoginPage.errorMessage_incorrectEmailAndPassword);

        Driver.closeDriver();
    }
}