# SimpleFeatureTutorialOverlayView

Overlay view to display feature turorials with PopupWindow at Decor view.

## Usage

### 1. Initialize the library on `Application#onCreate()`

Initialize the library class of `FeatureTutorialViewManager` on your `Application#onCreate()`.  
Do not forget to declare your application class name on `AndroidManifest.xml`.

```java

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FeatureTutorialViewManager.initialize(this);
    }

    @Override
    public void onTerminate() {
        FeatureTutorialViewManager.destroy();
        super.onTerminate();
    }
}
```

### 2. Configure tutorial overlay with `TutorialOverlayHelper`

```java
public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        new TutorialOverlayHelper(this, "sample")
                .setBackgroundColor(R.color.popup_background)
                .setFocusable(true)
                .setTouchable(true)
                .setOutsideTouchable(true)
                .setContentView(R.layout.popup_view)
                .show(this, 500L);
    }
}
```

That's it!
The tutorial overlay will be displayed under DecorView of your application.

## Download

### Gradle



## License

This library is licensed under Apache License v2.

```
Copyright (C) 2014 nohana, Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
```
