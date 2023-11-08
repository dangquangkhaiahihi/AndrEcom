package com.allandroidprojects.ecomsample.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.allandroidprojects.ecomsample.R;
import com.allandroidprojects.ecomsample.ui.activity.CartListActivity;
import com.allandroidprojects.ecomsample.ui.activity.MainActivity;

public class NotificationHelper {

    private static final int NOTIFICATION_ID = 1;

    public static void showNotification(Context context, String title, String content) {
        Intent intent = new Intent(context, CartListActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_shopping_cart_black_24dp)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
