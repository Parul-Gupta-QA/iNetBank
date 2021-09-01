package com.inetBanking.testCases;

import com.inetBanking.pageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest() throws IOException {

    logger.info("URL is opened");

        Login login = new Login(driver);
        login.setUserName(username);
        logger.info("entered username");
        login.setPassword(password);
        logger.info("entered pwd");
        login.clickButton();
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }else{
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("login test failed");
        }
    }
}
