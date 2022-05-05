package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class Segment {

    static private DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        if (departureDate == null || arrivalDate == null) {
            throw new IllegalArgumentException();
        }

        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return departureDate.equals(segment.departureDate) &&
                arrivalDate.equals(segment.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureDate, arrivalDate);
    }

    @Override
    public String toString() {
        return '(' + departureDate.format(DATE_TIME_FORMATTER) + '|' + arrivalDate.format(DATE_TIME_FORMATTER) + ')';
    }
}
