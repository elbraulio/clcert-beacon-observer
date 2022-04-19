package com.elbraulio.clcert.beacon.dto;

import com.elbraulio.clcert.beacon.Pulse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class PulseDto implements Pulse {

    private final String uri;
    private final String version;
    private final Integer cipherSuite;
    private final Long period;
    private final String certificateId;
    private final Long chainIndex;
    private final Long pulseIndex;
    private final String timeStamp;
    private final String localRandomValue;
    private final String precommitmentValue;
    private final Integer statusCode;
    private final String signatureValue;
    private final String outputValue;
    private final String hashedMessage;
    private final String witness;
    private final Long iterations;

    public PulseDto(final String uri,
                    final String version,
                    final Integer cipherSuite,
                    final Long period,
                    final String certificateId,
                    final Long chainIndex,
                    final Long pulseIndex,
                    final String timeStamp,
                    final String localRandomValue,
                    final String precommitmentValue,
                    final Integer statusCode,
                    final String signatureValue,
                    final String outputValue,
                    final String hashedMessage,
                    final String witness,
                    final Long iterations) {
        this.uri = uri;
        this.version = version;
        this.cipherSuite = cipherSuite;
        this.period = period;
        this.certificateId = certificateId;
        this.chainIndex = chainIndex;
        this.pulseIndex = pulseIndex;
        this.timeStamp = timeStamp;
        this.localRandomValue = localRandomValue;
        this.precommitmentValue = precommitmentValue;
        this.statusCode = statusCode;
        this.signatureValue = signatureValue;
        this.outputValue = outputValue;
        this.hashedMessage = hashedMessage;
        this.witness = witness;
        this.iterations = iterations;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Integer getCipherSuite() {
        return cipherSuite;
    }

    @Override
    public Long getPeriod() {
        return period;
    }

    @Override
    public String getCertificateId() {
        return certificateId;
    }

    @Override
    public Long getChainIndex() {
        return chainIndex;
    }

    @Override
    public Long getPulseIndex() {
        return pulseIndex;
    }

    @Override
    public LocalDateTime getTimeStamp() {
        return LocalDateTime.parse(timeStamp, DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public String getLocalRandomValue() {
        return localRandomValue;
    }

    @Override
    public String getPrecommitmentValue() {
        return precommitmentValue;
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String getSignatureValue() {
        return signatureValue;
    }

    @Override
    public String getOutputValue() {
        return outputValue;
    }

    @Override
    public String getHashedMessage() {
        return hashedMessage;
    }

    @Override
    public String getWitness() {
        return witness;
    }

    @Override
    public Long getIterations() {
        return iterations;
    }

    @Override
    public String toString() {
        return "PulseDto{" +
                "uri='" + uri + '\'' +
                ", version='" + version + '\'' +
                ", cipherSuite=" + cipherSuite +
                ", period=" + period +
                ", certificateId='" + certificateId + '\'' +
                ", chainIndex=" + chainIndex +
                ", pulseIndex=" + pulseIndex +
                ", timeStamp='" + getTimeStamp() + '\'' +
                ", localRandomValue='" + localRandomValue + '\'' +
                ", precommitmentValue='" + precommitmentValue + '\'' +
                ", statusCode=" + statusCode +
                ", signatureValue='" + signatureValue + '\'' +
                ", outputValue='" + outputValue + '\'' +
                ", hashedMessage='" + hashedMessage + '\'' +
                ", witness='" + witness + '\'' +
                ", iterations=" + iterations +
                '}';
    }
}
