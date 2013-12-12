/* //device/java/android/android/view/WindowSession.aidl
 **
 ** Copyright 2006, The Android Open Source Project
 **
 ** Licensed under the Apache License, Version 2.0 (the "License"); 
 ** you may not use this file except in compliance with the License. 
 ** You may obtain a copy of the License at 
 **
 **     http://www.apache.org/licenses/LICENSE-2.0 
 **
 ** Unless required by applicable law or agreed to in writing, software 
 ** distributed under the License is distributed on an "AS IS" BASIS, 
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 ** See the License for the specific language governing permissions and 
 ** limitations under the License.
 */

package android.view;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.IBinder;
import android.view.InputChannel;
import android.view.Window;
import android.view.WindowManager;
import android.view.Surface;

/**
 * System private per-application interface to the window manager. {@hide
 * }
 */
public class WindowSession {
    int add(Window window, WindowManager.LayoutParams attrs,
            int viewVisibility, Rect outContentInsets,
            InputChannel outInputChannel) {
        return 0;
    }

    int addWithoutInputChannel(Window window, WindowManager.LayoutParams attrs,
            int viewVisibility, Rect outContentInsets) {
        return 0;
    }

    void remove(Window window) {

    }

    /**
     * Change the parameters of a window. You supply the new parameters, it
     * returns the new frame of the window on screen (the position should be
     * ignored) and surface of the window. The surface will be invalid if the
     * window is currently hidden, else you can use it to draw the window's
     * contents.
     * 
     * @param window The window being modified.
     * @param attrs If non-null, new attributes to apply to the window.
     * @param requestedWidth The width the window wants to be.
     * @param requestedHeight The height the window wants to be.
     * @param viewVisibility Window root view's visibility.
     * @param insetsPending Set to true if the client will be later giving
     *            internal insets; as a result, the window will not impact other
     *            window layouts until the insets are given.
     * @param outFrame Rect in which is placed the new position/size on screen.
     * @param outContentInsets Rect in which is placed the offsets from
     *            <var>outFrame</var> in which the content of the window should
     *            be placed. This can be used to modify the window layout to
     *            ensure its contents are visible to the user, taking into
     *            account system windows like the status bar or a soft keyboard.
     * @param outVisibleInsets Rect in which is placed the offsets from
     *            <var>outFrame</var> in which the window is actually completely
     *            visible to the user. This can be used to temporarily scroll
     *            the window's contents to make sure the user can see it. This
     *            is different than <var>outContentInsets</var> in that these
     *            insets change transiently, so complex relayout of the window
     *            should not happen based on them.
     * @param outConfiguration New configuration of window, if it is now
     *            becoming visible and the global configuration has changed
     *            since it was last displayed.
     * @param outSurface Object in which is placed the new display surface.
     * @return int Result flags: {@link WindowManagerImpl#RELAYOUT_SHOW_FOCUS},
     *         {@link WindowManagerImpl#RELAYOUT_FIRST_TIME}.
     */
    int relayout(Window window, WindowManager.LayoutParams attrs,
            int requestedWidth, int requestedHeight, int viewVisibility,
            boolean insetsPending, Rect outFrame, Rect outContentInsets,
            Rect outVisibleInsets, Configuration outConfig,
            Surface outSurface) {
        return 0;
    }

    /**
     * Give the window manager a hint of the part of the window that is
     * completely transparent, allowing it to work with the surface flinger to
     * optimize compositing of this part of the window.
     */
    void setTransparentRegion(Window window, Region region) {
    }

    /**
     * Tell the window manager about the content and visible insets of the given
     * window, which can be used to adjust the <var>outContentInsets</var> and
     * <var>outVisibleInsets</var> values returned by {@link #relayout
     * relayout()} for windows behind this one.
     * 
     * @param touchableInsets Controls which part of the window inside of its
     *            frame can receive pointer events, as defined by
     *            {@link android.view.ViewTreeObserver.InternalInsetsInfo}.
     */
    void setInsets(Window window, int touchableInsets, Rect contentInsets,
            Rect visibleInsets) {
    }

    /**
     * Return the current display size in which the window is being laid out,
     * accounting for screen decorations around it.
     */
    void getDisplayFrame(Window window, Rect outDisplayFrame) {
    }

    void finishDrawing(Window window) {
    }

    void setInTouchMode(boolean showFocus) {
    }

    boolean getInTouchMode() {
        return true;
    }

    boolean performHapticFeedback(Window window, int effectId, boolean always) {
        return true;
    }

    /**
     * For windows with the wallpaper behind them, and the wallpaper is larger
     * than the screen, set the offset within the screen. For multi screen
     * launcher type applications, xstep and ystep indicate how big the
     * increment is from one screen to another.
     */
    void setWallpaperPosition(IBinder windowToken, float x, float y, float xstep, float ystep) {
    }

    void wallpaperOffsetsComplete(IBinder window) {
    }

    Bundle sendWallpaperCommand(IBinder window, String action, int x, int y,
            int z, Bundle extras, boolean sync) {
        return null;
    }

    void wallpaperCommandComplete(IBinder window, Bundle result) {
    }
}
