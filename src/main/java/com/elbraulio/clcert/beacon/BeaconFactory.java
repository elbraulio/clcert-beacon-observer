package com.elbraulio.clcert.beacon;

import com.elbraulio.clcert.beacon.impl.BeaconHttpRequest;
import com.elbraulio.clcert.beacon.impl.GsonPulseContainerBuilder;
import com.elbraulio.clcert.beacon.impl.HttpsBeaconObserver;

/**
 * Main factory to be used as SDK for the CLCERT Beacon service.
 */
public final class BeaconFactory {

    private BeaconFactory() {
        // not meant to be instantiated
    }

    /**
     * @return {@link BeaconObserver} to consume the CLCERT Beacon.
     */
    public static BeaconObserver observer() {
        return new HttpsBeaconObserver(
                new GsonPulseContainerBuilder(),
                BeaconHttpRequest::new
        );
    }
}
