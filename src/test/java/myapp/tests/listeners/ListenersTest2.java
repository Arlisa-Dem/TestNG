package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class ListenersTest2 {

     /*
    There are 2 ways to connect Listeners and Test Classes
    In this class we use xml file connect ListenersUtil and Test Class
     */

    @Test
    public void test1() {
        System.out.println("PASS --> Test 1");
        assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("FAIL --> Test 2");
        assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP --> Test 3");
        throw new SkipException("This will be skipped on purpose");
    }


    @Test
    public void test4() {
        System.out.println("FAIL --> Exception--> Test 4");
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.id("wrong id"));//--> NoSuchElementException


        //throw new NoSuchElementException("No such element!!!");
    }

}
