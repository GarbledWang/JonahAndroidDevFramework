package com.jonah.jonahworld.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.EditText;

/**
 * 修改EditText大小的工具类
 * @author JonahWang
 *         Created by JonahWang on 2016/6/29.
 */
public class EditUtils {

    public static void changeHintSize(EditText editText, String hint, int size){
        SpannableString ss = new SpannableString(hint);
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(size, true);
        ss.setSpan(span, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setHint(new SpannableString(ss));
    }
}
