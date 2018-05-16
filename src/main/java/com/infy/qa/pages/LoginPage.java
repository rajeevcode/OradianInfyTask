package com.infy.qa.pages;

import com.infy.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR:
    @FindBy(id = "us1")
    WebElement username;

    @FindBy(id = "pw1")
    WebElement password;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/fieldset/button")
    WebElement loginButton;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/h2")
    WebElement loginPageMessage;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/a/img")
    WebElement customLogo;

    // Initializing the Page Objects
    public LoginPage() {
        PageFactory.initElements ( driver, this );
        //this is used for pointing to the current class object

    }

    public String validateLoginPageTitle() {
        return driver.getTitle ( );
    }

    public boolean validateLogoImage() {
        return customLogo.isDisplayed ( );
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys ( un );
        password.sendKeys ( pwd );
        loginButton.click ( );

        return new HomePage ( );

    }
}