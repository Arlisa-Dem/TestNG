package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

    //    All page classes must have a constructor to use page factory
    public OrangeHRMLoginPage(){
        //Page Factory is used to initiate the objects
        //If we don't use this, we get null pointer exception
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //    public WebElement username = driver.findElement(By.name("username"));//TRADITIONAL

    //This is the POM way
    //@FindBy : Locate the webElements
    @FindBy(name="username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement login;

}
