package A4_Flights;

/**
 * Cargo inherits from Flight
 * Cargo flights have crew, cargo, but no passengers
 */
public class CargoFlight extends Flight {

    // TODO-A2 - Complete this class, using javadocs as a reference
    private int cargoWeight;
    
    public CargoFlight(String flightNumber, String dayOfWeek, int departureTime,
            Location destination, int numCrew, int cargoWeight) {
        super(flightNumber, dayOfWeek, departureTime, destination, numCrew);
        this.cargoWeight = cargoWeight;
    }
    
    public double getCargoWeight() {
        return cargoWeight;
    }
    
    @Override
    public String getFlightType() {
        return Common.CARGO;
    }
    
    @Override
    public int calculateWeight() {
        return super.calculateWeight() + cargoWeight;
    }
    
    @Override
    public String toDisplayReport() {
        return super.toDisplayReport() + "\n\tCargo Weight: " + Common.format(cargoWeight) + "\n\t" +
                "Total Weight: " + Common.format(calculateWeight());
    }
    
    @Override
    public String toArchiveFormat() {
        return super.toArchiveFormat() + "," + cargoWeight;
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
        return true;
    }

    @Override
    public boolean checkWeight() {
        return calculateWeight() < Common.MAXIMUM_WEIGHT;
    }
    
} // end class CargoFlight
