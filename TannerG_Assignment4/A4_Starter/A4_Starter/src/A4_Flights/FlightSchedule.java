package A4_Flights;

import java.util.ArrayList;

public class FlightSchedule {

    private final Flight[] flights;

    /**
     * Creates a new schedule based on the specified flights.
     *
     * @param flights the flights to be contained in this schedule
     */
    public FlightSchedule(Flight[] flights) {
        this.flights = flights;
    }

    /**
     * Gets all of the flights in this schedule.
     *
     * @return all of the flights in this schedule
     */
    public Flight[] getAllFlights() {
        return flights;
    }

    public Flight[] getFlightsByDestination(String locationCode) {
        // TODO-B1
        ArrayList<Flight> listFlights = new ArrayList<>();
        for (int i=0;i<flights.length;i++) {
            if (locationCode.equals(flights[i].getDestination().getLocationCode())) {
                listFlights.add(flights[i]);
            }
        }
        Flight[] newFlights = new Flight[listFlights.size()];
        newFlights = listFlights.toArray(new Flight[listFlights.size()]);
        
        return newFlights;
    }

    public int countFlightsByDestination(String locationCode) {
        // TODO-B1
        int count = 0;
        for (int i=0;i<flights.length;i++) {
            if (locationCode.equals(flights[i].getDestination().getLocationCode())) {
                count++;
            }
        }
        return count;
    }

    public Flight[] getFlightsByType(String flightType) {
        // TODO-B2
        ArrayList<Flight> listFlights = new ArrayList<>();
        for (int i=0;i<flights.length;i++) {
            if (!flightType.equals(flights[i].getFlightType())) {
            } else {
                listFlights.add(flights[i]);
            }
        }
        Flight[] newFlights = new Flight[listFlights.size()];
        newFlights = listFlights.toArray(new Flight[listFlights.size()]);
        
        return newFlights;
    }

    public int countFlightsByType(String flightType) {
        // TODO-B2
        int count = 0;
        for (int i=0;i<flights.length;i++) {
            if (flightType.equals(flights[i].getFlightType())) {
                count++;
            }
        }
        return count;
    }


} // end class FlightSchedule
