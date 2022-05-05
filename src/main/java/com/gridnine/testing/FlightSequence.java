package com.gridnine.testing;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class FlightSequence {

    private final List<Flight> flights;

    public FlightSequence(List<Flight> flights) {
        if (flights == null) {
            throw new IllegalArgumentException();
        }

        this.flights = Collections.unmodifiableList(flights);
    }

    public FlightSequence filter(Predicate<Flight> predicate) {
        var newFlights = this.flights.stream().filter(predicate).collect(Collectors.toUnmodifiableList());
        return new FlightSequence(newFlights);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSequence that = (FlightSequence) o;
        return flights.equals(that.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flights);
    }

    @Override
    public String toString() {
        return flights.stream().map(Flight::toString).collect(Collectors.joining("\n"));
    }
}
