package com.example.kehtolaulu.nanoblogs.test

import com.example.kehtolaulu.nanoblogs.test.fixtures.StoryFixture
import com.example.kehtolaulu.nanoblogs.test.stories.MyProfilePage
import com.example.kehtolaulu.nanoblogs.test.stories.NewStoryPage
import junit.framework.TestCase.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DeleteStoryTest : AuthenticatedTest() {
    private lateinit var myProfilePage: MyProfilePage
    private val storyData = StoryFixture.next()

    @Before
    fun setUp() {
        myProfilePage = MyProfilePage()
        storyPage = NewStoryPage()
        storyPage.visit()
        storyPage.createStory(storyData)
    }

    @Test
    fun testDelete() {
        myProfilePage.visit()
        val result = myProfilePage.deleteFirstStory()
        assertTrue(result)
        myProfilePage.visit()
        assertFalse(myProfilePage.hasText("Story was successfully destroyed"))
    }

    companion object {
        private lateinit var storyPage: NewStoryPage
    }
}