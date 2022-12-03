package A4_Flights;

/**
 * Flight - a nonstop flight departing from the home airport
 * Flight is the parent class for Training, Cargo, and Passenger Flights
 */
public abstract class Flight implements PolicyRules {

    // TODO-A1 - Complete this class, using javadocs as a reference
    private String dayOfWeek;
    private int departureTime;
    private Location destination;
    private String flightNumber;
    private int numCrew;
    
    public Flight(String flightNumber, String dayOfWeek, int departureTime,
            Location destination, int numCrew) {
        this.flightNumber = flightNumber;
        this.dayOfWeek = dayOfWeek;
        this.departureTime = departureTime;
        this.destination = destination;
        this.numCrew = numCrew;
    }
    
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    
    public int getDepartureTime() {
        return departureTime;
    }
    
    public Location getDestination() {
        return destination;
    }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public abstract String getFlightType();
    
    public int getNumCrew() {
        return numCrew;
    }
    
    public int calculateWeight() {
        return numCrew * Common.AVERAGE_PERSON_WEIGHT;
    }

    public String toDisplayReport() {
        return this.getFlightType() + " Flight = " + flightNumber + ", "
                + "Day = " + dayOfWeek + ", " + "Time: " + departureTime + "\n\t" +
                "Destination: " + destination.toDisplayFormat() + "\n\t" +
                "Number of Crew: " + numCrew;
    }

    public String toArchiveFormat() {
        return this.getFlightType() + "," + flightNumber + "," +
                dayOfWeek + "," + departureTime + "," + destination.getLocationCode()
                + "," + numCrew;
    }


} // end class Flight
