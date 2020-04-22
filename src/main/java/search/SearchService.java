package search;

import model.Route;

import java.util.List;

public interface SearchService {
    /**
     * Находит маршруты по указанным параметрам.
     * Возвращает все возможные маршруты, включая с пересадками
     *
     * @param departure   - место отправления
     * @param destination - мето прибытия
     * @return - список найденых маршрутов, пустой список если по заданным параметрам ничего не найдено
     */
    List<Route> findRoutes(String departure, String destination);

    /**
     * Находит маршруты по указанным параметрам
     *
     * @param departure - место отправления
     * @param destination - мето прибытия
     * @param direct - если true, то ищет только прямые направления
     * @return - список найденых маршрутов, пустой список если по заданным параметрам ничего не найдено
     */
    List<Route> findRoutes(String departure, String destination, boolean direct);
}
