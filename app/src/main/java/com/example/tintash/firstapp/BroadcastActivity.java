package com.example.tintash.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

public class BroadcastActivity extends BaseClassActivity {

    LocalBroadcastManager localBroadcastManager;
    ExampleBroadcastReciever broadcastReciever;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_broadcast_reciever);
        init();
    }

    public void init(){
        broadcastReciever= new ExampleBroadcastReciever();
        registerReceiver(broadcastReciever,
                new IntentFilter(Constants.ACTION.GLOBAL_BROADCAST_INTENT));
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastReciever = new ExampleBroadcastReciever();
        localBroadcastManager.registerReceiver(broadcastReciever,
                new IntentFilter(Constants.ACTION.LOCAL_BROADCAST_INTENT));
    }

    public void broadcastIntent(View v){
       sendBroadcast(new Intent().setAction(Constants.ACTION.GLOBAL_BROADCAST_INTENT));
    }

    public void localBroadcast(View v){
        LocalBroadcastManager.getInstance(this).sendBroadcast(
                new Intent().setAction(Constants.ACTION.LOCAL_BROADCAST_INTENT));
    }

    @Override
    protected void onDestroy() {
        localBroadcastManager.unregisterReceiver(broadcastReciever);
        unregisterReceiver(broadcastReciever);
        super.onDestroy();
    }
}
