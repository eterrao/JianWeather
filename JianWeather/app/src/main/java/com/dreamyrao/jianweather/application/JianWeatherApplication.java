package com.dreamyrao.jianweather.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by raomengyang on 1/18/16.
 */
public class JianWeatherApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static Context getContext() {
        return context;
    }
}
