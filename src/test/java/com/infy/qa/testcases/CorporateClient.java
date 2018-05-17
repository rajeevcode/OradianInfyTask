package com.infy.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CorporateClient {


    public static void main(String[] args) {

        // Login
        WebDriver driver = new ChromeDriver ( );
        //WebDriver driver = new FirefoxDriver (  );
        driver.get ( "https://rajeev.instafin.info/user/login" );
        driver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );
        driver.findElement ( By.id ( "us1" ) ).sendKeys ( "rajeev" );
        driver.findElement ( By.id ( "pw1" ) ).sendKeys ( "test@123" );
        driver.findElement ( By.xpath ( "//div[2]/form/fieldset/button" ) ).click ( );

        //click on client on dashboard
        driver.findElement ( By.xpath ( "/html/body/div[2]/div/div[1]/div/ul/li[3]/a/i" ) ).click ( );

        driver.findElement ( By.linkText ( "Corporate" ) ).click ( );
        //create new corporate clients
        driver.findElement ( By.xpath ( "//input[@type=\"text\"]" ) ).sendKeys ( "test12" );
        driver.findElement ( By.xpath ( "//input[@id=\"address_street1\"]" ) ).sendKeys ( "baker street" );
        driver.findElement ( By.xpath ( "//input[@id=\"address_state\"]" ) ).sendKeys ( "Bangkok" );
        driver.findElement ( By.xpath ( "//input[@id=\"address_city\"]" ) ).sendKeys ( "Bangkok" );
        driver.findElement ( By.xpath ( "//input[@id=\"address_postCode\"]" ) ).sendKeys ( "10110" );
        driver.findElement ( By.xpath ( "//input[@id=\"address_country\"]" ) ).sendKeys ( "Thailand" );
        //Mobile Phone
        WebDriverWait wait = new WebDriverWait ( driver, 10 );
        driver.findElement ( By.xpath ( "//*[@id=\"contact_phoneRegionCode\"]" ) ).click ( ); // open the dropdown
        wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( "//*[@id=\"contact_phoneRegionCode\"]/option[53]" ) ) ).click ( );

        driver.findElement ( By.xpath ( "//input[@id=\"contact_mobileNumber\"]" ) ).sendKeys ( "8988882228" );

        driver.findElement ( By.xpath ( "//input[@id=\"contact_email\"]" ) ).sendKeys ( "test@infy.com" );

        //Select branch id
        Select branchID = new Select ( driver.findElement ( By.xpath ( "//select[@id=\"corporateClientCreateBranchId\"]" ) ) );
        branchID.selectByValue ( "SW" );

        Select creditOfficer = new Select ( driver.findElement ( By.xpath ( "//select[@id=\"corporateClientCreateCreditOfficerId\"]" ) ) );
        creditOfficer.selectByValue ( "USR-033" );

//       Select centre = new Select ( driver.findElement ( By.xpath ( "//select[@id=\"corporateClientCreateCentreId\"]" ) ) );
//       centre.selectByValue ( "Please select" );
        driver.findElement ( By.xpath ( "//select[@id=\"corporateClientCreateCentreId\"]" ) ).click ( );

        driver.findElement ( By.xpath ( "//input[@id=\"optionals_beneficiaryDateOfBirth\"]" ) ).sendKeys ( "31/05/2018" );

        driver.findElement ( By.xpath ( "//input[@id=\"optionals_beneficiaryName\"]" ) ).sendKeys ( "kumar" );

        driver.findElement ( By.xpath ( "//input[@id=\"optionals_signatories\"]" ) ).sendKeys ( "12333" );

        //type of bussiness
        Select businessTypes = new Select ( driver.findElement ( By.xpath ( "//select[@id=\"optionals_typeOfBusiness\"]" ) ) );
        businessTypes.selectByValue ( "187" );

        //tax number
        driver.findElement ( By.xpath ( "//input[@id=\"optionals_taxNumber\"]" ) ).sendKeys ( "12345" );

        driver.findElement ( By.xpath ( "//textarea[@id=\"notes\"]" ) ).sendKeys ( "my name is ...." );

        //created date
        driver.findElement ( By.xpath ( "//input[@id=\"createdOn\"]" ) ).sendKeys ( "16/05/2018" );

        driver.findElement ( By.xpath ( "//button[@id=\"disableAfterClick\"]" ) ).click ( );

        //upload image
        driver.manage ( ).timeouts ( ).implicitlyWait ( 20, TimeUnit.SECONDS );
        WebElement element = driver.findElement ( By.xpath ( "//*[@id=\"info\"]/div[1]/div/div[1]/image-upload/div/div[2]/input" ) );
        element.sendKeys ( "/Users/rajeev.kumar/Desktop/download.jpeg" );


//        WebDriverWait wait1 = new WebDriverWait(driver, 10);
//        WebElement guru99;
//        guru99 = wait1.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"info\"]/div[1]/div/div[1]/image-upload/div/div[2]/input")));
//        guru99.click ();
//        //element2.sendKeys ( "/Users/rajeev.kumar/Desktop/download.jpeg" );
//
        WebElement element1 = driver.findElement ( By.xpath ( "//*[@id=\"info\"]/div[1]/div/div[2]/image-upload/div/div[2]/input" ) );
        element1.sendKeys ( "/Users/rajeev.kumar/Desktop/sign.jpeg" );

        //status change
        driver.findElement ( By.xpath ( "//*[@id=\"showClientStatusChange\"]" ) ).click ( );

        driver.findElement ( By.xpath ( "//*[@id=\"react-select-3--value\"]/div[1]" ) ).click ( );
        driver.findElement ( By.xpath ( "//*[@id=\"react-select-3--value-item\"]" ) ).click ( );


    }
}

//*[@id="contact_phoneRegionCode"]