# Android_ThreadHelper
A tiny android thread tool.

这个项目只要为了方便大家开发,因为也不知道加什么功能好,所以非常欢迎大家给我提要求,我会尽快加上

当你在UI线程想执行耗时操作,直接用`ThreadHelper.runOnAsyncThread(your runnable)` 或者`ThreadHelper.runOnBackgroundThread(your runnable)`

当你在非UI线程想对UI进行操作可以执行`ThreadHelper.runOnUiThread(your runnable)`,两者可以嵌套
