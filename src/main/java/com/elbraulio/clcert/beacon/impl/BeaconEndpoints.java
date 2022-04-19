package com.elbraulio.clcert.beacon.impl;

import java.net.URI;

import static java.lang.String.format;

/**
 * Endpoints to consume the service. See:
 * https://random.uchile.cl/using/#desarrolladores
 */
public final class BeaconEndpoints {

    private BeaconEndpoints() {
        // no need of an instance
    }

    public static URI lastPulse() {
        return URI.create(BeaconEndpointTemplates.PULSE_LAST.templateUrl());
    }

    public static URI pulseBefore(final Long time) {
        return URI.create(format(BeaconEndpointTemplates.PULSE_BEFORE.templateUrl(), time));
    }

    public static URI pulseAfter(final Long time) {
        return URI.create(format(BeaconEndpointTemplates.PULSE_AFTER.templateUrl(), time));
    }

    public static URI pulseNear(final Long time) {
        return URI.create(format(BeaconEndpointTemplates.PULSE_NEAR.templateUrl(), time));
    }

    public static URI pulseFromChain(final Long chainIndex, final Long pulseIndex) {
        return URI.create(format(BeaconEndpointTemplates.PULSE_FROM_CHAIN.templateUrl(), chainIndex, pulseIndex));
    }

    private enum BeaconEndpointTemplates {

        PULSE_LAST("https://random.uchile.cl/beacon/2.0/pulse/last"),
        PULSE_BEFORE("https://random.uchile.cl/beacon/2.0/pulse/time/previous/%s"),
        PULSE_AFTER("https://random.uchile.cl/beacon/2.0/pulse/time/next/%s"),
        PULSE_NEAR("https://random.uchile.cl/beacon/2.0/pulse/time/%s"),
        PULSE_FROM_CHAIN("https://random.uchile.cl/beacon/2.0/chain/%s/pulse/%s");


        private final String templateUrl;

        BeaconEndpointTemplates(final String templateUrl) {
            this.templateUrl = templateUrl;
        }

        public String templateUrl() {
            return templateUrl;
        }
    }
}
