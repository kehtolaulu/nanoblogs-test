package com.example.kehtolaulu.nanoblogs.test.stories;

import com.example.kehtolaulu.nanoblogs.test.Page;
import org.openqa.selenium.By;

public class MyProfilePage extends Page {
    @Override
    public void visit() {
        navigation().visitMainPage();
        clickElement(By.cssSelector("body > div > div.row > div:nth-child(1) > a"));
    }

    public void visitFirst() {
        visit();
        clickElement(
                By.cssSelector(
                        "body > div > div.col-md-6.offset-md-3.container > div:nth-child(4) >" +
                                "div.row.post-footer.justify-content-between > div:nth-child(1) > a"
                )
        );
    }

    public void editStory(StoryData storyData) {
        clickElement(By.linkText("Edit"));
        input(storyData.getText()).toElement(By.id("story_content"));
        clickElement(By.name("commit"));
    }

    public boolean hasStory(StoryData storyData) {
        return hasText(storyData.getText());
    }

    public boolean deleteFirstStory() {
        await();
        clickElement(By.linkText("Delete"));
        return ifAlert(alert -> {
            alert.accept();
            return true;
        });
    }
}
