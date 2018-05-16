package com.infy.qa.pages;

import com.infy.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    LoginPage loginPage;
    HomePage homepage;

    @FindBy(xpath = "//*[@id=\"activity-stream\"]/div[1]/div[1]/a")
    WebElement usernameLabel;

    @FindBy(xpath = "//*[@id=\"activity-stream\"]/div[1]/div[1]/a")
    WebElement clickUsername;

    @FindBy(xpath = "//div[2]/div/div[1]/div/ul/li[3]/a/i")
    WebElement clickCreateClients;

    @FindBy(linkText = "Corporate")
    WebElement clickCorporateClient;

    public HomePage() {
        PageFactory.initElements ( driver, this );

    }

    public String verifyHomepageTitle() {
        return driver.getTitle ( );

    }

    public UserProfilePage verifyUsernameLink() {
        clickUsername.click ( );
        return new UserProfilePage ( );
    }

    public Boolean verifyCorrectUserName() {
        return usernameLabel.isDisplayed ( );
    }

    public ClientPage verifyCreateClientLink() {
        //clickUsername.click ( );
        clickCreateClients.click ( );
        clickCorporateClient.click ();

        return new ClientPage ( );
    }
}


