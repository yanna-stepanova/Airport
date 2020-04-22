import info.InfoCenterService;
import info.InfoCenterServiceImpl;
import model.Flight;
import model.FlightsInfo;
import terminal.TerminalService;
import terminal.TerminalServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        //можно здесь писать код, чтобы проверить, что все ваши сервисы работают правильно
        Set<Flight> flightsSet = new HashSet<>();
        flightsSet.add(new Flight(301, "Kiev", "Vienna"));
        flightsSet.add(new Flight(303, "Kiev", "Istanbul"));
        flightsSet.add(new Flight(305, "Kiev", "Paris"));
        flightsSet.add(new Flight(202, "Kharkov", "Kiev"));
        flightsSet.add(new Flight(304, "Paris", "Kiev"));
        flightsSet.add(new Flight(201, "Kharkov", "Istanbul"));
        flightsSet.add(new Flight(407, "Vienna", "Krakow"));
        flightsSet.add(new Flight(405, "Vienna", "London"));

        TerminalService terminalService = new TerminalServiceImpl();
        terminalService.addAllFlights(flightsSet);
        InfoCenterService infoCS = new InfoCenterServiceImpl(terminalService);
        System.out.println("All flights:\n"+infoCS.getAllFlights().toString());
        System.out.println("\nFrom Kiev:\n"+infoCS.getFlightsFrom("Kiev").toString());

        FlightsInfo flFromKiev = new FlightsInfo(terminalService.getFlightByDeparture("Vienna"));
        System.out.println("\nFlights from Vienna:\n"+flFromKiev.toString());

        FlightsInfo flTo = new FlightsInfo(terminalService.getFlightByDestination("Istanbul"));
        System.out.println("\nFlights to Istanbul:\n"+flTo.toString());

        Flight flighFinded = terminalService.getFlightByNumber(202);
        System.out.println("\nThe flight is '"+ flighFinded.getFlightNo() + "' from - "+ flighFinded.getDeparture()+
                            ", to - " + flighFinded.getDestination());

        terminalService.removeFlightByNumber(202);
        FlightsInfo flightsAfterRemove = new FlightsInfo(terminalService.getAllFlights());
        System.out.println("\nFlights after remove '202':\n"+ flightsAfterRemove.toString());









    }
}
