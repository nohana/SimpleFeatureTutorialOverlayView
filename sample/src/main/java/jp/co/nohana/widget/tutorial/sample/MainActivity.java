package jp.co.nohana.widget.tutorial.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import jp.co.nohana.widget.tutorial.SimpleFeatureTutorialOverlayView;
import jp.co.nohana.widget.tutorial.TutorialOverlayHelper;

public class MainActivity extends ActionBarActivity {
    private SimpleFeatureTutorialOverlayView mTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTutorial = new TutorialOverlayHelper(this, "sample")
                .setBackgroundColor(R.color.popup_background)
                .setFocusable(true)
                .setTouchable(true)
                .setOutsideTouchable(true)
                .setContentView(R.layout.popup_view)
                .show(this, 500L);
    }

    @Override
    protected void onDestroy() {
        mTutorial.dismiss();
        super.onDestroy();
    }

    public void onShowTutorial(View view) {
        mTutorial.forceShowOn(this);
    }
}
