package com.example.bai10;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_SMS = 1001;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        findViewById(R.id.btnRequest).setOnClickListener(v -> ensureSmsPermissions());

        // Hỏi quyền ngay khi mở app cho tiện
        ensureSmsPermissions();
    }

    private void ensureSmsPermissions() {
        if (hasSmsPermissions()) {
            tvStatus.setText("Đã có quyền. Hãy gửi 1 SMS đến máy này để thử.");
            return;
        }
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS},
                REQ_SMS
        );
    }

    private boolean hasSmsPermissions() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_SMS) {
            if (hasSmsPermissions()) {
                tvStatus.setText("Đã có quyền. Hãy gửi 1 SMS đến máy này để thử.");
            } else {
                tvStatus.setText("Chưa được cấp quyền RECEIVE_SMS/READ_SMS.");
                Toast.makeText(this, "Cần cấp quyền để lắng nghe SMS.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
