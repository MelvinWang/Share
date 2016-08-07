package com.melvin.share.Utils;

import com.hwangjr.rxbus.Bus;

public final class RxCarBus {
    private static Bus mBus;

    public synchronized static Bus get() {
        if (mBus == null) {
            mBus = new Bus();
        }
        return mBus;
    }
}
