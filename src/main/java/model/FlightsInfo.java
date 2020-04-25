package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlightsInfo {
    private Set<Flight> flightsInfo;  // рейсы для которых будет отображаться информация

    public FlightsInfo(Set<Flight> flights) {
        flightsInfo = new HashSet<>();
        flightsInfo.addAll(flights);
    }

    /**
     * <p>Возвращает текстовое представление рейсов в формате:</p>
     * .____________________.____________________.____________________.
     * | Flight #           | Departure          | Destination        |
     * |--------------------|--------------------|--------------------|
     * | 101                | ISTANBUL           | VIENNA             |
     * | 102                | KHARKOV            | PRAGUE             |
     * |____________________|____________________|____________________|
     * <p>ширина каждого столбца - 20 смиволов не счиатая символы разделители</p>
     *
     * @return - информация о рейсах
     */
    @Override
    public String toString() {
        String strInfo = String.format(".____________________.____________________.____________________.\n" +
                "| Flight #           | Departure          | Destination        |\n" +
                "|--------------------|--------------------|--------------------|\n");
        Iterator<Flight> iterInfo = flightsInfo.iterator();
        while (iterInfo.hasNext()) {
            Flight objectItem = iterInfo.next();
            strInfo = strInfo.concat(String.format("|%1$-20d|%2$-20s|%3$-20s|\n",
                    objectItem.getFlightNo(), objectItem.getDeparture(), objectItem.getDestination()));
        }
        strInfo = strInfo.concat(String.format("|____________________|____________________|____________________|"));
        return strInfo;
    }

}
