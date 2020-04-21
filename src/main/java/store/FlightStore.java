package store;

import model.Flight;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static store.Cities.BERLIN;
import static store.Cities.ISTANBUL;
import static store.Cities.KHARKOV;
import static store.Cities.KIEV;
import static store.Cities.KRAKOW;
import static store.Cities.LONDON;
import static store.Cities.NEW_YORK;
import static store.Cities.PRAGUE;
import static store.Cities.ROME;
import static store.Cities.VIENNA;

/**
 * Класс который хранит все рейсы
 */
public final class FlightStore {
    private final static List<Flight> flightStore = new LinkedList<>();

    static {
        flightStore.add(new Flight(2010, KHARKOV, PRAGUE));
        flightStore.add(new Flight(1002, PRAGUE, KHARKOV));
        flightStore.add(new Flight(4010, VIENNA, PRAGUE));
        flightStore.add(new Flight(407, VIENNA, KRAKOW));
        flightStore.add(new Flight(702, KRAKOW, KHARKOV));
        flightStore.add(new Flight(201, KHARKOV, ISTANBUL));
        flightStore.add(new Flight(102, ISTANBUL, KHARKOV));
        flightStore.add(new Flight(103, ISTANBUL, KIEV));
        flightStore.add(new Flight(108, ISTANBUL, NEW_YORK));
        flightStore.add(new Flight(409, VIENNA, ROME));
        flightStore.add(new Flight(901, ROME, ISTANBUL));
        flightStore.add(new Flight(302, KIEV, KHARKOV));
        flightStore.add(new Flight(801, NEW_YORK, ISTANBUL));
        flightStore.add(new Flight(405, VIENNA, LONDON));
        flightStore.add(new Flight(504, LONDON, VIENNA));
        flightStore.add(new Flight(506, LONDON, BERLIN));
        flightStore.add(new Flight(605, BERLIN, LONDON));
    }

    /**
     * Возаращает копию листа <code>flightStore</code>
     *
     * @return - flightStore, все доступные рейсы
     */
    public static List<Flight> getFlightStore() {
        return flightStore;
    }

    /**
     * Добавляет список рейсов в стор.
     * Если рейс с номером уже существует его нужно заменить на новый
     *
     * @param flights - список рейсов
     */
    public static void addFlightsToStore(Set<Flight> flights) {
        boolean isAdded = false;
        Iterator<Flight> flightIterator = flights.iterator();
        while (flightIterator.hasNext()){
            for (int i=0; i<flightStore.size(); i++){
                if(flightStore.get(i).getFlightNo()==flightIterator.next().getFlightNo()){
                    flightStore.set(i, flightIterator.next());
                    isAdded = true;
                }
            }
            if(!isAdded){
                flightStore.add(flightIterator.next());
            }
        }
    }

    /**
     * Удаляет рейс по номеру
     *
     * @param flightNo - номер рейса
     * @return true - если рейс удален, false - если рейс не был найден или по другой причине не может быть удален
     */
    public static boolean deleteFromStore(long flightNo) {
        boolean isDeleted = false;
        Iterator<Flight> iterStore = flightStore.iterator();
        while (iterStore.hasNext()){
            if (iterStore.next().getFlightNo()==flightNo){
                iterStore.remove();
                isDeleted=true;
                break;
            }
        }
        return isDeleted;
    }

    private FlightStore() {
        throw new UnsupportedOperationException();
    }
}
