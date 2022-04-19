package com.elbraulio.clcert.beacon.impl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.function.Supplier;

/**
 * General behavior of a request to the Beacon service using GET.
 */
public final class BeaconHttpRequest implements CheckedIOExceptionSupplier<CloseableHttpResponse> {

    private final Supplier<HttpUriRequest> httpUriRequestSupplier;
    private final Supplier<CloseableHttpClient> httpClientSupplier;

    /**
     * @param uri to consume.
     */
    public BeaconHttpRequest(final URI uri) {
        this(() -> RequestBuilder.get(uri).build(), HttpClients::createDefault);
    }

    /**
     * This constructor allows to customize the request and client.
     * Useful for testing purposes.
     *
     * @param httpUriRequestSupplier supplies a {@link HttpUriRequest}.
     * @param httpClientSupplier     supplies a {@link CloseableHttpClient}.
     */
    public BeaconHttpRequest(final Supplier<HttpUriRequest> httpUriRequestSupplier,
                             final Supplier<CloseableHttpClient> httpClientSupplier) {
        this.httpUriRequestSupplier = httpUriRequestSupplier;
        this.httpClientSupplier = httpClientSupplier;
    }

    /**
     * As it is documented, the service always returns a 200 status code.
     *
     * @return {@link CloseableHttpResponse} with a 200 status code.
     * @throws IOException when connection fails.
     */
    @Override
    public CloseableHttpResponse get() throws IOException {
        final HttpUriRequest request = httpUriRequestSupplier.get();
        try (final CloseableHttpClient httpClient = httpClientSupplier.get()) {
            final CloseableHttpResponse response = httpClient.execute(request);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException(String.format("unexpected status code [%s]", statusCode));
            }
            return response;
        }
    }
}
