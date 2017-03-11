package com.chaoqun.testdemo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/3/11.
 */

public class DialogReceiver extends BroadcastReceiver {
    public static final String ACTION_VOICHELPER = "com.android.action.DDT_VOICHELPER";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(ACTION_VOICHELPER)){
            Intent intent2 = new Intent();
            ComponentName componentName = new ComponentName("com.chaoqun.testdemo","com.chaoqun.testdemo.DialogActivity");
            intent2.setComponent(componentName);
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }
}
