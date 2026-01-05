package minor2;

import java.util.*;

// Flight class
class Flight implements Comparable<Flight> {
    String flightNo;
    String airline;
    String departureTime;

    public Flight(String flightNo, String airline, String departureTime) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.departureTime = departureTime;
    }

    @Override
    public int compareTo(Flight other) {
        return this.departureTime.compareTo(other.departureTime);
    }

    @Override
    public String toString() {
        return flightNo + " - " + airline + " (Departure: " + departureTime + ")";
    }
}

public class FlightReservationSystem {
    HashMap<String, Flight> flightMap = new HashMap<>(); // For quick lookup by flight number

    // Add flight
    public void addFlight(String flightNo, String airline, String departureTime) {
        Flight flight = new Flight(flightNo, airline, departureTime);
        flightMap.put(flightNo, flight);
        System.out.println("Flight " + flightNo + " added successfully.");
    }

    // Retrieve flight by flight number
    public Flight getFlightByNumber(String flightNo) {
        return flightMap.get(flightNo);
    }

    // Display all flights sorted by departure time
    public void displayFlightsSortedByDeparture() {
        TreeSet<Flight> sortedFlights = new TreeSet<>(flightMap.values());
        for (Flight flight : sortedFlights) {
            System.out.println(flight);
        }
    }

    public static void main(String[] args) {
        FlightReservationSystem frs = new FlightReservationSystem();

        // Adding flights
        frs.addFlight("AI101", "Air India", "10:30");
        frs.addFlight("SG202", "SpiceJet", "08:15");
        frs.addFlight("IN305", "IndiGo", "12:45");

        System.out.println("\nRetrieve flight SG202:");
        System.out.println(frs.getFlightByNumber("SG202"));

        System.out.println("\nFlights sorted by departure time:");
        frs.displayFlightsSortedByDeparture();
    }
}
