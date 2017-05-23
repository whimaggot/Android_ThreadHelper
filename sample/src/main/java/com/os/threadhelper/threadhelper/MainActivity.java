package com.os.threadhelper.threadhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.os.threadhelper.library.ThreadHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadHelper.runOnAsyncThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("MainActivity","runOnAsyncThread");
                        ThreadHelper.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)MainActivity.this.findViewById(R.id.text)).setText("change text on UI Thread");
                            }
                        });
                    }
                });
            }
        });
    }
}
