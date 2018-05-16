package com.infy.qa.util;

import com.infy.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    // created common method for frames
//    public void switchToFrame() {
//        driver.switchTo ( ).frame ( "" );
//    }
//}

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs ( OutputType.FILE );
        String currentDir = System.getProperty ( "user.dir" );

        FileUtils.copyFile ( scrFile, new File ( currentDir + "/screenshots/" + System.currentTimeMillis ( ) + ".png" ) );

    }
}
