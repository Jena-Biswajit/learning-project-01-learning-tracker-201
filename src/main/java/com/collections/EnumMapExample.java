package com.collections;

import java.util.EnumMap;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class EnumMapExample {
    public static void main(String[] args) {
        // Create an EnumMap
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        // Add entries to the EnumMap
        schedule.put(Day.MONDAY, "Workout");
        schedule.put(Day.TUESDAY, "Study");
        schedule.put(Day.FRIDAY, "Relax");

        // Print the map
        System.out.println("EnumMap: " + schedule);

        // Access a value
        System.out.println("Schedule for Tuesday: " + schedule.get(Day.TUESDAY));
    }
}