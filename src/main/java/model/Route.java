package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Route {

    /**
     * Список рейсов. Если рейс без пересадок, то он будет один.
     * Если чтобы добраться из одного пункта в другой нужно сделать пересадки на другой рейс,
     * то список будет содержать все рейсы на которые нужно сделать пересадки.
     * Первым идет рейс с пунктом отправления, далее все рейсы по порядку и последний - рейс
     * с пунктом назначеия
     */
    private List<Flight> transfers = new ArrayList<>();
    private String departure;
    private String destination;

    /**
     * @param departure   - начальный пункт
     * @param destination - конечный пункт
     */
    public Route(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;

    }

    /**
     * Возвращает количество пересадок
     * Если рейс прямой, то вернет 0
     * Если два рейса, то 1 и т.д.
     *
     * @return - количество пересадок.
     */
    public int getNumberOfTransfer() {
        return (transfers.size() - 1);
    }

    /**
     * Текстовое представление маршрута:
     * .____________________.____________________.____________________.
     * | Departure          | KHARKOV            |                    |
     * | 201                | KHARKOV            | ISTANBUL           |
     * | 108                | ISTANBUL           | NEW YORK           |
     * | Destination        | NEW YORK           |                    |
     * |____________________|____________________|____________________|
     *
     * @return
     */
    @Override
    public String toString() {
        String strRoute = String.format(".____________________.____________________.____________________.\n" +
                "| Departure          | %1$-19s|                    |\n" +
                "|____________________|____________________|____________________|\n", departure);
        Iterator<Flight> iterator = transfers.iterator();
        while (iterator.hasNext()) {
            Flight objectRoute = iterator.next();
            strRoute = strRoute.concat(String.format("|  %1$-18d| %2$-19s| %3$-19s|\n",
                    objectRoute.getFlightNo(), objectRoute.getDeparture(), objectRoute.getDestination()));
        }
        strRoute = strRoute.concat(String.format("| Destination        | %1$-19s|                    |\n" +
                "|____________________|____________________|____________________|\n", destination));
        return strRoute;
    }

    public List<Flight> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Flight> transfers) {
        this.transfers = transfers;
    }
}