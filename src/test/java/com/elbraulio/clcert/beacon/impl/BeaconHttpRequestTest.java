package com.elbraulio.clcert.beacon.impl;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class BeaconHttpRequestTest {

    @Test(expected = RuntimeException.class)
    public void get_throw_exception_when_status_not_200() throws IOException {
        final CloseableHttpClient httpClient = spy(HttpClients.createDefault());
        final BeaconHttpRequest beaconHttpRequest = new BeaconHttpRequest(URI.create(""), httpClient);
        final CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        final StatusLine statusLine = mock(StatusLine.class);
        doReturn(response).when(httpClient).execute(any());
        doReturn(statusLine).when(response).getStatusLine();
        doReturn(201).when(statusLine).getStatusCode();

        beaconHttpRequest.get();
    }

    @Test(expected = IllegalStateException.class)
    public void get_close_client_after_usage() throws IOException {
        final BeaconHttpRequest beaconHttpRequest = new BeaconHttpRequest(BeaconEndpoints.lastPulse());
        beaconHttpRequest.get();
        beaconHttpRequest.get();
    }
}
