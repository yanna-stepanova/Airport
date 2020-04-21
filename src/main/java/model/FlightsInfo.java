package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlightsInfo {
    private Set<Flight> flights = new HashSet<>();  // рейсы для которых будет отображаться информация

    public FlightsInfo(Set<Flight> flights) {
        Iterator<Flight> iteratorFlights = flights.iterator();
        while (iteratorFlights.hasNext()) {
            this.flights.add(new Flight(iteratorFlights.next().getFlightNo(), iteratorFlights.next().getDeparture(),
                    iteratorFlights.next().getDestination()));
        }
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
        do {
            return String.format(".____________________.____________________.____________________.\n" +
                            "| Flight #           | Departure          | Destination        |\n" +
                            "|--------------------|--------------------|--------------------|\n" +
                            "|%1$-20d|%2$-20s|%3$-20s|\n" +
                            "|____________________|____________________|____________________|",
                    flights.iterator().next().getFlightNo(), flights.iterator().next().getDeparture(),
                    flights.iterator().next().getDestination());
        }
        while (flights.iterator().hasNext());
    }

}
