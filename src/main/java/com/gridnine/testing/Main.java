package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        var testData = FlightBuilder.createFlights();
        var currentTime = LocalDateTime.now();

        var test1 = testData
                .filter(flight -> !flight
                        .getSegments()
                        .get(0)
                        .getDepartureDate()
                        .isBefore(currentTime));

        var test2 = testData.filter(flight -> flight
                .getSegments()
                .stream()
                .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())));

        var test3 = testData.filter(flight -> {
            Segment previous = flight.getSegments().get(0);
            long seconds = 0L;
            for (var i = 1; i < flight.getSegments().size(); i++) {
                var currentSegment = flight.getSegments().get(i);
                seconds += ChronoUnit.SECONDS.between(previous.getArrivalDate(), currentSegment.getDepartureDate());

                if (seconds > 7200) {
                    return false;
                }
            }
            return true;
        });

        System.out.println("---- test data ----");
        System.out.println(testData + "\n");

        System.out.println("---- test 1 ----");
        System.out.println(test1 + "\n");
        System.out.println("---- test 2 ----");
        System.out.println(test2 + "\n");
        System.out.println("---- test 3 ----");
        System.out.println(test3 + "\n");
    }
}
