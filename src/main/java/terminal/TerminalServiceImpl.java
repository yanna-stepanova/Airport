package terminal;

import model.Flight;

import java.util.Set;

/**
 *
 */
public class TerminalServiceImpl implements TerminalService {
    @Override
    public void addAllFlights(Set<Flight> flights) {
    }

    @Override
    public Set<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Set<Flight> getFlightByDeparture(String departure) {
        return null;
    }

    @Override
    public Set<Flight> getFlightByDestination(String destination) {
        return null;
    }

    @Override
    public Flight getFlightByNumber(long flightNo) {
        return null;
    }

    @Override
    public boolean removeFlightByNumber(long flightNo) {
        return false;
    }
}
