package com.bwei.moniyuekao_2.utils;

import android.util.Log;

import androidx.annotation.NonNull;

public class MyCreachHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.e("bug==",t.getName()+t);
    }
}
