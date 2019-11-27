package com.example.kehtolaulu.nanoblogs.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class Page {
    private WebDriver driver;
    private Navigation navigation;

    public Page() {
        driver = DriverHolder.driver();
        navigation = new Navigation(driver);
        navigation.visitHome();
        await();
    }

    protected Navigation navigation() {
        return navigation;
    }

    public abstract void visit();

    public ElementPresent isElement(By selector) {
        return () -> element(selector).isDisplayed();
    }

    public <T> T ifAlert(Function<? super Alert, T> action) {
        return ExpectedConditions.alertIsPresent().andThen(action).apply(driver);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean hasText(String text) {
        return !driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).isEmpty();
    }

    protected InputElement input(String text) {
        return selector -> {
            WebElement element = element(selector);
            element.clear();
            element.sendKeys(text);
        };
    }

    private WebElement element(By selector) {
        return driver.findElement(selector);
    }

    protected void clickElement(By selector) {
        element(selector).click();
    }

    protected void await() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        driver.quit();
    }
}
