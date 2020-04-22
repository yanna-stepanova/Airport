package search;

import model.Route;
import terminal.TerminalService;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    /**
     * Конструктор принимает #TerminalService для выполниения поиска по существующим рейсам
     *
     * @param terminalService - терминал
     */
    public SearchServiceImpl(TerminalService terminalService) {

    }

    @Override
    public List<Route> findRoutes(String departure, String destination) {
        return null;
    }

    @Override
    public List<Route> findRoutes(String departure, String destination, boolean direct) {
        return null;
    }
}
