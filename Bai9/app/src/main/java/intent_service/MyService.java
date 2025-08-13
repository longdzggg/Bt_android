package intent_service;



import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.bai9.MainActivity;
import com.example.bai9.R;

public class MyService extends Service {

    private static final String CHANNEL_ID = "music_channel_id";
    private static final int NOTI_ID = 1;

    private MediaPlayer media;

    @Override
    public void onCreate() {
        super.onCreate();
        // Tạo MediaPlayer từ file res/raw
        media = MediaPlayer.create(this, R.raw.tinhme); // đổi đúng tên mp3 của bạn
        if (media != null) {
            media.setLooping(true); // phát lặp vô hạn như yêu cầu bài
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Hiển thị notification & đưa Service lên foreground (Android O+ bắt buộc)
        startForegroundWithNotification();

        if (media != null && !media.isPlaying()) {
            media.start();
        }
        // Giữ service chạy nếu hệ thống kill, sau đó tạo lại
        return START_STICKY;
    }

    private void startForegroundWithNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel ch = new NotificationChannel(
                    CHANNEL_ID, "Music Playback", NotificationManager.IMPORTANCE_LOW);
            if (nm.getNotificationChannel(CHANNEL_ID) == null) {
                nm.createNotificationChannel(ch);
            }
        }

        // Bấm vào thông báo sẽ quay lại MainActivity
        Intent openApp = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(
                this, 0, openApp,
                Build.VERSION.SDK_INT >= 23
                        ? PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                        : PendingIntent.FLAG_UPDATE_CURRENT
        );

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_play_arrow_24) // dùng icon bất kỳ bạn có
                .setContentTitle("Đang phát nhạc")
                .setContentText("Chạm để quay lại ứng dụng")
                .setContentIntent(pi)
                .setOngoing(true)
                .build();

        startForeground(NOTI_ID, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (media != null) {
            if (media.isPlaying()) media.stop();
            media.release();
            media = null;
        }
        // Ẩn notification khi dừng service
        stopForeground(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // Bài này dùng Started Service, không bind
        return null;
    }
}
