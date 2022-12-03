package A4_Flights;

/**
 * A Training Flight has no passengers, and no cargo
 */
public class TrainingFlight extends Flight {

    // TODO-A4 - Complete this class, using javadocs as a reference
    public TrainingFlight(String flightNumber, String dayOfWeek, int departureTime,
            Location destination, int numCrew) {
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
    }
   
    @Override
    public String getFlightType() {
        return Common.TRAINING;
    }
    
    @Override
    public String toDisplayReport() {
        return super.toDisplayReport() + "\n\t" +
                "Total Weight: " + calculateWeight();
    }
    
    @Override
    public boolean checkCrew() {
        return getNumCrew() >= Common.MINIMUM_CREW;
    }

    @Override
    public boolean checkPassengers() {
        return true;
    }

    @Override
    public boolean checkTime() {
        return getDepartureTime() >= Common.EARLIEST_DEPARTURE &&
                getDepartureTime() <= Common.LATEST_DEPARTURE;
    }

    @Override
    public boolean checkWeight() {
        return calculateWeight() < Common.MAXIMUM_WEIGHT;
    }

} // end class TrainingFlight
