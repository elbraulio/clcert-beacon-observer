package com.elbraulio.clcert.beacon.impl;

import org.junit.Test;

import java.io.IOException;

public class GsonPulseContainerBuilderTest {

    private final PulseContainerBuilder builder = new GsonPulseContainerBuilder();

    @Test(expected = RuntimeException.class)
    public void fromEntity_entity_is_required() throws IOException {
        builder.fromEntity(null);
    }
}
