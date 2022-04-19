package com.elbraulio.clcert.beacon.impl;

import java.io.IOException;

@FunctionalInterface
public interface CheckedIOExceptionSupplier<T> {
    T get() throws IOException;
}
