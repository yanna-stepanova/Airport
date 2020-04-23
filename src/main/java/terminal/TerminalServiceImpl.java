package terminal;

import model.Flight;
import store.FlightStore;

import java.util.HashSet;
import java.util.Set;

public class TerminalServiceImpl implements TerminalService {
    private boolean isTerminalEmpty() {
        if (getAllFlights().isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void addAllFlights(Set<Flight> flights) {
        FlightStore.addFlightsToStore(flights);
    }

    @Override
    public Set<Flight> getAllFlights() {
        return new HashSet<Flight>(FlightStore.getFlightStore());
    }

    @Override
    public Set<Flight> getFlightByDeparture(String departure) {
        Set<Flight> flighByDeparture = new HashSet<>();
        if (!isTerminalEmpty()) {
            for (Flight object : getAllFlights()) {
                if (object.getDeparture().equals(departure)) {
                    flighByDeparture.add(object);
                }
            }
        }
        return flighByDeparture;
    }

    @Override
    public Set<Flight> getFlightByDestination(String destination) {
        Set<Flight> flighByDestination = new HashSet<>();
        if (!isTerminalEmpty()) {
            for (Flight object : getAllFlights()) {
                if (object.getDestination().equals(destination)) {
                    flighByDestination.add(object);
                }
            }
        }
        return flighByDestination;
    }

    @Override
    public Flight getFlightByNumber(long flightNo) {
        if (!isTerminalEmpty()) {
            for (Flight object : getAllFlights()) {
                if (object.getFlightNo() == flightNo)
                    return object;
            }
        }
        return null;
    }

    @Override
    public boolean removeFlightByNumber(long flightNo) {
        if (!isTerminalEmpty()) {
            if (FlightStore.deleteFromStore(flightNo)) {

               // getAllFlights().remove(getFlightByNumber(flightNo));
                return true;
            }

        }
        return false;
    }
}
