import info.InfoCenterService;
import info.InfoCenterServiceImpl;
import model.Flight;
import model.FlightsInfo;
import store.FlightStore;
import terminal.TerminalService;
import terminal.TerminalServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        //можно здесь писать код, чтобы проверить, что все ваши сервисы работают правильно
        /*
        Set<Flight> flightsSet = new HashSet<>();
        flightsSet.add(new Flight(301, "Kiev", "Vienna"));
        flightsSet.add(new Flight(303, "Kiev", "Istanbul"));
        flightsSet.add(new Flight(305, "Kiev", "Paris"));
        flightsSet.add(new Flight(202, "Kharkov", "Kiev"));
        flightsSet.add(new Flight(304, "Paris", "Kiev"));
        flightsSet.add(new Flight(201, "Kharkov", "Istanbul"));
        flightsSet.add(new Flight(407, "Vienna", "Krakow"));
        flightsSet.add(new Flight(405, "Vienna", "London"));
         */

        TerminalService terminalService = new TerminalServiceImpl();
        terminalService.addAllFlights(new HashSet<Flight>(FlightStore.getFlightStore()));
        InfoCenterService infoCS = new InfoCenterServiceImpl(terminalService);
        System.out.println("All flights:\n" + infoCS.getAllFlights().toString());

        System.out.println("\nFlights from Vienna:\n" + infoCS.getFlightsFrom("Vienna").toString());

        FlightsInfo flightsTo = new FlightsInfo(terminalService.getFlightByDestination("Istanbul"));
        System.out.println("\nFlights to Istanbul:\n" + flightsTo.toString());

        Flight flightFound = terminalService.getFlightByNumber(901);
        System.out.println("\nThe flight: '" + flightFound.getFlightNo() + "' from "
                           + flightFound.getDeparture() + " to " + flightFound.getDestination()+", - will be deleted.");
        terminalService.removeFlightByNumber(flightFound.getFlightNo());
        FlightsInfo flightsAfterRemove = new FlightsInfo(terminalService.getAllFlights());
        System.out.println("Flights after remove:\n"+ flightsAfterRemove.toString());

    }
}
