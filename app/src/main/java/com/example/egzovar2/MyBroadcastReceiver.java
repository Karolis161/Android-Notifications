package com.example.egzovar2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

    public static MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        mp = MediaPlayer.create(context, uri);
        mp.start();
        Toast.makeText(context, "Numatytas laikas atejo", Toast.LENGTH_SHORT).show();
    }
}