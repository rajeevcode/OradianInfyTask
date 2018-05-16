package com.infy.qa.testcases;

import com.infy.qa.base.TestBase;
import com.infy.qa.pages.HomePage;
import com.infy.qa.pages.LoginPage;
import com.infy.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization ( );
        testUtil = new TestUtil ();
        loginPage = new LoginPage ( );
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void verifyHomepageTitleTest() {
        String titleHomepage = homePage.verifyHomepageTitle ( );
        Assert.assertEquals ( titleHomepage, "Instafin - Dashboard" );
        System.out.println (titleHomepage );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit ( );
    }

}
