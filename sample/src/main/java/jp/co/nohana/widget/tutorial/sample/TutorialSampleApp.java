package jp.co.nohana.widget.tutorial.sample;

import android.app.Application;

import jp.co.nohana.widget.tutorial.FeatureTutorialViewManager;

/**
 * @author keishin.yokomaku
 * @since 2014/05/20
 */
public class TutorialSampleApp extends Application {
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
