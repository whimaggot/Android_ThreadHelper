# Android_ThreadHelper
A tiny android thread tool.

这个项目只要为了方便大家开发,因为也不知道加什么功能好,所以非常欢迎大家给我提issue,我会尽快加上

#使用示例
当你在UI线程想执行耗时操作,直接用`ThreadHelper.runOnAsyncThread(your runnable);` 或者`ThreadHelper.runOnBackgroundThread(your runnable);`

当你在非UI线程想对UI进行操作可以执行`ThreadHelper.runOnUiThread(your runnable);`

两者可以嵌套,示例:

```
	...
	ThreadHelper.runOnAsyncThread(new Runnable() {
                    @Override
                    public void run() {
                        ThreadHelper.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                               ((TextView)MainActivity.this.findViewById(R.id.text)).setText("change text on UI Thread");
                            }
                        });
                    }
    });
```

也可以进行延时,例如在非UI线程延时一秒执行:`ThreadHelper.runOnAsyncThread(your runnable,1000);`

#引入项目
根目录的build.gradle配置
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

module的build.gradle配置
```
dependencies {
	        compile 'com.github.whimaggot:Android_ThreadHelper:1.0'
	}
```



