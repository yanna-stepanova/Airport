package info;

import model.FlightsInfo;
import terminal.TerminalService;
import terminal.TerminalServiceImpl;

public class InfoCenterServiceImpl implements InfoCenterService {
    private FlightsInfo flightsInfo;
    private TerminalService terminal = new TerminalServiceImpl();

    public InfoCenterServiceImpl(TerminalService terminalService) {
        this.terminal = terminalService;
        this.terminal.addAllFlights(terminalService.getAllFlights());
        flightsInfo = new FlightsInfo(terminal.getAllFlights());
    }

    @Override
    public FlightsInfo getAllFlights() {
        return flightsInfo;
    }

    @Override
    public FlightsInfo getFlightsFrom(String departure) {
        FlightsInfo flightsFrom = null;
        if(flightsInfo!=null){
            flightsFrom = new FlightsInfo(terminal.getFlightByDeparture(departure));

        }
        return flightsFrom;
    }
}
