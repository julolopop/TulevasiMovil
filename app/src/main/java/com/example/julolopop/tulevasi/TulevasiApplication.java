package com.example.julolopop.tulevasi;

import android.app.Application;
import android.content.Context;

/**
 * Created by Julolopop on 24/02/2018.
 */

public class TulevasiApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
