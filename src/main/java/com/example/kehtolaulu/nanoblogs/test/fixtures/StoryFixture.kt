package com.example.kehtolaulu.nanoblogs.test.fixtures

import com.example.kehtolaulu.nanoblogs.test.stories.StoryData
import com.google.gson.Gson
import java.io.File

object StoryFixture : Iterator<StoryData> {
    private val jsonFactory = Gson()
    private val file = File("stories.json")

    private var stories = listOf<StoryData>()
    private var iterator: Iterator<StoryData> = stories.iterator()

    init {
        read()
    }

    private fun read() {
        val json = file.readText()
        val fromJson = jsonFactory.fromJson<Stories>(json, Stories::class.java)
        stories = fromJson.stories
        iterator = stories.iterator()
    }

    override fun hasNext() = iterator.hasNext()
    override fun next() = iterator.next()
}
