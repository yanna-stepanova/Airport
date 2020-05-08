package info;

import model.FlightsInfo;
import terminal.TerminalService;

public class InfoCenterServiceImpl implements InfoCenterService {
    private TerminalService terminal;

    public InfoCenterServiceImpl(TerminalService terminalService) {
        this.terminal = terminalService;
    }

    @Override
    public FlightsInfo getAllFlights() {
        return new FlightsInfo(terminal.getAllFlights());
    }

    @Override
    public FlightsInfo getFlightsFrom(String departure) {
        return new FlightsInfo(terminal.getFlightByDeparture(departure));
    }
}
