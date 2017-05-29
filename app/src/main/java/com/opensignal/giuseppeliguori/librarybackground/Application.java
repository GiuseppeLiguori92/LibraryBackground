package com.opensignal.giuseppeliguori.librarybackground;

import android.content.Intent;
import android.util.Log;

import com.opensignal.giuseppeliguori.counter.Counter;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class Application extends android.app.Application {
    private static final String TAG = "Application";
    private Intent init;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.currentThread().setName("ApplicationUI-Thread");
        Log.d(TAG, "onCreate() called");

        Counter.getInstance().onCreate(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        Counter.getInstance().onTerminate(this);

    }
}
