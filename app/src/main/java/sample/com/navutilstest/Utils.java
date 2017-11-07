package sample.com.navutilstest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/**
 * Created by Anukool Srivastav on 06/11/17.
 */

public class Utils {

    public static void addNotification(Context context) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent activityIntent = new Intent(context, ThirdActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ThirdActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(activityIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setAutoCancel(true)
                .setContentTitle("NavUtils").setContentText("Launch Child activity")
                .setContentIntent(pendingIntent).build();

        notificationManager.notify(1234, notification);
    }
}
