package com.example.tikkets;

public class BusTicket {
    private String departurePoint;
    private String arrivalPoint;
    private String departureDate;
    private String travelTime;
    private int distance;
    private float ticketFullPrice;
    private BusTicketType type;

    public BusTicket(String departurePoint, String arrivalPoint, String departureDate,
                     String travelTime, int distance, float ticketFullPrice,
                     BusTicketType type) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.departureDate = departureDate;
        this.travelTime = travelTime;
        this.distance = distance;
        this.ticketFullPrice = ticketFullPrice;
        this.type = type;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getTicketFullPrice() {
        return ticketFullPrice;
    }

    public void setTicketFullPrice(float ticketFullPrice) {
        this.ticketFullPrice = ticketFullPrice;
    }

    public float getTicketPrice(){
        switch (type){
            case CHILD:
                return ticketFullPrice * 0.5f;
            case PENSIONER:
                return ticketFullPrice * 0.7f;
            default:
                return ticketFullPrice;
        }
    }

    public BusTicketType getType() {
        return type;
    }

    public void setType(BusTicketType type) {
        this.type = type;
    }

    public String ticketTypeTitle(){
        switch (type){
            case FULL:
                return "полный";
            case CHILD:
                return "детский";
            case PENSIONER:
                return "пенсионный";
        }
        return "";

    }
    @Override
    public String toString() {
        return "Билет: " + departurePoint + " - " + arrivalPoint + ", " + ticketTypeTitle() + "\n" +
                "Отправление " + departureDate + "\n" +
                "Время пути " + travelTime + "\n" +
                "Стоимость " + getTicketPrice() + " монет\n";
    }
}
