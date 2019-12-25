package com.example.kehtolaulu.nanoblogs.test.fixtures

import com.example.kehtolaulu.nanoblogs.test.stories.StoryData
import com.google.gson.Gson
import java.io.File
import java.util.*

object StoryGenerator {
    private val jsonFactory = Gson()
    private val file = File("stories.json")

    private val stories = mutableListOf<StoryData>()

    fun flush() {
        file.writeText(asJson())
    }

    fun add(story: StoryData) {
        stories.add(story)
    }

    private fun asJson(): String = jsonFactory.toJson(Stories(stories))

    fun addUnique() = stories.add(unique())

    private fun unique() = StoryData("This is story number ${UUID.randomUUID()}")
}

fun main() {
    repeat(100) {
        StoryGenerator.addUnique()
    }
    StoryGenerator.flush()
}
