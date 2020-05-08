package model;

public class Flight {
    private final long flightNo;        // номер рейса
     private final String departure;    // место отправления
     private final String destination;  // место брибытия

    public Flight(long flightNo, String departure, String destination){
        this.flightNo = flightNo;
        this.departure = departure;
        this.destination = destination;
    }

    public long getFlightNo() {
        return flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }


}
