package terminal;

import model.Flight;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Constants.FLIGHT_NO_101;
import static util.Constants.FLIGHT_NO_102;
import static util.Constants.ISTANBUL;
import static util.Constants.KHARKOV;
import static util.Constants.PRAGUE;
import static util.Constants.VIENNA;

public class TerminalServiceTest {

    private TerminalService terminalService = new TerminalServiceImpl();
    private Set<Flight> flights;
    private Flight istanbulVienna;
    private Flight kharkovPrague;

    @Before
    public void setUp() {
        istanbulVienna = new Flight(FLIGHT_NO_101, ISTANBUL, VIENNA);
        kharkovPrague = new Flight(FLIGHT_NO_102, KHARKOV, PRAGUE);
        flights = new HashSet<Flight>() {{
            add(istanbulVienna);
            add(kharkovPrague);
        }};
    }

    @Test
    public void shouldShowAllAvailableFlights() {
        //given
        terminalService.addAllFlights(flights);

        //when
        List<Flight> actualFlights = new ArrayList<>(terminalService.getAllFlights());

        //then
        assertThat(actualFlights).containsExactlyElementsOf(new ArrayList<>(flights));
    }

    @Test
    public void shouldFindFlightsByDeparture() {
        terminalService.addAllFlights(flights);

        List<Flight> actualResult = new ArrayList<>(terminalService.getFlightByDeparture(KHARKOV));

        assertThat(actualResult).extracting("departure").containsExactly(KHARKOV);
    }

    @Test
    public void shouldFindFlightsByDestination() {
        terminalService.addAllFlights(flights);

        List<Flight> actualResult = new ArrayList<>(terminalService.getFlightByDestination(VIENNA));

        assertThat(actualResult).extracting("destination").containsExactly(VIENNA);
    }

    @Test
    public void shouldFindFlightByNumber() {
        terminalService.addAllFlights(flights);

        Flight actualResult = terminalService.getFlightByNumber(FLIGHT_NO_101);

        assertThat(actualResult).extracting("flightNo").isEqualTo(FLIGHT_NO_101);
    }

    @Test
    public void shouldRemoveFlightByNumber() {
        terminalService.addAllFlights(flights);

        boolean isRemoved = terminalService.removeFlightByNumber(FLIGHT_NO_101);

        assertThat(isRemoved).isTrue();
        List<Flight> actualFlights = new ArrayList<>(terminalService.getAllFlights());
        assertThat(actualFlights).containsOnlyOnce(kharkovPrague);
    }
}
