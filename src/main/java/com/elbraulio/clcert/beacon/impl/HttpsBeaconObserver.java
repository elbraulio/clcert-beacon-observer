package com.elbraulio.clcert.beacon.impl;

import com.elbraulio.clcert.beacon.BeaconObserver;
import com.elbraulio.clcert.beacon.PulseContainer;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.function.Function;

/**
 * Http implementation to observe the Beacon service.
 */
public final class HttpsBeaconObserver implements BeaconObserver {

    private final PulseContainerBuilder pulseContainerBuilder;
    private final Function<URI, CheckedIOExceptionSupplier<CloseableHttpResponse>> responseSupplier;

    /**
     * @param pulseContainerBuilder {@link GsonPulseContainerBuilder} Pulse builder.
     * @param responseSupplier      {@link CheckedIOExceptionSupplier} supplies a Pulse response.
     */
    public HttpsBeaconObserver(final PulseContainerBuilder pulseContainerBuilder,
                               final Function<URI, CheckedIOExceptionSupplier<CloseableHttpResponse>> responseSupplier) {
        this.pulseContainerBuilder = pulseContainerBuilder;
        this.responseSupplier = responseSupplier;
    }

    @Override
    public PulseContainer lastPulse() throws IOException {
        return processRequest(this::executeLastPulseRequest);
    }

    @Override
    public PulseContainer pulseBefore(final Instant instant) throws IOException {
        return processRequest(() -> executePulseBeforeRequest(instant));
    }

    @Override
    public PulseContainer pulseAfter(final Instant instant) throws IOException {
        return processRequest(() -> executePulseAfterRequest(instant));
    }

    @Override
    public PulseContainer pulseNear(final Instant instant) throws IOException {
        return processRequest(() -> executePulseNearRequest(instant));
    }

    @Override
    public PulseContainer pulseFromChain(final Long chainIndex, final Long pulseIndex) throws IOException {
        return processRequest(() -> executePulseFromChainRequest(chainIndex, pulseIndex));
    }

    private PulseContainer processRequest(final CheckedIOExceptionSupplier<CloseableHttpResponse> closeableHttpResponseSupplier) throws IOException {
        try (final CloseableHttpResponse response = closeableHttpResponseSupplier.get()) {
            return pulseContainerBuilder.fromEntity(response.getEntity());
        }
    }

    private CloseableHttpResponse executeLastPulseRequest() throws IOException {
        return responseSupplier.apply(BeaconEndpoints.lastPulse()).get();
    }

    private CloseableHttpResponse executePulseBeforeRequest(final Instant instant) throws IOException {
        return responseSupplier.apply(BeaconEndpoints.pulseBefore(instant.toEpochMilli())).get();
    }

    private CloseableHttpResponse executePulseNearRequest(final Instant instant) throws IOException {
        return responseSupplier.apply(BeaconEndpoints.pulseNear(instant.toEpochMilli())).get();
    }

    private CloseableHttpResponse executePulseAfterRequest(final Instant instant) throws IOException {
        return responseSupplier.apply(BeaconEndpoints.pulseAfter(instant.toEpochMilli())).get();
    }

    private CloseableHttpResponse executePulseFromChainRequest(final Long chainIndex, final Long pulseIndex) throws IOException {
        return responseSupplier.apply(BeaconEndpoints.pulseFromChain(chainIndex, pulseIndex)).get();
    }
}
