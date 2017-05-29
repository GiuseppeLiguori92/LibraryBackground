package com.opensignal.giuseppeliguori.counter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class InitializationService extends Service {

    private static final String TAG = "InitializationService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread.currentThread().setName("Library-Thread");
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.d(TAG, "uncaughtException() called with: t = [" + t + "], e = [" + e + "]");
            }
        });

        startService(new Intent(this, CounterService.class));
        Log.d(TAG, "onStartCommand() called with: intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() called with: intent = [" + intent + "]");
        return null;
    }
}
