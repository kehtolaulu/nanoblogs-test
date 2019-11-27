package com.example.kehtolaulu.nanoblogs.test;

import org.openqa.selenium.WebDriver;

public class Navigation {
    private WebDriver driver;
    private static final String baseUrl = "https://nanoblogs.herokuapp.com/";


    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public void visitHome() {
        driver.get(baseUrl);
    }

    public void visitMainPage() {
        visit("/stories");
    }

    public void visitStoriesPage() {
        visit("/stories");
    }

    public void visitRegistration() {
        visit("/users/sign_up");
    }

    public void visitNewStoryPage() {
        visit("/stories/new");
    }

    public void visitSignInPage() {
        visit("/users/sign_in");
    }

    public void visit(String path) {
        driver.get(baseUrl + path);
    }
}
