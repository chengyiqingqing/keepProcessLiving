package com.sww.processproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //双进程防杀死。
        startService(new Intent(this,FirstService.class));
        startService(new Intent(this,SecondService.class));
        //JobService保活。  它执行了，但是start和stop未必会被调度。
        startService(new Intent(this,MyJobDaemonService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
