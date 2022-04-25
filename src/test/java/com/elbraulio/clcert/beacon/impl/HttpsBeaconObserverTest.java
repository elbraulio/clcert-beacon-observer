package com.elbraulio.clcert.beacon.impl;

import com.elbraulio.clcert.beacon.BeaconFactory;
import com.elbraulio.clcert.beacon.BeaconObserver;
import com.elbraulio.clcert.beacon.PulseContainer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class HttpsBeaconObserverTest {

    private static BeaconObserver beaconObserver;

    @BeforeClass
    public static void setUp() {
        beaconObserver = BeaconFactory.observer();
    }

    @Test
    public void lastPulse_return_container() throws IOException {
        final PulseContainer pulseContainer = beaconObserver.lastPulse();

        assertNotNull(pulseContainer);
    }

    @Test
    public void lastPulse_twice_call() throws IOException {
        assertNotNull(beaconObserver.lastPulse());
        assertNotNull(beaconObserver.lastPulse());
    }

    @Test
    public void pulseBefore_return_container() throws IOException {
        final PulseContainer pulseContainer = beaconObserver.pulseBefore(utcNow());

        assertNotNull(pulseContainer);
    }

    @Test
    public void pulseAfter_return_container() throws IOException {
        final PulseContainer pulseContainer = beaconObserver.pulseAfter(utcNow().minus(10, ChronoUnit.DAYS));

        assertNotNull(pulseContainer);
    }

    @Test
    public void pulseNear_return_container() throws IOException {
        final PulseContainer pulseContainer = beaconObserver.pulseNear(utcNow().minus(10, ChronoUnit.DAYS));

        assertNotNull(pulseContainer);
    }

    @Test
    public void pulseFromChain_return_container() throws IOException {
        final PulseContainer pulseContainer = beaconObserver.pulseFromChain(1L, 1L);

        assertNotNull(pulseContainer);
    }

    private void assertNotNull(final PulseContainer pulseContainer) {
        Assert.assertNotNull(pulseContainer.getPulse());
        Assert.assertNotNull(pulseContainer.getPulse().getOutputValue());
        Assert.assertNotNull(pulseContainer.getPulse().getVersion());
        Assert.assertNotNull(pulseContainer.getPulse().getStatusCode());
        Assert.assertNotNull(pulseContainer.getPulse().getHashedMessage());
        Assert.assertNotNull(pulseContainer.getPulse().getPulseIndex());
        Assert.assertNotNull(pulseContainer.getPulse().getCertificateId());
        Assert.assertNotNull(pulseContainer.getPulse().getChainIndex());
        Assert.assertNotNull(pulseContainer.getPulse().getCipherSuite());
        Assert.assertNotNull(pulseContainer.getPulse().getIterations());
        Assert.assertNotNull(pulseContainer.getPulse().getLocalRandomValue());
        Assert.assertNotNull(pulseContainer.getPulse().getPeriod());
        Assert.assertNotNull(pulseContainer.getPulse().getPrecommitmentValue());
        Assert.assertNotNull(pulseContainer.getPulse().getSignatureValue());
        Assert.assertNotNull(pulseContainer.getPulse().getTimeStamp());
        Assert.assertNotNull(pulseContainer.getPulse().getUri());
        Assert.assertNotNull(pulseContainer.getPulse().getWitness());
        Assert.assertNotNull(pulseContainer.getPulse().getListValues());
        Assert.assertNotNull(pulseContainer.getPulse().getExternal());
    }

    private Instant utcNow() {
        return Instant
                .now()
                .atOffset(ZoneOffset.UTC)
                .toInstant()
                .truncatedTo(ChronoUnit.MINUTES);
    }
}
