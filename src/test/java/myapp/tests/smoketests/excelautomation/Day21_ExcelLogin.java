package myapp.tests.smoketests.excelautomation;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day21_ExcelLogin {


    ExcelUtils excelUtils;
    List<Map<String, String>>  dataList;
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;

    @Test
    public void customerLoginTest(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        excelUtils = new ExcelUtils(path,sheetName);
        dataList = excelUtils.getDataList();
        System.out.println("dataList = " + dataList);


        for (Map<String, String> w : dataList){
            rentalHomePage = new RentalHomePage();
            rentalLoginPage = new RentalLoginPage();

            //Go to homepage
            Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));


            //Sign in
            WaitUtils.waitFor(1);
            //Click on Login
            rentalHomePage.loginLink.click();

            WaitUtils.waitFor(1);
            //Enter email
            rentalLoginPage.userEmail.sendKeys(w.get("username"));

            WaitUtils.waitFor(1);
            //Enter password
            rentalLoginPage.userPassword.sendKeys(w.get("password"));

            WaitUtils.waitFor(1);
//        Click on login
            rentalLoginPage.loginButton.click();

            WaitUtils.waitFor(1);
//        Verify login
            ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);

            //Sign in
//        Click on id
            WaitUtils.waitFor(1);
            rentalHomePage.userID.click();

            WaitUtils.waitFor(1);
//        Click on logout
            rentalHomePage.logOut.click();

            WaitUtils.waitFor(1);
//        Click on OK
            rentalHomePage.OK.click();

        }
        Driver.closeDriver();
    }


    //Loop this Steps:
    /*
    pseudo code:
    Go to homepage
    Click on login
    Enter email
    Enter password
    Click on Login
    Verify login
    Click on id
    Click on logout
    Click on OK


    Go to homepage
    Click on login
    Enter email
    Enter password
    Click on Login
    Verify login
    Click on id
    Click on logout
    Click on OK


    Go to homepage
    Click on login
    Enter email
    Enter password
    Click on Login
    Verify login
    Click on id
    Click on logout
    Click on OK


    Go to homepage
    Click on login
    Enter email
    Enter password
    Click on Login
    Verify login
    Click on id
    Click on logout
    Click on OK
     */
}
