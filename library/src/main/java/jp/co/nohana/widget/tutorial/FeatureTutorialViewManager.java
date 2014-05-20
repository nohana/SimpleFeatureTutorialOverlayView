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

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Feature tutorial view history logging.
 * @author keishin.yokomaku
 * @since 2014/05/20
 */
public class FeatureTutorialViewManager {
    public static final String TAG = FeatureTutorialViewManager.class.getSimpleName();
    private static volatile FeatureTutorialViewManager sInstance;
    private static final String PREF_NAME = "feature_tutorial_view_history";
    private static final boolean DEFAULT_STATUS = false;
    private final SharedPreferences mPreferences;

    public FeatureTutorialViewManager(Application application) {
        mPreferences = application.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initialize(Application application) {
        if (sInstance != null) {
            Log.v(TAG, "already initialized");
            return;
        }
        sInstance = new FeatureTutorialViewManager(application);
    }

    public static synchronized FeatureTutorialViewManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(TAG + " is not initialized yet.");
        }
        return sInstance;
    }

    public static synchronized void destroy() {
        sInstance = null;
    }

    public boolean hasSeenBefore(TutorialView view) {
        return mPreferences.getBoolean(view.getViewName(), DEFAULT_STATUS);
    }

    public void setHasSeenBefore(TutorialView view, boolean seen) {
        mPreferences.edit().putBoolean(view.getViewName(), seen).apply();
    }
}
