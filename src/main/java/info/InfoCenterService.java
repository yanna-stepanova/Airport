package info;

import model.FlightsInfo;

/**
 * Сервис кторый выдает информацию о рейсах
 */
public interface InfoCenterService {
    /**
     * Собирает информацию о всех рейсах и помещает их в <code>FlightsInfo</code>
     *
     * @return FlightsInfo - информация о всех рейсах
     */
    FlightsInfo getAllFlights();

    /**
     * Собирает информацию о всех рейсах, которые отправляются из указанного места <code>departure</code>
     *
     * @param departure место отправления
     * @return FlightsInfo- информация о рейсах отфильтрованных по месту отправления
     */
    FlightsInfo getFlightsFrom(String departure);
}
