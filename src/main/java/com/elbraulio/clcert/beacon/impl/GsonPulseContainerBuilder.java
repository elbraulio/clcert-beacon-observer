package com.elbraulio.clcert.beacon.impl;

import com.elbraulio.clcert.beacon.PulseContainer;
import com.elbraulio.clcert.beacon.dto.PulseContainerDto;
import com.elbraulio.clcert.beacon.exception.ClcertBeaconObserverException;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static java.util.Objects.isNull;

/**
 * {@link PulseContainerBuilder} that uses Gson to parse the response.
 */
public final class GsonPulseContainerBuilder implements PulseContainerBuilder {

    private final Gson gson;

    public GsonPulseContainerBuilder() {
        this.gson = new Gson();
    }

    @Override
    public PulseContainer fromEntity(final HttpEntity entity) throws IOException {
        if (isNull(entity)) {
            throw new ClcertBeaconObserverException("null response from the server");
        }
        return gson.fromJson(EntityUtils.toString(entity), PulseContainerDto.class);
    }
}
