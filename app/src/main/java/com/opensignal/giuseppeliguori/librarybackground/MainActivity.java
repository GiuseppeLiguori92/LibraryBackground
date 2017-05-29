package com.opensignal.giuseppeliguori.librarybackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.opensignal.giuseppeliguori.counter.LongOperation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");

        LongOperation longOperation = new LongOperation(new LongOperation.OnNewUpdateAvailable() {
            @Override
            public void onNewUpdateAvailable(int update) {
                Log.d(TAG, "onNewUpdateAvailable() called with: update = [" + update + "]");
            }
        });
        longOperation.run();
    }
}
