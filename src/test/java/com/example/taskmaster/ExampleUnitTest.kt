package com.example.taskmaster

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testTaskCreation() {
        val task = Task("1", "Title", "Description", "2023-01-01", 1, false)
        assertEquals("Title", task.title)
    }
}