import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class firebasemsgservice extends  FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("refreshed token",token);

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        if (message.getNotification() != null) {
            pushnotification(
                    message.getNotification().getTitle(),
                    message.getNotification().getBody()
            );

        }
    }

    private void pushnotification(String title, String message) {

        



    }
}
