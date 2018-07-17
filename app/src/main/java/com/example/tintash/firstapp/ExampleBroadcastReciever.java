package com.example.tintash.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == null) return;
        if(intent.getAction().equals(Constants.ACTION.GLOBAL_BROADCAST_INTENT)) {
            Toast.makeText(context, "Global Broadcast Recieved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Local Broadcast Recieved", Toast.LENGTH_SHORT).show();
        }
    }
}
