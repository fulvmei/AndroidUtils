package com.chengfu.android.utils;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ScreenUtilsTest {
    public static final String TAG = "ScreenUtilsTest";

    @Test
    public void getScreenWidth() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Log.i(TAG, "screenWidth: " + ScreenUtils.getScreenWidth(appContext));
        Log.i(TAG, "screenHeight: " + ScreenUtils.getScreenHeight(appContext));
        Log.i(TAG, "appScreenWidth: " + ScreenUtils.getAppScreenWidth(appContext));
        Log.i(TAG, "appScreenHeight: " + ScreenUtils.getAppScreenHeight(appContext));
    }
}
