package com.example.kehtolaulu.nanoblogs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    private WebDriver driver;
    private static final String baseUrl = "https://nanoblogs.herokuapp.com/";

    public Page() {
        driver = DriverHolder.driver();
        driver.get(baseUrl);
        await();
    }

    protected void await() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected abstract void open();

    private WebElement element(By selector) {
        return driver.findElement(selector);
    }

    protected InputElement input(String text) {
        return selector -> {
            WebElement element = element(selector);
            element.clear();
            element.sendKeys(text);
        };
    }

    protected void clickElement(By selector) {
        element(selector).click();
    }

    private void close() {
        driver.quit();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }
}
