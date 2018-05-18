package com.infy.qa.base;

/*@author rajeev kumar
---
 */
import com.infy.qa.util.TestUtil;
import com.infy.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static Properties Repository = new Properties ( );
    public File f;
    public FileInputStream ip;

    public TestBase() {

        /* this fix is for relative path.Now it will work on relative path.It will pick path from src folder
         as relative path not hardcoded with absolute path.
         */
        try {
            prop = new Properties ( );
            f = new File ( System.getProperty ( "user.dir" ) +
                    "/src/main/java/com/infy/qa/config/config.properties" );
            ip = new FileInputStream ( f );
            prop.load ( ip );
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    public static void initialization() {

        String browserName = prop.getProperty ( "browser" );

        //Added below code so script will not fail when triggered on different OS(Mac or Windows)
        if ( System.getProperty ( "os.name" ).contains ( "Window" ) ) {
            if ( browserName.equalsIgnoreCase ( "firefox" ) ) {
                System.out.println ( System.getProperty ( "user.dir" ) );
                driver = new FirefoxDriver ( );
            }
            else if ( browserName.equalsIgnoreCase ( "chrome" ) ) {
                driver = new ChromeDriver ( );
            }
        }
        else if ( System.getProperty ( "os.name" ).contains ( "Mac" ) ) {
            System.out.println ( System.getProperty ( "os.name" ) );
            driver = new ChromeDriver ( );


            e_driver = new EventFiringWebDriver ( driver );
            eventListener = new WebEventListener ( );
            e_driver.register ( eventListener );
            driver = e_driver;

            driver.manage ( ).window ( ).maximize ( );
            driver.manage ( ).deleteAllCookies ( );
            driver.manage ( ).timeouts ( ).pageLoadTimeout ( TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS );
            driver.manage ( ).timeouts ( ).implicitlyWait ( TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );

            driver.get ( prop.getProperty ( "url" ) );
        }
    }
}



