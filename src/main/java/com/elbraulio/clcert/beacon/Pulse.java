package com.elbraulio.clcert.beacon;

import java.time.Instant;
import java.util.List;

/**
 * Pulse with the random value at a certain time.
 */
public interface Pulse {
    String getUri();

    String getVersion();

    Integer getCipherSuite();

    Long getPeriod();

    String getCertificateId();

    Long getChainIndex();

    Long getPulseIndex();

    Instant getTimeStamp();

    String getLocalRandomValue();

    String getPrecommitmentValue();

    Integer getStatusCode();

    String getSignatureValue();

    String getOutputValue();

    String getHashedMessage();

    String getWitness();

    Long getIterations();

    List<? extends External> getExternal();

    List<? extends ListValue> getListValues();

}
