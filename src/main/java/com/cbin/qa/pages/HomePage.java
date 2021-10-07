package com.cbin.qa.pages;

import com.cbin.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {
    @FindBy(xpath = "//a[@href='#/createclient']")
    WebElement clients;
    @FindBy(xpath = "//span[contains(text(),'Head Office')]")
    WebElement office;
    @FindBy(id="firstname")
    WebElement firstname;
    @FindBy(id="lastname")
    WebElement lastname;
    @FindBy(id="mobileNo")
    WebElement mobileNo;
    @FindBy(id = "emailAddress")
    WebElement email;
    @FindBy(xpath = "//span[contains(text(),'--Select Gender--')]")
    WebElement gender;
    @FindBy(xpath = "//span[contains(text(),'--Select Client Type--')]")
    WebElement clientTypeDropDown;
    @FindBy(xpath = "//h3//strong[@class='ng-binding']")
    WebElement welcome;
    @FindBy(css = "[ng-click='addAddress()']")
    WebElement AddAddress;
    @FindBy(xpath = "//span[contains(text(),'Select Address Type')]")
    WebElement addressType;
    @FindBy(css = "[name='street0']")
    WebElement street;
    @FindBy(id="save")
    WebElement submit;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String validateWelcomenote(){
        return welcome.getText();
    }
    public void createClient() {
        clients.click();
        office.click();
        WebElement officeType = office;
        officeType.findElement(By.xpath("//li[contains(text(),'"+prop.getProperty("office") +"')]")).click();
        firstname.sendKeys(prop.getProperty("clientFName"));
        lastname.sendKeys(prop.getProperty("clientLName"));
        mobileNo.sendKeys(prop.getProperty("clientMobile"));
        email.sendKeys(prop.getProperty("clientEmail"));
        gender.click();
        WebElement genderselect = gender;
        genderselect.findElement(By.xpath("//li[contains(text(),'"+prop.getProperty("gender") +"')]")).click();
        clientTypeDropDown.click();
        WebElement clientdropdown = clientTypeDropDown;
        clientdropdown.findElement(By.xpath("//li[@data-option-array-index='1']")).click();
        AddAddress(driver,AddAddress,10);
        addressType.click();
        WebElement addressTypeDropDown = addressType;
        addressTypeDropDown.findElement(By.linkText(prop.getProperty("clientAddressType"))).click();
        street.sendKeys(prop.getProperty("clientStreet"));
        submit.click();
    }
    public static void AddAddress(WebDriver driver, WebElement locator, int timeout){
        new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }
    public static void ActivateClient(){
        driver.findElement(By.cssSelector("[has-permission='ACTIVATE_CLIENT']")).click();
    }
    public String clientName = driver.findElement(By.cssSelector(".client-title strong[class='ng-binding']")).getText();
    public String  clientID = driver.findElement(By.cssSelector("small[class='ng-binding']")).getText();

}

