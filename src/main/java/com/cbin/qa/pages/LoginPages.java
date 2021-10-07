package com.cbin.qa.pages;

import com.cbin.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends TestBase {
    //PageFactory - Object Repository
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement SignIn;

    //Initializing the Page Objects
    public LoginPages(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateTitle(){
        return driver.getTitle();
    }

    public void Login(String usn, String pwd){
        username.sendKeys(usn);
        password.sendKeys(pwd);
        SignIn.click();
    }

}
