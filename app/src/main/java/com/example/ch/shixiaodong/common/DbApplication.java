package com.example.ch.shixiaodong.common;

import android.app.Application;

/**
 * Created by 76165
 * on 2019/6/13
 */
public class DbApplication extends Application {
    private static DbApplication dbApplication;

    public static DbApplication getDbApplication() {
        return dbApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbApplication = this;
    }
}
