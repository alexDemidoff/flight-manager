package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightSequenceTest {

    private FlightSequence getFlightSequence() {
        var firstFlight = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        var secondFlight = new Flight(List.of(new Segment(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusHours(1).plusDays(1))));

        return new FlightSequence(List.of(firstFlight, secondFlight));
    }

    @Test
    @DisplayName("Exclude all flights")
    public void excludeAllFlightsTest() {
        var initialData = getFlightSequence();
        var result = initialData.filter(flight -> false);
        assertThat(result.getFlights()).isEmpty();
    }

    @Test
    @DisplayName("Include all flights")
    public void includeAllFlightsTest() {
        var initialData = getFlightSequence();
        var result = initialData.filter(flight -> true);
        assertThat(result.getFlights()).isEqualTo(initialData.getFlights());
    }
}
