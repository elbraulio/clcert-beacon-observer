# CLCERT Beacon Observer

This is the **unofficial** Java API to consume
the [CLCERT Beacon service](https://random.uchile.cl/using/#desarrolladores).

## How to use

Pretty simple to use:

```
// get and observer.
BeaconObserver beaconObserver = BeaconFactory.observer();

// ask for randomness.
PulseContainer pulseContainer = beaconObserver.lastPulse();
```

You can ask for specific times as well. Always remember to use UTC.

```
Instant instant = Instant
                    .now()
                    .atOffset(ZoneOffset.UTC)
                    .toInstant()
                    .truncatedTo(ChronoUnit.MINUTES);
PulseContainer pulseContainer = beaconObserver.pulseBefore(instant);
```

See the response structure here.

See the supported calls here.
