package com.example.kehtolaulu.nanoblogs.test

import com.example.kehtolaulu.nanoblogs.CommonAccount
import com.example.kehtolaulu.nanoblogs.test.auth.AuthenticationPage
import com.example.kehtolaulu.nanoblogs.test.auth.UserData
import org.junit.Before
import org.junit.BeforeClass


abstract class AuthenticatedTest {
    val userData: UserData = CommonAccount

    @Before
    fun logIn() {
        init()
        if (!loggedIn()) {
            authPage.visit()
            authPage.login(userData)
        }
    }

    fun logOut() {
        authPage.logOut()
    }

    fun loggedIn() = authPage.hasText("sign out")

    companion object {
        private lateinit var authPage: AuthenticationPage
        @BeforeClass
        @JvmStatic
        fun init() {
            authPage = AuthenticationPage()
        }
    }
}
