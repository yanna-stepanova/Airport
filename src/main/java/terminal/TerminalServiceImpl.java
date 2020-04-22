package terminal;

import model.Flight;

import java.util.HashSet;
import java.util.Set;

public class TerminalServiceImpl implements TerminalService {
    private Set<Flight> terminalSet = new HashSet<>();

    private boolean isTerminalEmpty() {
        if (terminalSet.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void addAllFlights(Set<Flight> flights) {
        terminalSet.addAll(flights);
    }

    @Override
    public Set<Flight> getAllFlights() {
        return terminalSet;
    }

    @Override
    public Set<Flight> getFlightByDeparture(String departure) {
        Set<Flight> flighByDeparture = new HashSet<>();
        if (!isTerminalEmpty()) {
            for (Flight object : terminalSet) {
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

            for (Flight object : terminalSet) {
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
            for (Flight object : terminalSet) {
                if (object.getFlightNo() == flightNo)
                    return object;
            }
        }
        return null;
    }

    @Override
    public boolean removeFlightByNumber(long flightNo) {
        if (getFlightByNumber(flightNo) != null) {
            terminalSet.remove(getFlightByNumber(flightNo));
            return true;
        }
        return false;
    }
}
