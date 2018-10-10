package org.mozilla.vrbrowser;

import android.support.annotation.NonNull;
import android.view.View;

import org.mozilla.geckoview.GeckoSession;

public interface WidgetManagerDelegate {
    interface UpdateListener {
        void onWidgetUpdate(Widget aWidget);
    }
    interface PermissionListener {
        void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);
    }
    interface FocusChangeListener {
        void onGlobalFocusChanged(View oldFocus, View newFocus);
    }
    int newWidgetHandle();
    void addWidget(@NonNull Widget aWidget);
    void updateWidget(@NonNull Widget aWidget);
    void removeWidget(@NonNull Widget aWidget);
    void startWidgetResize(@NonNull Widget aWidget);
    void finishWidgetResize(@NonNull Widget aWidget);
    void addUpdateListener(@NonNull UpdateListener aUpdateListener);
    void removeUpdateListener(@NonNull UpdateListener aUpdateListener);
    void pushBackHandler(@NonNull Runnable aRunnable);
    void popBackHandler(@NonNull Runnable aRunnable);
    void fadeOutWorld();
    void fadeInWorld();
    void setTrayVisible(boolean visible);
    void setBrowserSize(float targetWidth, float targetHeight);
    void keyboardDismissed();
    void updateEnvironment();
    void updatePointerColor();
    void addFocusChangeListener(@NonNull FocusChangeListener aListener);
    void removeFocusChangeListener(@NonNull FocusChangeListener aListener);
    void addPermissionListener(PermissionListener aListener);
    void removePermissionListener(PermissionListener aListener);
    boolean isPermissionGranted(@NonNull String permission);
    void requestPermission(@NonNull String uri, @NonNull String permission, GeckoSession.PermissionDelegate.Callback aCallback);
}
