package com.example.kehtolaulu.nanoblogs.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverHolder {
    private static WebDriver driver;

    static WebDriver driver() {
        if (driver == null) {
            synchronized (DriverHolder.class) {
                if (driver == null) {
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }
}
