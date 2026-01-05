package week10;

import java.util.Map;
import java.util.TreeMap;

class Flight {
    String flightNumber;
    String destination;
    int duration; 

    public Flight(String flightNumber, String destination, int duration) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return flightNumber + " to " + destination + " (" + duration + " min)";
    }
}

public class Airport {
    private TreeMap<String, Flight> flights = new TreeMap<>();

    public void addFlight(String time, String flightNo, String destination, int duration) {
        flights.put(time, new Flight(flightNo, destination, duration));
    }

    public void removeFlight(String time) {
        if (flights.containsKey(time)) {
            flights.remove(time);
            System.out.println("Flight at " + time + " removed.\n");
        } else {
            System.out.println("No flight found at " + time + ".\n");
        }
    }

    public void displayAllFlights() {
        System.out.println("Flights in order of departure:");
        for (Map.Entry<String, Flight> entry : flights.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }

    public int getTotalFlights() {
        return flights.size();
    }

    public void getEarliestAndLatestFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.\n");
            return;
        }
        Map.Entry<String, Flight> earliest = flights.firstEntry();
        Map.Entry<String, Flight> latest = flights.lastEntry();

        System.out.println("Earliest flight: " + earliest.getValue().flightNumber + " to " +
                earliest.getValue().destination + " at " + earliest.getKey());

        System.out.println("Latest flight: " + latest.getValue().flightNumber + " to " +
                latest.getValue().destination + " at " + latest.getKey());

        System.out.println();
    }

    public int calculateTotalDurationForDestination(String destination) {
        int totalDuration = 0;
        for (Flight flight : flights.values()) {
            if (flight.destination.equalsIgnoreCase(destination)) {
                totalDuration += flight.duration;
            }
        }
        return totalDuration;
    }

    public static void main(String[] args) {
        Airport airport = new Airport();

        airport.addFlight("08:30", "AI101", "New York", 420);
        airport.addFlight("10:15", "BA202", "London", 360);
        airport.addFlight("12:00", "AF303", "Paris", 150);
        airport.addFlight("15:45", "EK404", "Dubai", 300);
        airport.addFlight("18:20", "AI505", "New York", 450);

        airport.displayAllFlights();

        System.out.println("Total flights: " + airport.getTotalFlights() + "\n");

        airport.getEarliestAndLatestFlights();

        String destination = "New York";
        int totalDuration = airport.calculateTotalDurationForDestination(destination);
        System.out.println("Total duration for flights to " + destination + ": " + totalDuration + " minutes\n");

        airport.removeFlight("12:00");

        airport.displayAllFlights();
    }
}