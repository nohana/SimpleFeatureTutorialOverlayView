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
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * @author keishin.yokomaku
 * @since 2014/05/20
 */
@SuppressWarnings("unused") // public APIs
public class SimpleFeatureTutorialOverlayView extends PopupWindow implements TutorialView, View.OnTouchListener, PopupWindow.OnDismissListener {
    private final String mViewName;
    private final FeatureTutorialViewManager mManager;

    public SimpleFeatureTutorialOverlayView(Context context, @NonNull String viewName) {
        super(context);
        mViewName = viewName;
        mManager = FeatureTutorialViewManager.getInstance();
        setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setTouchInterceptor(this);
        setOnDismissListener(this);
    }

    @Override
    public String getViewName() {
        return mViewName;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override
    public void onDismiss() {
        mManager.setHasSeenBefore(this, true);
    }

    public void forceShowOn(final Activity activity) {
        // attach this popup on the view root of the activity
        View container = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        showAtLocation(container, Gravity.NO_GRAVITY, 0, 0);
    }

    protected void showOn(final Activity activity, long delayInMillis) {
        if (mManager.hasSeenBefore(this)) {
            return;  // do not attach the popup
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                forceShowOn(activity);
            }
        }, delayInMillis);
    }
}
