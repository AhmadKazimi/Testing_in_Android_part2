package com.kazimi.testing_in_android_part2

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearDown() {
        // We don't need this now
        // but we going to use it more often
        // here you can just destroy your object you created before
        // or close open db
        // and so on
    }

    @Test
    fun stringResourceSameAsGivenString_returnTrue() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val result = resourceComparer.isEqual(context, R.string.stringToTest1, "String to test 1")

        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceIsNotSameAsGivenString_returnFalse() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val result = resourceComparer.isEqual(
            context,
            R.string.stringToTest2,
            "This string not equal the one in string res"
        )

        assertThat(result).isFalse()
    }
}