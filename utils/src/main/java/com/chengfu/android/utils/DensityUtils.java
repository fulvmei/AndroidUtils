package com.chengfu.android.utils;

import android.content.res.Resources;

/**
 * utils about density
 */
public final class DensityUtils {
    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Value of dp to value of px.
     *
     * @param dpValue The value of dp.
     * @return value of px
     */
    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * Value of px to value of dp.
     *
     * @param pxValue The value of px.
     * @return value of dp
     */
    public static int px2dp(final float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Value of sp to value of px.
     *
     * @param spValue The value of sp.
     * @return value of px
     */
    public static int sp2px(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * Value of px to value of sp.
     *
     * @param pxValue The value of px.
     * @return value of sp
     */
    public static int px2sp(final float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * Value of dp to value of sp.
     *
     * @param dpValue The value of dp.
     * @return value of sp
     */
    public static int dp2sp(final float dpValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        float px = dpValue * scale;
        return (int) (px / fontScale + 0.5f);
    }

    /**
     * Value of sp to value of dp.
     *
     * @param spValue The value of px.
     * @return value of dp
     */
    public static int sp2dp(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        float pxValue = spValue * fontScale;
        return (int) (pxValue / scale + 0.5f);
    }
}
