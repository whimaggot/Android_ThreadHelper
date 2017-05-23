package com.os.threadhelper.library;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by whiMaggot on 2017/5/20.
 */

public class Handlers {
    static final Handler sUIHandler = new Handler(Looper.getMainLooper());
    static final Handler sBackgroundHandler = BackgroundHandlerThread.getInstance().getHandler();

}
