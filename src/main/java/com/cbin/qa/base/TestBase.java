package com.cbin.qa.base;

import com.cbin.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\yokes\\IdeaProjects\\Subway_Problem\\src\\main\\java\\com\\cbin\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    ".\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver",
                    ".\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
