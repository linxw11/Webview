package com.example.linxw.webview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.example.linxw.webview.R;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Integer time = 2000;    //设置等待时间，单位为毫秒
        Handler handler = new Handler();
        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                new FinestWebView.Builder(LaunchActivity.this)
                        .webViewAllowContentAccess(true)
                        .webViewDatabaseEnabled(true)
                        .webViewDomStorageEnabled(true)
                        .webViewAppCacheEnabled(true)
                        .webViewSaveFormData(true)
                        .webViewNeedInitialFocus(true)
                        .webViewLoadWithOverviewMode(true).show("https://www.baidu.com");
                LaunchActivity.this.finish();
            }
        }, time);
    }

}
