package com.sww.processproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
//        startServices();
        startOnePixActivity();
//        finish();
    }

    private void startServices(){
        //双进程防杀死。
        startService(new Intent(mContext,FirstService.class));
        startService(new Intent(mContext,SecondService.class));
        //JobService保活。  它执行了，但是start和stop未必会被调度。
        startService(new Intent(mContext,MyJobDaemonService.class));
    }

    private void startOnePixActivity(){
        OnePixActivity.startOnePixActivity(mContext);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
