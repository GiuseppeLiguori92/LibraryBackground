package com.opensignal.giuseppeliguori.counter;

import android.util.Log;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */

public class LongOperation {

    private static final String TAG = "LongOperation";

    private OnNewUpdateAvailable onNewUpdateAvailable;
    private Thread mThread;

    public LongOperation() {}

    public LongOperation(OnNewUpdateAvailable onNewUpdateAvailable) {
        if (onNewUpdateAvailable != null) {
            this.onNewUpdateAvailable = onNewUpdateAvailable;
        }
    }

    public void run() {
        if (mThread == null) {
            mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int counter = 0;
                    while (true) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter++;
                        Log.d(TAG, "run() called: " + counter);
                        if (onNewUpdateAvailable != null) {
                            onNewUpdateAvailable.onNewUpdateAvailable(counter);
                        }
                    }
                }
            });
            mThread.start();
        }
    }

    public interface OnNewUpdateAvailable {
        void onNewUpdateAvailable(int update);
    }
}
