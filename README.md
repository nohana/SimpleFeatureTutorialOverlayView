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

### 2. Configure overlay tutorial popup with `TutorialOverlayHelper`

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
