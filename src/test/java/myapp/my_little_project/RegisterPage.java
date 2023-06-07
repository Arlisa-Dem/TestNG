package myapp.my_little_project;

import myapp.my_little_project.PearlyMarketMyAccount;
import myapp.my_little_project.PearlyMarketRegisterPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage {

 /*   Go to "https://pearlymarket.com"

    User should enter username.

    User should enter email address.

    User should enter password.

    Sign-up should not be completed without clicking "I agree to the privacy policy"

    Click on the SIGN UP button to register.

    Assert all steps have passed successful.

    */
    @Test
    public void registerTest() {
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketMyAccount pearlyMarketMyAccount = new PearlyMarketMyAccount();

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_url"));
        pearlyMarketMyAccount.account.click();
        pearlyMarketRegisterPage.username.sendKeys("Arlisa");
        pearlyMarketRegisterPage.getUsername.sendKeys("arlisademiraj@gmail.com");
        pearlyMarketRegisterPage.password.sendKeys("arlisa1997");
        pearlyMarketRegisterPage.privacyploicy.click();
        pearlyMarketRegisterPage.signup.click();

        Assert.assertTrue(pearlyMarketMyAccount.account.isDisplayed());


    }

}