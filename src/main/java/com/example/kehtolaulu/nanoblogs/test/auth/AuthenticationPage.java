package com.example.kehtolaulu.nanoblogs.test.auth;

import com.example.kehtolaulu.nanoblogs.test.Page;
import org.openqa.selenium.By;

public class AuthenticationPage extends Page {
    @Override
    public void visit() {
        navigation().visitSignInPage();
    }

    public void login(UserData credentials) {
        input(credentials.getEmail()).toElement(By.id("user_email"));
        input(credentials.getPassword()).toElement(By.id("user_password"));
        clickElement(By.name("commit"));
    }

    public void logOut() {
        clickElement(By.linkText("sign out"));
    }
}
