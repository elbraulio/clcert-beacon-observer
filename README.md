[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/elbraulio/clcert-beacon-observer/blob/master/LICENSE) [![codebeat badge](https://codebeat.co/badges/2c8651d0-d4f1-4773-b059-7931aa28cbee)](https://codebeat.co/projects/github-com-elbraulio-clcert-beacon-observer-master) [![Java CI with Maven](https://github.com/elbraulio/clcert-beacon-observer/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/elbraulio/clcert-beacon-observer/actions/workflows/maven.yml) [![](https://jitpack.io/v/elbraulio/clcert-beacon-observer.svg)](https://jitpack.io/#elbraulio/clcert-beacon-observer) [![](https://img.shields.io/badge/javadocs-ok-green.svg)](https://jitpack.io/com/github/elbraulio/clcert-beacon-observer/latest/javadoc/)

# CLCERT Beacon Observer

This is the **unofficial** Java SDK to consume
the [CLCERT Beacon service](https://random.uchile.cl/using/#desarrolladores).

## Install

Step 1: Add the JitPack repository to your build file

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2: Add the dependency

```xml

<dependency>
    <groupId>com.github.elbraulio</groupId>
    <artifactId>clcert-beacon-observer</artifactId>
    <version>0.2.0</version>
</dependency>
```

## How to use

Pretty simple to use:

```java
// get an observer.
BeaconObserver beaconObserver = BeaconFactory.observer();

// ask for randomness.
PulseContainer pulseContainer = beaconObserver.lastPulse();
```

You can ask for specific times as well. Always remember to use UTC.

```java
Instant instant = Instant
                    .now()
                    .atOffset(ZoneOffset.UTC)
                    .toInstant()
                    .truncatedTo(ChronoUnit.MINUTES);
PulseContainer pulseContainer = beaconObserver.pulseBefore(instant);
```

See the response structure in:

- [PulseContainer](https://github.com/elbraulio/clcert-beacon-observer/blob/master/src/main/java/com/elbraulio/clcert/beacon/PulseContainer.java)
  .
- [Pulse](https://github.com/elbraulio/clcert-beacon-observer/blob/master/src/main/java/com/elbraulio/clcert/beacon/Pulse.java)

See the supported calls in
BeaconObserver [here](https://github.com/elbraulio/clcert-beacon-observer/blob/master/src/main/java/com/elbraulio/clcert/beacon/BeaconObserver.java)
.
