package terminal;

import model.Flight;

import java.util.Set;

public interface TerminalService {

    /**
     * Добавляет все рейсы из коллекции flights
     *
     * @param flights - список рейсов которые необходимо добаавить
     */
    void addAllFlights(Set<Flight> flights);

    /**
     * Возвращает все доступные рейсы
     *
     * @return все доступные рейсы или пустой <code>Set</code> если рейсов нет
     */
    Set<Flight> getAllFlights();

    /**
     * Возвращает все рейсы, у которыx станция отправления равна <code>departure</code>
     *
     * @param departure - станция отправления
     * @return рейсы, кторые отправляются с <code>departure</code>
     */
    Set<Flight> getFlightByDeparture(String departure);

    /**
     * Возвращает все рейсы, у который станция прибытия равна <code>departure</code>
     *
     * @param destination станция прибытия
     * @return рейсы, кторые прибывают на <code>departure</code>
     */
    Set<Flight> getFlightByDestination(String destination);

    /**
     * Ищет рейс по нореру
     *
     * @param flightNo - номер рейса
     * @return - Рейс с номером <code>flightNo</code>
     */
    Flight getFlightByNumber(long flightNo);

    /**
     * Ищет рейс по номеру и удаляет его;
     *
     * @param flightNo - номер рейса
     * @return - true - если рейс удален, false - если рейс не был найден или по другой причине не может быть удален
     */
    boolean removeFlightByNumber(long flightNo);
}
