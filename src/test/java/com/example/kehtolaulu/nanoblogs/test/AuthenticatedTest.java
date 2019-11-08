package com.example.kehtolaulu.nanoblogs.test;

import com.example.kehtolaulu.nanoblogs.test.auth.AuthenticationPage;
import com.example.kehtolaulu.nanoblogs.test.auth.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

abstract
public class AuthenticatedTest {
    private static AuthenticationPage authPage;
    private UserData userData;

    @BeforeClass
    public static void init() {
        if (authPage == null) {
            authPage = new AuthenticationPage();
        }
    }

    @Before
    final
    public void logIn() {
        init();
        userData = new UserData("aivvent@yandex.ru", "123456");
        authPage.open();
        authPage.login(userData);
    }

    public UserData getUserData() {
        return userData;
    }

    @After
    public void logOut() {
        authPage.logOut();
    }
}
