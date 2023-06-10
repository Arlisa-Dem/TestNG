package myapp.tests.reportstests;

import org.testng.annotations.Test;
import myapp.utilities.LoggerUtils;
import org.testng.annotations.Test;

public class Day25_LoggerTest {


        @Test
        public void test1(){
            LoggerUtils.info("INFO LOG");
            LoggerUtils.warn("WARN LOG");
            LoggerUtils.error("ERROR LOG");
    }
}
