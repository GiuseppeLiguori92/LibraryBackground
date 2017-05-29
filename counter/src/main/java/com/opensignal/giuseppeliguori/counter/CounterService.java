package com.opensignal.giuseppeliguori.counter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class CounterService extends Service {

    private static final String TAG = "InitializationService";
    private Thread mThread;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mThread == null) {
            mThread = new Thread(new Runnable() {
                LongOperation longOperation = new LongOperation();

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        longOperation.run();
                    }
                }
            });
            mThread.start();
        }
        return START_STICKY;
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
