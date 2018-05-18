package com.infy.qa.testcases;

import com.infy.qa.base.TestBase;
import com.infy.qa.pages.ClientPage;
import com.infy.qa.pages.HomePage;
import com.infy.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClientPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ClientPage clientPage;

    public ClientPageTest() {
        super ( );
    }

    @BeforeMethod
    public void setUp() {
        // to initialize create login page object
        initialization ( );
        loginPage = new LoginPage ( );
        clientPage = new ClientPage ( );
        homePage = loginPage.login ( prop.getProperty ( "username" ), prop.getProperty ( "password" ) );
        homePage.verifyCreateClientLink ( );
    }

    @Test(priority = 1)
    public void verifyClientPageTitleTest() {
        Assert.assertTrue ( clientPage.verifyClientPageTitle ( ), "Client Page message is missing on this page" );

    }

    @AfterMethod
    public void tearDown() {
        driver.quit ( );
    }
}
