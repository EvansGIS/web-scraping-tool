package com.david.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver GetWebDriver(){
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
