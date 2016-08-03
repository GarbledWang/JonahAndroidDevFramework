package com.jonah.jonahworld.util;

import android.widget.Button;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class TimeCount extends CountDownTimer {
    private Button mButton;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval, Button mButton) {
        super(millisInFuture, countDownInterval);
        this.mButton = mButton;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (mButton != null && mButton.isShown()) {
            mButton.setEnabled(false);
            mButton.setText((millisUntilFinished / 1000) + "秒后重新发送");
        }
    }


    @Override
    public void onFinish() {
        if (mButton != null && mButton.isShown()) {
            mButton.setEnabled(true);
            mButton.setText("发送验证码");
        }
    }
}
