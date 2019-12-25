package com.example.kehtolaulu.nanoblogs.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    private static WebDriver driver;

    public static WebDriver driver() {
        if (driver == null) {
            synchronized (DriverHolder.class) {
                if (driver == null) {
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }
}
