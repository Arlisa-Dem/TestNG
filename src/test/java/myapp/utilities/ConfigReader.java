package myapp.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



    private static Properties properties;
    //Static block
    static  {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    //Create method that accepts Key and returns Value

    public static String getProperty(String key){
        String value =  properties.getProperty(key);
        return value;
    }

    ////    TEST
//    public static void main(String[] args) {
//        System.out.println(ConfigReader.getProperty("amazon_regression_url"));//https://www.amazon.com
//        System.out.println(ConfigReader.getProperty("amazon_qa_url"));//https://www.qa-amazon-5226a.com
//        System.out.println(ConfigReader.getProperty("browser"));//chrome
//        System.out.println(ConfigReader.getProperty("abcde"));//null
//    }
}
