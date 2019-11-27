package com.example.kehtolaulu.nanoblogs.test.stories;

import com.example.kehtolaulu.nanoblogs.test.Page;
import org.openqa.selenium.By;

public class NewStoryPage extends Page {
    @Override
    public void visit() {
        navigation().visitNewStoryPage();
    }

    public void createStory(StoryData storyData) {
        input(storyData.getText()).toElement(By.id("story_content"));
        clickElement(By.name("commit"));
    }
}
