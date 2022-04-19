package com.elbraulio.clcert.beacon;

import java.io.IOException;
import java.time.Instant;

/**
 * Observes pulses from the CLCERT Beacon service.
 * As this consumes an HTTP service, it may throw and {@link IOException}.
 */
public interface BeaconObserver {

    /**
     * @return latest {@link Pulse}.
     * @throws IOException when connection fails.
     */
    PulseContainer lastPulse() throws IOException;

    /**
     * @param instant time in UTC.
     * @return {@link Pulse} emitted before a given time.
     * @throws IOException when connection fails.
     */
    PulseContainer pulseBefore(Instant instant) throws IOException;

    /**
     * @param instant time in UTC.
     * @return {@link Pulse} emitted after a given time.
     * @throws IOException when connection fails.
     */
    PulseContainer pulseAfter(Instant instant) throws IOException;

    /**
     * @param instant time in UTC.
     * @return {@link Pulse} emitted at a given time or near.
     * @throws IOException when connection fails.
     */
    PulseContainer pulseNear(Instant instant) throws IOException;
}
