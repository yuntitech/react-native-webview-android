package com.burnweb.rnwebview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ProgressEvent extends Event<ProgressEvent> {

    public static final String EVENT_NAME = "progressEvent";
    private final int newProgress;

    public ProgressEvent(int viewId, int newProgress) {
        super(viewId);
        this.newProgress = newProgress;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("newProgress", this.newProgress);
        return eventData;
    }
}
