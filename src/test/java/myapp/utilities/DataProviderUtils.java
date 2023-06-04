package myapp.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {


    @DataProvider
    //Two-dimensional
    //This is the data source
    public Object[][] customerCredentials(){

        Object[][] customerInfo = {
                {"customer1", "12345", 33},
                {"customer2", "67890", 33},
                {"customer3", "54321", 34},
                {"customer4", "04567", 25}
        };
        return customerInfo;
    }

    @DataProvider
    public Object[][] cities(){

        Object[][] cities = {
                {"California","LA","39,029,342"},
                {"Texas","AU","30,029,572"},
                {"Florida","MIA","22,244,823"}
        };

        return cities;
    }

    @DataProvider
    public Object[][] customerDataProvider() {
        Object[][] customerInfo = {
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return customerInfo;
    }
    //    THIS DATA SOURCE WILL GET THE DATA FROM THE EXCEL SHEET
    @DataProvider
    public Object[][] excelCustomerDataProvider(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        Object[][] customerInfo = excelUtils.getDataArrayWithoutFirstRow();
        return customerInfo;
    }
}
