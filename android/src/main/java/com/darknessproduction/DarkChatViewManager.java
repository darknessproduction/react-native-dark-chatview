package com.darknessproduction;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;
import android.util.Log;

import javax.annotation.Nullable;

class DarkChatViewManager extends ViewGroupManager {

    @Override
    public String getName() {
        return "DarkChatView";
    }

    public void onSizeChanged(int w, 
                int h, 
                int oldw, 
                int oldh){
        final String TAG = "MyActivity";
        Log.i(TAG, "MyClass.getView() — get item xxxxxxxxxxxxxxxxxxxxx ");
    }


    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        DarkChatView a = new DarkChatView(reactContext);
        return a;
    }

    @ReactProp(name = "refreshHeaderHeight")
    public void setRefreshHeaderHeight(DarkChatView view, float height) {
        height = PixelUtil.toPixelFromDIP(height);
        view.setRefreshHeaderHeight(height);
    }

    @ReactProp(name = "loadingFooterHeight")
    public void setLoadingFooterHeight(DarkChatView view, float height) {
        height = PixelUtil.toPixelFromDIP(height);
        view.setLoadingFooterHeight(height);
    }

    @ReactProp(name = "bounces")
    public void setBounces(DarkChatView view, boolean bounces) {
        view.setBounces(bounces);
    }

    @ReactProp(name = "scrollEnabled")
    public void setScrollEnabled(DarkChatView view, boolean scrollEnabled) {
        view.setScrollEnabled(scrollEnabled);
    }

    @ReactProp(name = "initialContentOffset")
    public void setInitContentOffset(DarkChatView view, ReadableMap offset) {
        float x = PixelUtil.toPixelFromDIP(offset.getDouble("x"));
        float y = PixelUtil.toPixelFromDIP(offset.getDouble("y"));
        view.setInitContentOffset(x, y);
    }

    @ReactProp(name = "allLoaded")
    public void setAllLoaded(DarkChatView view, boolean allLoaded) {
        view.setAllLoaded(allLoaded);
    }
    @ReactProp(name = "inverted")
    public void setInverted(DarkChatView view, boolean inverted) {
        view.setInverted(inverted);
    }

    @ReactProp(name = "directionalLockEnabled")
    public void setDirectionalLockEnabled(DarkChatView view, boolean directionalLockEnabled) {
        view.setDirectionalLockEnabled(directionalLockEnabled);
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onScroll", MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onScroll")))
                .put("onTouchBegin", MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onTouchBegin")))
                .put("onTouchEnd", MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onTouchEnd")))
                .put("onMomentumScrollBegin", MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onMomentumScrollBegin")))
                .put("onMomentumScrollEnd", MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onMomentumScrollEnd")))
                .build();
    }

    @Override
    public void receiveCommand(View root, int commandId, @Nullable ReadableArray args) {
        DarkChatView scrollView = (DarkChatView) root;
        switch (commandId) {
            case 10000:
                scrollView.endRefresh();
                break;
            case 10001:
                scrollView.endLoading();
                break;
            case 10002:
                scrollView.scrollTo(
                        PixelUtil.toPixelFromDIP(args.getDouble(0)),
                        PixelUtil.toPixelFromDIP(args.getDouble(1)),
                        args.getBoolean(2));
                break;
        }
    }
}
