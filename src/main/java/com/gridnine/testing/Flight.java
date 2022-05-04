package com.gridnine.testing;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = Collections.unmodifiableList(segments);
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Segment::toString).collect(Collectors.joining(" "));
    }
}
