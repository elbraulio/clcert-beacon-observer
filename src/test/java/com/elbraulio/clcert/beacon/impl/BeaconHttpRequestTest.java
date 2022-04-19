package com.elbraulio.clcert.beacon.impl;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class BeaconHttpRequestTest {

    private static BeaconHttpRequest beaconHttpRequest;
    private static CloseableHttpClient httpClient;

    @BeforeClass
    public static void setup() {
        httpClient = spy(HttpClients.createDefault());
        beaconHttpRequest = new BeaconHttpRequest(() -> RequestBuilder.get("").build(), () -> httpClient);
    }

    @Test(expected = RuntimeException.class)
    public void execute_throw_exception_when_status_not_200() throws IOException {
        final CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        final StatusLine statusLine = mock(StatusLine.class);
        doReturn(response).when(httpClient).execute(any());
        doReturn(statusLine).when(response).getStatusLine();
        doReturn(201).when(statusLine).getStatusCode();

        beaconHttpRequest.get();
    }
}
