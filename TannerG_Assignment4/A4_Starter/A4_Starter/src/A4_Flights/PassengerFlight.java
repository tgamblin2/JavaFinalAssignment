package A4_Flights;

/**
 * A passenger flight has no cargo
 */
public class PassengerFlight extends Flight {

    // TODO-A3 - Complete this class, using javadocs as a reference
    private int numPassengers;
    
    public PassengerFlight(String flightNumber, String dayOfWeek, int departureTime,
            Location destination, int numCrew, int numPassengers) {
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
        this.numPassengers = numPassengers;
    }
    
    public double getNumPassengers() {
        return numPassengers;
    }
    
    @Override
    public String getFlightType() {
        return Common.PASSENGER;
    }
    
    @Override
    public int calculateWeight() {
        return super.calculateWeight() + (numPassengers * Common.AVERAGE_PERSON_WEIGHT);
    }
    
    @Override
    public String toDisplayReport() {
        return super.toDisplayReport() + "\n\tPassengers: " + numPassengers + "\n\t" +
                "Total Weight: " + Common.format(calculateWeight());
    }
    
    @Override
    public String toArchiveFormat() {
        return super.toArchiveFormat() + "," + numPassengers;
    }
    
    @Override
    public boolean checkCrew() {
        return getNumCrew() >= Common.MINIMUM_CREW;
    }

    @Override
    public boolean checkPassengers() {
        return getNumPassengers() >= Common.MINIMUM_PASSENGERS;
    }

    @Override
    public boolean checkTime() {
        return true;
    }

    @Override
    public boolean checkWeight() {
        return calculateWeight() < Common.MAXIMUM_WEIGHT;
    }
    
} // end class PassengerFlight
