package com.bwei.moniyuekao_2.app;

import android.app.Application;
import android.content.Context;

import com.bwei.moniyuekao_2.utils.MyCreachHandler;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        MyCreachHandler myCreachHandler = new MyCreachHandler();
        Thread.setDefaultUncaughtExceptionHandler(myCreachHandler);
    }

    public static Context getContext() {
        return context;
    }
}
