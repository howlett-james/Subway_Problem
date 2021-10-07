package com.cbin.qa.testcases;
import com.cbin.qa.base.TestBase;
import com.cbin.qa.pages.HomePage;
import com.cbin.qa.pages.LoginPages;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase_01 extends TestBase{
    LoginPages loginPages;
    HomePage homePage;

    public TestCase_01(){
        super();
    }
    @BeforeTest
    public void setUp(){
        initialization();
        loginPages = new LoginPages();
        homePage = new HomePage();
    }
    @Test(priority = 1)
    public void validLoginTest(){
        Assert.assertEquals(prop.getProperty("title"),loginPages.validateTitle());
        loginPages.Login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 2)
    public void HomePageClient() {
        Assert.assertEquals(prop.getProperty("welcomenote"),homePage.validateWelcomenote());
        homePage.createClient();
        HomePage.ActivateClient();


    }
//    @AfterTest
//    public void TearDown(){
//        driver.quit();
//    }
}
