package com.example.kehtolaulu.nanoblogs.test

import com.example.kehtolaulu.nanoblogs.CommonAccount
import com.example.kehtolaulu.nanoblogs.test.auth.AuthenticationPage
import com.example.kehtolaulu.nanoblogs.test.auth.UserData
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

class LogInTest {
    private val credentials: UserData = CommonAccount
    private val incorrectCredentials = UserData("it is a wrong email", "it is a wrong password")

    @Test
    fun testLogIn() {
        authPage!!.visit()
        authPage!!.login(credentials)
        assertTrue("User logged in", isAuthenticated())
        authPage!!.logOut()
    }

    @Test
    fun testLogInWithIncorrectData() {
        authPage!!.visit()
        authPage!!.login(incorrectCredentials)
        assertFalse("User cannot login with incorrect credentials", isAuthenticated())
    }

    private fun isAuthenticated() = authPage!!.hasText("sign out")

    companion object {
        private var authPage: AuthenticationPage? = null
        @BeforeClass
        @JvmStatic
        fun init() {
            authPage = AuthenticationPage()
        }
    }
}