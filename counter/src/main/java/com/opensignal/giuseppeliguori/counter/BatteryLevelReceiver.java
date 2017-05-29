package com.opensignal.giuseppeliguori.counter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class BatteryLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "BatteryLevelReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive() called with: context = [" + context + "], intent = [" + intent + "]");
    }
}
