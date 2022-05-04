package com.gridnine.testing;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class FlightSequence {
    private final List<Flight> flights;

    public FlightSequence(List<Flight> flights) {
        this.flights = Collections.unmodifiableList(flights);
    }

    public FlightSequence filter(Predicate<Flight> predicate) {
        var newFlights = this.flights.stream().filter(predicate).collect(Collectors.toUnmodifiableList());
        return new FlightSequence(newFlights);
    }

    @Override
    public String toString() {
        return flights.stream().map(Flight::toString).collect(Collectors.joining("\n"));
    }
}
