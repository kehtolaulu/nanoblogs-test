package com.example.kehtolaulu.nanoblogs.test;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        LogInTest.class,
        DeleteStoryTest.class,
        StoryCreationTest.class,
        StoryEditTest.class,
})
public class RunTestSuite extends TestCase {
    @AfterClass
    public static void doYourOneTimeTeardown() {
        DriverHolder.driver().quit();
    }
}
