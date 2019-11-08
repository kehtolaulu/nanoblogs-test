package com.example.kehtolaulu.nanoblogs.test.auth;

import com.example.kehtolaulu.nanoblogs.test.Page;
import org.openqa.selenium.By;

public class AuthenticationPage extends Page {
    @Override
    public void open() {
        clickElement(By.linkText("sign in"));
        await();
    }

    public void login(UserData credentials) {
        input(credentials.getEmail()).toElement(By.id("user_email"));
        input(credentials.getPassword()).toElement(By.id("user_password"));
        clickElement(By.name("commit"));
        await();
    }

    public void logOut() {
        clickElement(By.linkText("sign out"));
        await();
    }
}
