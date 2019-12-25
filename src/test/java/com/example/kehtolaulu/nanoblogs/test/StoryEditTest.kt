package com.example.kehtolaulu.nanoblogs.test

import com.example.kehtolaulu.nanoblogs.test.fixtures.StoryFixture
import com.example.kehtolaulu.nanoblogs.test.stories.MyProfilePage
import com.example.kehtolaulu.nanoblogs.test.stories.NewStoryPage
import com.example.kehtolaulu.nanoblogs.test.stories.StoryData
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class StoryEditTest : AuthenticatedTest() {
    private val storyFixture = StoryFixture
    private var storyPage: MyProfilePage = MyProfilePage()
    private val oldStory: StoryData = storyFixture.next()
    private val newStory: StoryData = storyFixture.next()

    @Before
    fun setUp() {
        val newStoryPage = NewStoryPage()
        newStoryPage.visit()
        newStoryPage.createStory(oldStory)
    }

    @Test
    fun testEdit() {
        storyPage.visitFirst()
        storyPage.updateStory(newStory)
        assertTrue("Story updated.", storyPage.hasStory(newStory))
        assertFalse("No old text.", storyPage.hasStory(oldStory))
    }
}

