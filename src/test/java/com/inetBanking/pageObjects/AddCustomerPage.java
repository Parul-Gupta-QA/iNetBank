package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;

    public AddCustomerPage(WebDriver webDriver){
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddNewCustomer;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how = How.NAME, using = "rad1")
    @CacheLookup
    WebElement rdGender;

    @CacheLookup
    @FindBy(how = How.ID_OR_NAME, using = "dob")
    WebElement txtDob;

    @CacheLookup
    @FindBy(how = How.NAME, using = "addr")
    WebElement txtAddress;

    @CacheLookup
    @FindBy(how = How.NAME, using = "city")
    WebElement txtCity;

    @CacheLookup
    @FindBy(how = How.NAME, using = "state")
    WebElement txtState;

    @CacheLookup
    @FindBy(how = How.NAME, using = "pinno")
    WebElement txtPinNo;

    @CacheLookup
    @FindBy(how = How.NAME, using = "telephoneno")
    WebElement txtTelephoneNo;

    @CacheLookup
    @FindBy(how = How.NAME, using = "emailid")
    WebElement txtEmailId;

    @CacheLookup
    @FindBy(how = How.NAME, using = "password")
    WebElement txtPassword;

    @CacheLookup
    @FindBy(how = How.NAME, using = "sub")
    WebElement btnSubmit;

    public void clickAddNewCustomer() {
        lnkAddNewCustomer.click();

    }

    public void custName(String cname) {
        txtCustomerName.sendKeys(cname);

    }

    public void custGender(String cGender) {
        rdGender.click();
    }

    public void custDOB(String yy,String mm,String dd) {
        txtDob.sendKeys(yy);
        txtDob.sendKeys(mm);
        txtDob.sendKeys(dd);

    }

    public void custAddress(String cAddress) {
        txtAddress.sendKeys(cAddress);
    }

    public void custCity(String city) {
        txtCity.sendKeys(city);
    }

    public void custState(String cstate) {
        txtState.sendKeys(cstate);
    }

    public void custPinNo(String cpinno) {
        txtPinNo.sendKeys(String.valueOf(cpinno));
    }

    public void custTelephoneNo(String ctelephoneno) {
        txtTelephoneNo.sendKeys(ctelephoneno);
    }

    public void custEmailId(String cemailid) {
        txtEmailId.sendKeys(cemailid);
    }

    public void custPassword(String cpassword) {
        txtPassword.sendKeys(cpassword);
    }

    public void custSubmit() {
        btnSubmit.click();
    }
}
