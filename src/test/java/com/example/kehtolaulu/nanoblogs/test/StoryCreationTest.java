package com.example.kehtolaulu.nanoblogs.test;

import com.example.kehtolaulu.nanoblogs.test.stories.NewStoryPage;
import com.example.kehtolaulu.nanoblogs.test.stories.StoryData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class StoryCreationTest extends AuthenticatedTest {
    private static NewStoryPage storyPage;
    private StoryData story;

    @BeforeClass
    public static void init() {
        storyPage = new NewStoryPage();
    }

    @Before
    public void prepareData() {
        story = new StoryData(UUID.randomUUID().toString());
    }

    @Test
    public void testStoryCreation() {
        storyPage.visit();
        storyPage.createStory(story);
        assertTrue("Story created", storyPage.hasText(story.getText()));
    }
}
