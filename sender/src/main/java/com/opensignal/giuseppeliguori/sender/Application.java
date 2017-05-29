package com.opensignal.giuseppeliguori.sender;

import android.content.Intent;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, BatteryLevelService.class));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
