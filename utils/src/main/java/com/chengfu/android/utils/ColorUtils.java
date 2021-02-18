package com.chengfu.android.utils;

import android.graphics.Color;
import android.text.TextUtils;

import androidx.annotation.ColorInt;

/**
 * A set of color-related utility methods, building upon those available in {@code Color}.
 */
public final class ColorUtils {

    private ColorUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Parse the color string
     *
     * @param colorString The color string
     * @return color
     */
    @ColorInt
    public static int parseColor(final String colorString) {
        return parseColor(colorString, 0);
    }

    /**
     * Parse the color string
     *
     * @param colorString  The color string
     * @param defaultColor The default color
     * @return color
     */
    @ColorInt
    public static int parseColor(final String colorString, @ColorInt final int defaultColor) {
        if (colorString == null) {
            return defaultColor;
        }
        String trimmedColorString = colorString.replaceAll("\\s*", "");
        if (trimmedColorString.length() <= 1) {
            return defaultColor;
        }
        if (trimmedColorString.charAt(0) == '#') {
            if (trimmedColorString.length() == 4) {
                trimmedColorString = "#" +
                        trimmedColorString.charAt(1) +
                        trimmedColorString.charAt(1) +
                        trimmedColorString.charAt(2) +
                        trimmedColorString.charAt(2) +
                        trimmedColorString.charAt(3) +
                        trimmedColorString.charAt(3);
            }
        }
        @ColorInt int color = defaultColor;
        if (!TextUtils.isEmpty(trimmedColorString)) {
            try {
                color = Color.parseColor(trimmedColorString);
            } catch (Exception e) {
                color = defaultColor;
            }
        }
        return color;
    }

    /**
     * Color-int to color-string.
     *
     * @param colorInt The color-int.
     * @return color-string
     */
    public static String color2RgbString(@ColorInt final int colorInt) {
        @ColorInt int tempColorInt = colorInt & 0x00ffffff;
        String color = Integer.toHexString(tempColorInt);
        while (color.length() < 6) {
            color = "0" + color;
        }
        return "#" + color;
    }

    /**
     * Color-int to color-string.
     *
     * @param colorInt The color-int.
     * @return color-string
     */
    public static String color2ArgbString(@ColorInt final int colorInt) {
        String color = Integer.toHexString(colorInt);
        while (color.length() < 6) {
            color = "0" + color;
        }
        while (color.length() < 8) {
            color = "f" + color;
        }
        return "#" + color;
    }

    /**
     * Return the random color.
     *
     * @return the random color
     */
    public static int randomColor() {
        return randomColor(true);
    }

    /**
     * Return the random color.
     *
     * @param supportAlpha True to support alpha, false otherwise.
     * @return the random color
     */
    public static int randomColor(boolean supportAlpha) {
        int high = supportAlpha ? (int) (Math.random() * 0x100) << 24 : 0xFF000000;
        return high | (int) (Math.random() * 0x1000000);
    }

    /**
     * Return whether the color is light.
     *
     * @param color The color.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isLightColor(@ColorInt final int color) {
        return 0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color) >= 127.5;
    }
}
