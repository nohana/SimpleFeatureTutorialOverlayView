package jp.co.nohana.widget.tutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author keishin.yokomaku
 * @since 2014/05/20
 */
@SuppressWarnings("unused") // public APIs
public class TutorialOverlayHelper {
    private final Context mContext;
    private final SimpleFeatureTutorialOverlayView mTarget;

    public TutorialOverlayHelper(@NonNull Context context, @NonNull String viewName) {
        mContext = context;
        mTarget = new SimpleFeatureTutorialOverlayView(context, viewName);
    }

    public TutorialOverlayHelper setContentView(int resource) {
        return setContentView(LayoutInflater.from(mContext).inflate(resource, null));
    }

    public TutorialOverlayHelper setContentView(View view) {
        mTarget.setContentView(view);
        return this;
    }

    public TutorialOverlayHelper setTouchable(boolean touchable) {
        mTarget.setTouchable(touchable);
        return this;
    }

    public TutorialOverlayHelper setOutsideTouchable(boolean touchable) {
        mTarget.setOutsideTouchable(touchable);
        return this;
    }

    public TutorialOverlayHelper setFocusable(boolean focusable) {
        mTarget.setFocusable(focusable);
        return this;
    }

    public TutorialOverlayHelper setBackgroundColor(int colorResource) {
        return setBackgroundDrawable(new ColorDrawable(mContext.getResources().getColor(colorResource)));
    }

    public TutorialOverlayHelper setBackgroundDrawable(Drawable drawable) {
        mTarget.setBackgroundDrawable(drawable);
        return this;
    }

    public TutorialOverlayHelper setTransitionAnimationStyle(int style) {
        mTarget.setAnimationStyle(style);
        return this;
    }

    public SimpleFeatureTutorialOverlayView show(Activity activity, long delayInMillis) {
        if (mTarget.getContentView() == null) {
            throw new IllegalStateException("cannot overlay without view.");
        }

        mTarget.showOn(activity, delayInMillis);
        return mTarget;
    }
}
