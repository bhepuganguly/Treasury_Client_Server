package com.example.tatha.project5treasuryserv;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

import com.example.tatha.Project5Common.IMyAidlInterface;

import static com.example.tatha.project5treasuryserv.MyTreasuryService.status;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class MainActivity extends Activity {

    TextView tv;
    BroadcastReceiver listener = new BroadcastReceiver() {
        @Override
        public void onReceive( Context context, Intent intent ) {
            String data = intent.getStringExtra("status");
            tv = findViewById(R.id.tv);
            tv.setText(data);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv.setText("Service is not bound");
        LocalBroadcastManager.getInstance(this).registerReceiver(listener,new IntentFilter("send_status"));


        }

    }

