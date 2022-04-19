package com.elbraulio.clcert.beacon.dto;

import com.elbraulio.clcert.beacon.External;

public class ExternalDto implements External {

    private final String sourceId;
    private final String value;
    private final Integer statusCode;

    public ExternalDto(final String sourceId, final String value, final Integer statusCode) {
        this.sourceId = sourceId;
        this.value = value;
        this.statusCode = statusCode;
    }

    @Override
    public String getSourceId() {
        return sourceId;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "ExternalDto{" +
                "sourceId='" + sourceId + '\'' +
                ", value='" + value + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
