package myapp.tests.dataprovider;

import myapp.utilities.DataProviderUtils;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    
   /*
What is Data Provider?
-DataProvider is an annotation of TestNG
-It is used to provide data for test cases
-The return type is 2D array

Why do you use Data Provider?
-We use Data Provider to get data from data source(excel, json, xml, text ...)
-We use it for Data Driven Testing.--> DDT: Test the app with multiple data

How do you use Data Provider?
-We have a data source that has multiple data. It is a method that returns 2D Array. We use @DataProvider annotation on this method.
-In @Test method we use "dataProvider" and "dataProviderClass" parameters to link data source and the test method.
 There are 2 parameter in Data Provider.
"name" : used for assigning custom method name
"parallel" :used for parallel testing */

    @Test(dataProvider = "customerCredentials",dataProviderClass = DataProviderUtils.class)
    public void dataProviderTest(String username, String password,int age){

        System.out.println("Username: " + username + " Password: " + password+" Age: "+age);


    }

    @Test(dataProvider = "cities",dataProviderClass = DataProviderUtils.class)
    public void dataProviderTest2(String state, String city, String population){
        System.out.println(state+" "+city+" "+population);
    }


}
