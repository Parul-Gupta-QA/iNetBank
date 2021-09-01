package com.inetBanking.utilities;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;

    public ReadConfig(){
        File src = new File("./Configurations/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("exception is " + e.getMessage());
            e.printStackTrace();
        }

    }
    public  String getApplicationURL(){
        String URL = properties.getProperty("baseURL");
        return URL;
    }
    public  String getUsername(){
        String uName = properties.getProperty("username");
        return uName;
    }
    public  String getPassword(){
        String pwd = properties.getProperty("password");
        return pwd;
    }

    public String getChromePath() {
        String path = properties.getProperty("chromepath");
        return path;
    }

    public String getFirefoxPath() {
        String fpath = properties.getProperty("firefoxpath");
        return fpath;
    }
}
