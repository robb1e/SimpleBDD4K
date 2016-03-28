package com.robb1e.simplebdd

import org.junit.Test
import org.junit.Assert.assertEquals

class SimpleBddTests : SimpleBdd {

    @Test
    fun methodizeDescriptions(){
        assertEquals("foo", methodize("foo"))
        assertEquals("fooBar", methodize("foo bar"))
        assertEquals("somethingSomethingDarkside", methodize("SOMETHING SOMETHING DARKSIDE"))
    }

}