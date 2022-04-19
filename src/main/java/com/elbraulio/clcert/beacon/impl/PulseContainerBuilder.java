package com.elbraulio.clcert.beacon.impl;

import com.elbraulio.clcert.beacon.PulseContainer;
import org.apache.http.HttpEntity;

import java.io.IOException;

/**
 * Build up the {@link PulseContainer}.
 */
public interface PulseContainerBuilder {

    /**
     * @param entity {@link HttpEntity} contained in the service's response.
     * @return parsed {@link PulseContainer}.
     * @throws IOException when connection fails.
     */
    PulseContainer fromEntity(HttpEntity entity) throws IOException;
}
