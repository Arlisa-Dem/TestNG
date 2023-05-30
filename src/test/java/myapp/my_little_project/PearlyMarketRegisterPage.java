package myapp.my_little_project;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PearlyMarketRegisterPage {

    public PearlyMarketRegisterPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    // User should enter username.
    @FindBy(id = "reg_username")
    public WebElement username;

    //User should enter email address.
    @FindBy(id = "reg_email")
    public WebElement getUsername;

    //User should enter password.
    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement password;

    //Sign-up should not be completed without clicking "I agree to the privacy policy"
    @FindBy(id = "register-policy")
    public WebElement privacyploicy;

    //Click on the SIGN UP button to register.
    @FindBy(name = "register")
    public WebElement signup;


}
