package com.opensignal.giuseppeliguori.sender;

import android.app.Service;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class BatteryLevelService extends Service {

    private static final String TAG = "InitializationService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent message = new Intent();
                message.setAction("ACTION_BATTERY_LEVEL");
                BatteryManager batteryLevel = (BatteryManager)getSystemService(BATTERY_SERVICE);
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int battery = batteryLevel.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                    message.putExtra("BATTERY_LEVEL", battery);
                    sendBroadcast(message);
                    Log.e(TAG, "run: BROADCAST SENT " + battery);
                }
            }
        }).start();
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
