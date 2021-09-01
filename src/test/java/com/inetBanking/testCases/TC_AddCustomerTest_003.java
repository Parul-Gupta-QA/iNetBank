package com.inetBanking.testCases;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{
    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        Login lp = new Login(driver);
        lp.setUserName(username);
        logger.info("username provided");
        lp.setPassword(password);
        logger.info("password  provided");
        lp.clickButton();
        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        logger.info("providing customer details....");

        addcust.custName("Parul");
        addcust.custGender("female");
        addcust.custDOB("001985","10","15");
        Thread.sleep(5000);
        addcust.custAddress("INDIA");
        addcust.custCity("HYD");
        addcust.custState("AP");
        addcust.custPinNo("5000074");
        addcust.custTelephoneNo("987890091");

        String email=randomString()+"@gmail.com";
        addcust.custEmailId(email);
        addcust.custPassword("abcdef");
        addcust.custSubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"addNewCustomer");
            Assert.fail();
        }
    }

}



