package com.opensignal.giuseppeliguori.counter;

import android.content.Context;
import android.content.Intent;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class Counter {

    private static Counter instance;

    private Intent service;

    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }

    public Counter() {}

    public void onCreate(Context context) {
        if (service == null) {
            service = new Intent(context, InitializationService.class);
            context.startService(service);
        }
    }

    public void onTerminate(Context context) {
        if (service != null) {
            context.stopService(service);
        }
    }

}
