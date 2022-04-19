package com.elbraulio.clcert.beacon.dto;

import com.elbraulio.clcert.beacon.Pulse;
import com.elbraulio.clcert.beacon.PulseContainer;

public final class PulseContainerDto implements PulseContainer {

    private final PulseDto pulse;

    public PulseContainerDto(final PulseDto pulse) {
        this.pulse = pulse;
    }

    @Override
    public Pulse getPulse() {
        return pulse;
    }

    @Override
    public String toString() {
        return "PulseContainerDto{" +
                "pulse=" + pulse +
                '}';
    }
}
