package com.example.sendingandrecievingmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import kotlinx.coroutines.channels.BroadcastChannel;

public class smsreciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
       Object[] smsobj=(Object[]) bundle.get("pdus");
       for(Object obj:smsobj){
           SmsMessage message=SmsMessage.createFromPdu((byte[]) obj);
           String Mobno=message.getDisplayOriginatingAddress();
         String msg=  message.getDisplayMessageBody();
           Log.d("Msgdetail","Mobile number"+Mobno+"Msg"+msg);
         SmsManager smsManager=  SmsManager.getDefault();
         smsManager.sendTextMessage("+978y3y4wy",null,"hwllo",null,null);
       }

    }
}
