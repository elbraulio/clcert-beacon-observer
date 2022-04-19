package com.elbraulio.clcert.beacon.dto;

import com.elbraulio.clcert.beacon.ListValue;

public class ListValueDto implements ListValue {

    private final String uri;
    private final String type;
    private final String value;

    public ListValueDto(final String uri, final String type, final String value) {
        this.uri = uri;
        this.type = type;
        this.value = value;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ListValueDto{" +
                "uri='" + uri + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
