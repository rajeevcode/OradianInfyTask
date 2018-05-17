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
    CorporateClient corporateClient;

    public ClientPageTest() {
        super ( );
    }

    @BeforeMethod
    public void setUp() {
        // to initialize create login page object
        initialization ( );
        // testUtil = new TestUtil ( );
        loginPage = new LoginPage ( );
        clientPage = new ClientPage ( );
        corporateClient = new CorporateClient ( );
        homePage = loginPage.login ( prop.getProperty ( "username" ), prop.getProperty ( "password" ) );
        homePage.verifyCreateClientLink ( );
    }

    @Test(priority = 1)
    public void verifyClientPageTitleTest() {
//        String clientPageTitle = clientPage.verifyClientPageTitle ();
//        Assert.assertEquals ( clientPageTitle, "Instafin - Create Corporate Client" );
        //System.out.println ( clientPageTitle );
        Assert.assertTrue ( clientPage.verifyClientPageTitle ( ), "Client Page message is missing on the page" );

    }

    @AfterMethod
    public void tearDown() {
        driver.quit ( );
    }


}
