package info;

import model.Flight;
import model.FlightsInfo;
import org.junit.Before;
import org.junit.Test;
import terminal.TerminalService;
import terminal.TerminalServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Constants.FLIGHT_NO_101;
import static util.Constants.FLIGHT_NO_102;
import static util.Constants.ISTANBUL;
import static util.Constants.KHARKOV;
import static util.Constants.PRAGUE;
import static util.Constants.VIENNA;

public class InfoCenterServiceImplTest {
    private static final String TABLE_INFO_PATTERN = "((\\._{20}){3}\\.)\\s" +
            "(\\|.{20}){3}\\|\\s" +
            "(\\|-{20}){3}\\|\\s" +
            "((\\|.{20}){3}\\|\\s)+" +
            "(\\|_{20}){3}\\|";
    private TerminalService terminalService = new TerminalServiceImpl();
    private InfoCenterServiceImpl infoCenterService = new InfoCenterServiceImpl(terminalService);
    private Flight istanbulVienna;
    private Flight kharkovPrague;

    @Before
    public void setUp() {
        istanbulVienna = new Flight(FLIGHT_NO_101, ISTANBUL, VIENNA);
        kharkovPrague = new Flight(FLIGHT_NO_102, KHARKOV, PRAGUE);
        Set<Flight> flights = new HashSet<Flight>() {{
            add(istanbulVienna);
            add(kharkovPrague);
        }};
        terminalService.addAllFlights(flights);
    }

    @Test
    public void shouldReturnInfo() {
        FlightsInfo actualResult = infoCenterService.getAllFlights();

        assertThat(actualResult.toString()).containsPattern(TABLE_INFO_PATTERN);
    }

    @Test
    public void shouldReturnInfoFilteredByDeparture() {
        FlightsInfo actualResult = infoCenterService.getFlightsFrom(ISTANBUL);

        assertThat(actualResult.toString()).containsPattern(TABLE_INFO_PATTERN);
        assertThat(actualResult.toString()).containsPattern(ISTANBUL);
    }

}
