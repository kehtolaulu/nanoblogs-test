package com.example.kehtolaulu.nanoblogs.test

import com.example.kehtolaulu.nanoblogs.test.fixtures.StoryFixture
import com.example.kehtolaulu.nanoblogs.test.stories.NewStoryPage
import com.example.kehtolaulu.nanoblogs.test.stories.StoryData
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

class StoryCreationTest : AuthenticatedTest() {
    private var story: StoryData = StoryFixture.next()

    @Test
    fun testStoryCreation() {
        storyPage!!.visit()
        storyPage!!.createStory(story)
        assertTrue("Story created", storyPage!!.hasText(story.text))
    }

    companion object {
        private var storyPage: NewStoryPage? = null
        @BeforeClass
        @JvmStatic
        fun initV() {
            storyPage = NewStoryPage()
        }
    }
}