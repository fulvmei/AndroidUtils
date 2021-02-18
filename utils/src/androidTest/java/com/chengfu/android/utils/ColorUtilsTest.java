package com.chengfu.android.utils;

import android.graphics.Color;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ColorUtilsTest {

    @Test
    public void parseColor() {
        assertEquals(Color.RED, ColorUtils.parseColor("#f00"));
        assertEquals(Color.RED, ColorUtils.parseColor("#ff0000"));
        assertEquals(Color.RED, ColorUtils.parseColor("red"));
        assertEquals(Color.RED, ColorUtils.parseColor("# f f00 00 "));

        assertEquals(Color.TRANSPARENT, ColorUtils.parseColor(null));
        assertEquals(Color.TRANSPARENT, ColorUtils.parseColor(""));
        assertEquals(Color.TRANSPARENT, ColorUtils.parseColor("abc"));
        assertEquals(Color.TRANSPARENT, ColorUtils.parseColor("#aabbccddee"));

        assertEquals(Color.RED, ColorUtils.parseColor(null, Color.RED));
        assertEquals(Color.RED, ColorUtils.parseColor("", Color.RED));
        assertEquals(Color.RED, ColorUtils.parseColor("abc", Color.RED));
        assertEquals(Color.RED, ColorUtils.parseColor("#aabbccddee", Color.RED));
        assertEquals(Color.BLACK, ColorUtils.parseColor("#FF000000", Color.RED));
    }

    @Test
    public void color2RgbString() {
        assertEquals("#ff0000", ColorUtils.color2RgbString(Color.RED));
        assertEquals("#ffff0000", ColorUtils.color2ArgbString(Color.RED));
    }

    @Test
    public void randomColor() {
        Log.i("ColorUtilsTest", "randomColor:" + ColorUtils.randomColor());
        Log.i("ColorUtilsTest", "randomColor:" + ColorUtils.randomColor());

        Log.i("ColorUtilsTest", "randomColor:" + ColorUtils.randomColor(true));
        Log.i("ColorUtilsTest", "randomColor:" + ColorUtils.randomColor(false));
    }

    @Test
    public void isLightColor() {
        assertFalse(ColorUtils.isLightColor(Color.RED));

        assertTrue(ColorUtils.isLightColor(Color.LTGRAY));
    }
}
