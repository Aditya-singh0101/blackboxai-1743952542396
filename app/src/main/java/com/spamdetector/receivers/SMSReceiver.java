package com.spamdetector.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.spamdetector.services.NotificationService;
import com.spamdetector.utils.SpamDetector;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            if (pdus != null) {
                for (Object pdu : pdus) {
                    SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
                    String sender = sms.getOriginatingAddress();
                    String message = sms.getMessageBody();

                    if (SpamDetector.isSpam(message)) {
                        // Delete the spam message
                        deleteSMS(context, sms);
                        
                        // Notify user
                        NotificationService.notifySpamDetected(
                            context, 
                            sender, 
                            message
                        );
                    }
                }
            }
        }
    }

    private void deleteSMS(Context context, SmsMessage sms) {
        // TODO: Implement SMS deletion logic
        // This requires additional permissions and ContentResolver implementation
    }
}