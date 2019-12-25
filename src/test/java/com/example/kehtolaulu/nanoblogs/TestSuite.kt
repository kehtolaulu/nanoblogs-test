package com.example.kehtolaulu.nanoblogs

import com.example.kehtolaulu.nanoblogs.test.*
import junit.framework.TestCase
import org.junit.AfterClass
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
        LogInTest::class,
        DeleteStoryTest::class,
        StoryCreationTest::class,
        StoryEditTest::class
)
object TestSuite : TestCase() {
    @AfterClass
    @JvmStatic
    fun quitDriver() = DriverHolder.driver().quit()
}
