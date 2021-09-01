package com.inetBanking.testCases;

import com.inetBanking.pageObjects.Login;
import com.inetBanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        Login login= new Login(driver);
        login.setUserName(user);
        logger.info("username provided");
        login.setPassword(pwd);
        logger.info("password provided");
        login.clickButton();
        Thread.sleep(3000);

        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("login failed");
        }else{
            Assert.assertTrue(true);
            logger.info("login passed");
            login.clickLogOut();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }

    }
    public boolean isAlertPresent(){
        try{
        driver.switchTo().alert();
        return true;
        }
        catch(NoAlertPresentException e){
            return false;
            }
    }

    @DataProvider(name = "LoginData")
    Object[] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "sheet1");
        int colCount = XLUtils.getCellCount(path, "sheet1", 1);

        String[][] loginData = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                loginData[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j);
            }
        }
        return loginData;
    }
    }
