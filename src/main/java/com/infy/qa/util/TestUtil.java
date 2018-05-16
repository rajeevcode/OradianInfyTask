package com.infy.qa.util;

import com.infy.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    // created common method for frames
    public void switchToFrame() {
        driver.switchTo ( ).frame ( "" );
    }
}
