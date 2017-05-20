package com.os.threadhelper.library;

import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by whiMaggot on 2017/5/20.
 */

public class AsyncExecutor {
    public static class Builder {
        private Executor threadPool;

        private Builder() {
        }

        public Builder threadPool(Executor threadPool) {
            this.threadPool = threadPool;
            return this;
        }


        public AsyncExecutor build() {
            if (threadPool == null) {
                threadPool = Executors.newCachedThreadPool();
            }
            return new AsyncExecutor(threadPool);
        }

    }

    /** Like {@link Runnable}, but the run method may throw an exception. */
    public interface RunnableEx {
        void run() throws Exception;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    private final Executor threadPool;

    private AsyncExecutor(Executor threadPool) {
        this.threadPool = threadPool;

    }

    /** Posts an failure event if the given {@link RunnableEx} throws an Exception. */
    public void execute(final RunnableEx runnable) {
        Log.d("AsyncExecutor",threadPool.toString());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Log.e("AsyncExecutor","on AsyncExecutor run fail,detail is "+e.toString());
                }
            }
        });
    }
}
