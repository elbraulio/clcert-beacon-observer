package com.elbraulio.clcert.beacon.impl;

import com.elbraulio.clcert.beacon.exception.ClcertBeaconObserverException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;

/**
 * General behavior of a request to the Beacon service using GET.
 */
public final class BeaconHttpRequest implements CheckedIOExceptionSupplier<CloseableHttpResponse> {

    private final URI uri;
    private final CloseableHttpClient httpClient;

    /**
     * Ctor.
     *
     * @param uri to consume.
     */
    public BeaconHttpRequest(final URI uri) {
        this(uri, HttpClients.createDefault());
    }

    /**
     * Ctor.
     *
     * @param uri        uri to reach GET Beacon service.
     * @param httpClient {@link CloseableHttpClient} that will be closed after request.
     */
    public BeaconHttpRequest(final URI uri, final CloseableHttpClient httpClient) {
        this.uri = uri;
        this.httpClient = httpClient;
    }

    /**
     * As it is documented, the service always returns a 200 status code.
     *
     * @return {@link CloseableHttpResponse} with a 200 status code.
     * @throws IOException when connection fails.
     */
    @Override
    public CloseableHttpResponse get() throws IOException {
        final HttpUriRequest request = RequestBuilder.get(uri).build();
        try (final CloseableHttpClient closeableHttpClient = httpClient) {
            final CloseableHttpResponse response = closeableHttpClient.execute(request);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new ClcertBeaconObserverException(String.format("unexpected status code [%s]", statusCode));
            }
            return response;
        }
    }
}
