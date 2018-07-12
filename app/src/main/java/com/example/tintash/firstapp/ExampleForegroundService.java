package com.example.tintash.firstapp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ExampleForegroundService extends Service {

    MediaPlayer myPlayer;
    Notification pause;
    Notification play;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(Constants.ACTION.STARTFOREGROUND_ACTION)) {
            myPlayer = MediaPlayer.create(this,R.raw.sample);
            myPlayer.setLooping(false);

            Toast.makeText(this, "Forground Service Started", Toast.LENGTH_LONG).show();

            Intent notificationIntent = new Intent(this, ServiceActivity.class);
            notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                    notificationIntent, 0);

            Intent previousIntent = new Intent(this, ExampleForegroundService.class);
            previousIntent.setAction(Constants.ACTION.PREV_ACTION);
            PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
                    previousIntent, 0);

            Intent playIntent = new Intent(this, ExampleForegroundService.class);
            playIntent.setAction(Constants.ACTION.PLAY_ACTION);
            PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                    playIntent, 0);

            Intent pauseIntent = new Intent(this, ExampleForegroundService.class);
            playIntent.setAction(Constants.ACTION.PAUSE_ACTION);
            PendingIntent ppauseIntent = PendingIntent.getService(this, 0,
                    playIntent, 0);


            Intent nextIntent = new Intent(this, ExampleForegroundService.class);
            nextIntent.setAction(Constants.ACTION.NEXT_ACTION);
            PendingIntent pnextIntent = PendingIntent.getService(this, 0,
                    nextIntent, 0);

            Bitmap icon = BitmapFactory.decodeResource(getResources(),
                    R.drawable.ic_launcher_foreground);

            pause = new NotificationCompat.Builder(this)
                    .setContentTitle("Test Music Player")
                    .setTicker("Test Music Player")
                    .setContentText("My Music")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
                    .setOngoing(true)
                    .addAction(android.R.drawable.ic_media_previous,
                            "Previous", ppreviousIntent)
                    .addAction(android.R.drawable.ic_media_play, "Play",
                            pplayIntent)
                    .addAction(android.R.drawable.ic_media_next, "Next",
                            pnextIntent).build();

            play = new NotificationCompat.Builder(this)
                    .setContentTitle("Test Music Player")
                    .setTicker("Test Music Player")
                    .setContentText("My Music")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
                    .setOngoing(true)
                    .addAction(android.R.drawable.ic_media_previous,
                            "Previous", ppreviousIntent)
                    .addAction(android.R.drawable.ic_media_pause, "Pause",
                            ppauseIntent)
                    .addAction(android.R.drawable.ic_media_next, "Next",
                            pnextIntent).build();
            myPlayer.start();
            startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                    play);
        } else if (intent.getAction().equals(Constants.ACTION.PREV_ACTION)) {
            Toast.makeText(this, "Clicked Prev", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Constants.ACTION.PLAY_ACTION)) {
            Toast.makeText(this, "Clicked Play", Toast.LENGTH_LONG).show();
            myPlayer.start();
            startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                    play);
        } else if (intent.getAction().equals(Constants.ACTION.NEXT_ACTION)) {
            Toast.makeText(this, "Clicked Next", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Constants.ACTION.PAUSE_ACTION)) {
            Toast.makeText(this, "Clicked Pause", Toast.LENGTH_LONG).show();
            myPlayer.pause();
            startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                    pause);
        }else if (intent.getAction().equals(
                Constants.ACTION.STOPFOREGROUND_ACTION)) {
            Toast.makeText(this, "Forground Service Stoping", Toast.LENGTH_LONG).show();
            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Used only in case of bound services.
        return null;
    }
}
