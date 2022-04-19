package com.elbraulio.clcert.beacon;

import java.time.LocalDateTime;

/**
 * Pulse with the random chain at a certain time.
 */
public interface Pulse {
    String getUri();

    String getVersion();

    Integer getCipherSuite();

    Long getPeriod();

    String getCertificateId();

    Long getChainIndex();

    Long getPulseIndex();

    LocalDateTime getTimeStamp();

    String getLocalRandomValue();

    String getPrecommitmentValue();

    Integer getStatusCode();

    String getSignatureValue();

    String getOutputValue();

    String getHashedMessage();

    String getWitness();

    Long getIterations();
}
