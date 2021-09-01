package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    public Login(WebDriver webDriver){
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "uid")
    WebElement userName;

    @FindBy(name = "password")
    WebElement pwd;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    WebElement logOut;

    public void setUserName(String uname){
        userName.sendKeys(uname);
    }

    public void setPassword(String pass) {
        pwd.sendKeys(pass);
    }
        public void clickButton(){
        loginButton.click();

        }

        public void clickLogOut(){
        logOut.click();
        }
    }

