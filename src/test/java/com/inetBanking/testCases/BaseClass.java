package com.inetBanking.testCases;

import com.inetBanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    @Parameters("browser")
    @BeforeClass
    public void setUp(String br)
    {
        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.xml");

        if(br.equals("chrome"))
        {
        System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
        driver = new ChromeDriver();
    }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(baseURL);
        }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    public String randomString(){
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String randomNum(){
        return RandomStringUtils.randomNumeric(4);
    }
}
