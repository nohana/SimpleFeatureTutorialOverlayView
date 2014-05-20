/*
 * Copyright (C) 2014 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package jp.co.nohana.widget.tutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Overlay view configuration helper.
 *
 * @see android.widget.PopupWindow
 * @author KeithYokoma
 * @since 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("unused") // public APIs
public class TutorialOverlayHelper {
    private final Context mContext;
    private final SimpleFeatureTutorialOverlayView mTarget;

    /**
     * Initialize helper within the context.
     * @param context the context.
     * @param viewName the view name that is unique among the application.
     */
    public TutorialOverlayHelper(@NonNull Context context, @NonNull String viewName) {
        mContext = context;
        mTarget = new SimpleFeatureTutorialOverlayView(context, viewName);
    }

    /**
     * Set content view with the specified layout resource.
     * @see android.widget.PopupWindow#setContentView(android.view.View)
     * @param resource the layout resource.
     * @return the helper.
     */
    public TutorialOverlayHelper setContentView(int resource) {
        return setContentView(LayoutInflater.from(mContext).inflate(resource, null));
    }

    /**
     * Set the content view.
     * @see android.widget.PopupWindow#setContentView(android.view.View)
     * @param view the content view.
     * @return the helper.
     */
    public TutorialOverlayHelper setContentView(View view) {
        mTarget.setContentView(view);
        return this;
    }

    /**
     * Set whether the popup content is touchable or not.
     * @see android.widget.PopupWindow#setTouchable(boolean)
     * @param touchable true if touchable, false otherwise.
     * @return the helper.
     */
    public TutorialOverlayHelper setTouchable(boolean touchable) {
        mTarget.setTouchable(touchable);
        return this;
    }

    /**
     * Set whether the popup outside region is touchable or not.
     * @see android.widget.PopupWindow#setOutsideTouchable(boolean)
     * @param touchable true if touchable, false otherwise.
     * @return the helper.
     */
    public TutorialOverlayHelper setOutsideTouchable(boolean touchable) {
        mTarget.setOutsideTouchable(touchable);
        return this;
    }

    /**
     * Set whether the popup content is focusable or not.
     * @see android.widget.PopupWindow#setFocusable(boolean)
     * @param focusable true if focusable.
     * @return the helper.
     */
    public TutorialOverlayHelper setFocusable(boolean focusable) {
        mTarget.setFocusable(focusable);
        return this;
    }

    /**
     * Set background as {@link android.graphics.drawable.ColorDrawable}.
     * @see android.widget.PopupWindow#setBackgroundDrawable(android.graphics.drawable.Drawable)
     * @param colorResource the resource of the color.
     * @return the helper.
     */
    public TutorialOverlayHelper setBackgroundColorResource(int colorResource) {
        return setBackgroundDrawable(new ColorDrawable(mContext.getResources().getColor(colorResource)));
    }

    /**
     * Set the {@link android.graphics.drawable.Drawable} as the popup background.
     * @see android.widget.PopupWindow#setBackgroundDrawable(android.graphics.drawable.Drawable)
     * @param drawable the drawable.
     * @return the helper.
     */
    public TutorialOverlayHelper setBackgroundDrawable(Drawable drawable) {
        mTarget.setBackgroundDrawable(drawable);
        return this;
    }

    /**
     * Set the transition animation for the {@link android.widget.PopupWindow}.
     * @see android.widget.PopupWindow#setAnimationStyle(int)
     * @param style the animation style.
     * @return the helper.
     */
    public TutorialOverlayHelper setTransitionAnimationStyle(int style) {
        mTarget.setAnimationStyle(style);
        return this;
    }

    /**
     * Show on the specified activity with the specified delay time in milliseconds.
     * @param activity the host {@link android.app.Activity} of the {@link android.widget.PopupWindow}.
     * @param delayInMillis delay time in milliseconds.
     * @return the {@link android.widget.PopupWindow}
     */
    public SimpleFeatureTutorialOverlayView show(Activity activity, long delayInMillis) {
        if (mTarget.getContentView() == null) {
            throw new IllegalStateException("cannot overlay without view.");
        }

        mTarget.showOn(activity, delayInMillis);
        return mTarget;
    }
}
