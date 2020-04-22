package model;

import java.util.ArrayList;
import java.util.List;

public class Route {

    /**
     * Список рейсов. Если рейс без пересадот то он будет один.
     * Если чтобы добраться из одного пункта в другой нужно сделать пересадки на другой рейс,
     * то список будет содержать все рейсы на которые нужно сделать пересадки.
     * Первым идет рейс с пунктом отправления, далее все рейсы по порядку и последний - рейс
     * с пунктом назначеия
     */
    List<Flight> transfers = new ArrayList<>();

    /**
     * @param departure   - начальный пункт
     * @param destination - конечный пункт
     */
    public Route(String departure, String destination) {

    }

    /**
     * Возвращает количество пересадок
     * Если рейс прямой то вернет 0
     * Если два рейса то 1 и т.д.
     *
     * @return - количество пересадок.
     */
    public int getNumberOfTransfer() {
        return 0;
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
        return null;
    }
}
