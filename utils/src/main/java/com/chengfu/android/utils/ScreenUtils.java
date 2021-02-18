package com.chengfu.android.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * utils about screen
 */
public final class ScreenUtils {

    private ScreenUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Return the width of screen, in pixel.
     *
     * @param context The context
     * @return the width of screen, in pixel
     */
    public static int getScreenWidth(@NonNull Context context) {
        int screenWidth = -1;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.getDisplay().getRealSize(point);
        } else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (wm == null) {
                return screenWidth;
            }
            wm.getDefaultDisplay().getRealSize(point);
        }
        screenWidth = point.x;
        return screenWidth;
    }

    /**
     * Return the height of screen, in pixel.
     *
     * @param context The context
     * @return the height of screen, in pixel
     */
    public static int getScreenHeight(@NonNull Context context) {
        int screenHeight = -1;
        Point point = new Point();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.getDisplay().getRealSize(point);
        } else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (wm == null) {
                return screenHeight;
            }
            wm.getDefaultDisplay().getRealSize(point);
        }
        screenHeight = point.y;
        return screenHeight;
    }

    /**
     * Return the application's width of screen, in pixel.
     *
     * @param context The context
     * @return the application's width of screen, in pixel
     */
    public static int getAppScreenWidth(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int appScreenWidth = -1;
        if (wm == null) {
            return appScreenWidth;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.getDisplay().getSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        appScreenWidth = point.x;
        return appScreenWidth;
    }

    /**
     * Return the application's height of screen, in pixel.
     *
     * @param context The context
     * @return the application's height of screen, in pixel
     */
    public static int getAppScreenHeight(@NonNull Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int appScreenHeight = -1;
        if (wm == null) {
            return appScreenHeight;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.getDisplay().getSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        appScreenHeight = point.y;
        return appScreenHeight;
    }

    /**
     * Return the density of screen.
     *
     * @return the density of screen
     */
    public static float getScreenDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * Return the screen density expressed as dots-per-inch.
     *
     * @return the screen density expressed as dots-per-inch
     */
    public static int getScreenDensityDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    /**
     * Return whether screen is landscape.
     *
     * @param context The context
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isLandscape(@NonNull Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * Return whether screen is landscape.
     *
     * @param context The context
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isPortrait(@NonNull Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }
}
