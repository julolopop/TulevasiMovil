package com.example.julolopop.tulevasi.broadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.example.julolopop.tulevasi.ImpresionActivity;
import com.example.julolopop.tulevasi.TulevasiApplication;
import com.example.julolopop.tulevasi.ui.login.MainActivity;

/**
 * Created by Julolopop on 24/02/2018.
 */

public class TulevasiBroadcast extends BroadcastReceiver {
    public static final int ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        Intent newIntent = new Intent(context, ImpresionActivity.class);
        newIntent.putExtras(bundle);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, ID,newIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Notification");
        builder.setContentTitle("Ticked");
        builder.setSmallIcon(android.R.drawable.alert_dark_frame);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), android.R.drawable.alert_dark_frame));
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(ID, builder.build());


    }
}
