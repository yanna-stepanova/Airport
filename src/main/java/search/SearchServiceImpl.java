package search;

import model.Flight;
import model.Route;
import terminal.TerminalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchServiceImpl implements SearchService {

    /**
     * Конструктор принимает #TerminalService для выполниения поиска по существующим рейсам
     *
     * @param terminalService - терминал
     */
    private TerminalService terminalService;

    public SearchServiceImpl(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @Override
    public List<Route> findRoutes(String departure, String destination) { //почему возвращает лист маршрутов? достаточного будет и одного маршрута
        List<Route> routeList = new ArrayList<>();
        Route route = new Route(departure, destination);
        Set<Flight> foundFlightsByDeparture = terminalService.getFlightByDeparture(departure);
        Set<Flight> foundFlightsByDestination = terminalService.getFlightByDestination(destination);
        for (Flight from : foundFlightsByDeparture) {
            for (Flight to : foundFlightsByDestination) {
                if (from.getDestination().equals(to.getDeparture())) {
                    route.getTransfers().add(from);
                    route.getTransfers().add(to);
                }
            }
        }
        routeList.add(route);
        return routeList;
    }

    @Override
    public List<Route> findRoutes(String departure, String destination, boolean direct) {
        List<Route> routeListDirect = new ArrayList<>();
        Route routeDirect = new Route(departure, destination);
        Set<Flight> foundFlightsByDeparture = terminalService.getFlightByDeparture(departure);
        Set<Flight> foundFlightsByDestination = terminalService.getFlightByDestination(destination);
        for (Flight from : foundFlightsByDeparture) {
            for (Flight to : foundFlightsByDestination) {
                if (direct) {
                    if (from.equals(to)) {
                        routeDirect.getTransfers().add(from);
                    }
                } else {
                    if (from.getDestination().equals(to.getDeparture())) {
                        routeDirect.getTransfers().add(from);
                        routeDirect.getTransfers().add(to);
                    }
                }
            }
        }
        routeListDirect.add(routeDirect);
        return routeListDirect;
    }
}