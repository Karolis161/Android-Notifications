package com.example.egzovar2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                startAlert();
                showNotification();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startAlert() {
        int timeInSec = 2;
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (timeInSec * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set to after " + 2 + " seconds", Toast.LENGTH_SHORT).show();

        NotificationChannel channel = new NotificationChannel("1", "name", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("aaa");
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        Intent k = new Intent(this, MainActivity2.class);
        startActivity(k);
    }

    public void showNotification() {
        Notification.Builder notif;
        int num = 1;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notif = new Notification.Builder(this, "1");
        } else {
            notif = new Notification.Builder(this);
        }

        notif.setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notification alert")
                .setContentText("Numatytas laikas 13:00 atejo");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,
                num, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        notif.setContentIntent(pi);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(num, notif.build());
    }
}