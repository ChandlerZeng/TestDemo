package com.chaoqun.testdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAnim,btnBroad;
    private static final String DIALOG_ANIM_ACTION = "android.intent.action.Dialog_Animation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnim = (Button)findViewById(R.id.btn_anim);
        btnBroad = (Button)findViewById(R.id.btn_broad);
        btnAnim.setOnClickListener(this);
        btnBroad.setOnClickListener(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(DIALOG_ANIM_ACTION);
        registerReceiver(myReceiver, filter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_anim:
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
                break;
            case R.id.btn_broad:
                sendBroadcast(new Intent(DIALOG_ANIM_ACTION));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            Toast.makeText(context, "myReceiver receive", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,DialogActivity.class));
        }

    };
}
