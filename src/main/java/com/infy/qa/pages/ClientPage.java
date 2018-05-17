package com.infy.qa.pages;

import com.infy.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage extends TestBase {

   // Locator to create new client
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[1]/h2/strong")
    WebElement newClientLabel;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/h1/a")
    WebElement clickCorporateClientLink;

    public ClientPage() {
        PageFactory.initElements ( driver, this );

    }

    public boolean verifyClientPageTitle() {

        driver.findElement ( By.xpath ( "//*[@id=\"content\"]/div[2]/div/div[1]/h2/strong" ) ).click ( );
        driver.findElement ( By.xpath ( "//*[@id=\"content\"]/div[1]/div/h1/a" ) ).click ( );
        return newClientLabel.isDisplayed ( );

    }
}