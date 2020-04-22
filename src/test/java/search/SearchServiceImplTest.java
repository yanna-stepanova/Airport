package search;

import terminal.TerminalService;
import terminal.TerminalServiceImpl;

public class SearchServiceImplTest {

    TerminalService terminalService = new TerminalServiceImpl();
    SearchService searchService = new SearchServiceImpl(terminalService);

    
}
