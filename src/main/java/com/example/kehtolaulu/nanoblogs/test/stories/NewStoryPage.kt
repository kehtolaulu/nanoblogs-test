package com.example.kehtolaulu.nanoblogs.test.stories

import com.example.kehtolaulu.nanoblogs.test.Page
import org.openqa.selenium.By

class NewStoryPage : Page() {
    override fun visit() {
        navigation().visitNewStoryPage()
    }

    fun createStory(storyData: StoryData) {
        input(storyData.text).toElement(By.id("story_content"))
        clickElement(By.name("commit"))
    }
}