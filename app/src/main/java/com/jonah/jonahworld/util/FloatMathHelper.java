package com.jonah.jonahworld.util;

/**
 * Created by Ringo on 16/2/19.
 */

public class FloatMathHelper {
    public static int scale( int base, float multiplier ) {
        return (int) ((base * multiplier) + 0.5);
    }

    public static int unscale( int base, float multiplier ) {
        return (int) ((base / multiplier) + 0.5);
    }
}