package com.os.threadhelper.library;

import android.os.Looper;

/**
 * Created by whiMaggot on 2017/5/20.
 */

public class ThreadHelper {
    public static void runOnUiThread(Runnable run){
        if(Looper.myLooper() == Looper.getMainLooper()){
            run.run();
        }
        else{
            Handlers.sUIHandler.post(run);
        }
    }

    public static void runOnUiThread(Runnable run, long delayMillis){
        Handlers.sUIHandler.postDelayed(run, delayMillis);
    }

    public static void runOnBackgroundThread(Runnable run){
        if(Looper.myLooper() == Handlers.sBackgroundHandler.getLooper()){
            run.run();
        }
        else{
            Handlers.sBackgroundHandler.post(run);
        }
    }

    public static void runOnBackgroundThread(Runnable run, long delayMillis){
        Handlers.sBackgroundHandler.postDelayed(run, delayMillis);
    }

    public static void runOnAsyncThread(final Runnable runnable){
        AsyncExecutor.create().execute(new AsyncExecutor.RunnableEx() {
            @Override
            public void run() throws Exception {
                runnable.run();
            }
        });
    }

    public static void runOnAsyncThread(final Runnable runnable, long delayMillis){
        Handlers.sUIHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AsyncExecutor.create().execute(new AsyncExecutor.RunnableEx() {
                    @Override
                    public void run() throws Exception {
                        runnable.run();
                    }
                });
            }
        }, delayMillis);

    }
}
