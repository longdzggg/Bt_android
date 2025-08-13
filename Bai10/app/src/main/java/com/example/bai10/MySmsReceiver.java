package com.example.bai10;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.util.Log;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!"android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) return;

        Bundle bundle = intent.getExtras();
        if (bundle == null) return;

        Object[] pdus = (Object[]) bundle.get("pdus");
        String format = bundle.getString("format");
        if (pdus == null || pdus.length == 0) return;

        StringBuilder message = new StringBuilder();

        for (Object pdu : pdus) {
            SmsMessage sms;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                sms = SmsMessage.createFromPdu((byte[]) pdu, format); // API 23+
            } else {
                sms = SmsMessage.createFromPdu((byte[]) pdu);         // cũ hơn
            }
            String body = sms.getMessageBody();
            String address = sms.getOriginatingAddress();
            message.append("Có 1 tin nhắn từ ")
                    .append(address)
                    .append("\n")
                    .append(body)
                    .append(" vừa gửi đến\n");
        }

        // Hiển thị
        Toast.makeText(context, message.toString(), Toast.LENGTH_LONG).show();
        Log.d("MySmsReceiver", message.toString());
    }
}
