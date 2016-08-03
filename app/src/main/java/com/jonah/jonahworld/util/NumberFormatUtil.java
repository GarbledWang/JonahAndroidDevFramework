package com.jonah.jonahworld.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Ringo on 15/12/20.
 */
public class NumberFormatUtil {

    public static String format2(double value) {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }

}
