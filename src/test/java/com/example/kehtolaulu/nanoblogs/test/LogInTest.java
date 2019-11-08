package com.example.kehtolaulu.nanoblogs.test;

import com.example.kehtolaulu.nanoblogs.test.auth.AuthenticationPage;
import com.example.kehtolaulu.nanoblogs.test.auth.UserData;
import org.junit.*;

public class LogInTest {
    private static AuthenticationPage authPage;
    private UserData credentials;

    @BeforeClass
    public static void init() {
        authPage = new AuthenticationPage();
    }

    @Before
    public void initUserData() {
        credentials = new UserData("aivvent@yandex.ru", "123456");
    }

    @Test
    public void testLogIn() {
        authPage.open();
        authPage.login(credentials);
        authPage.logOut();
    }
}
