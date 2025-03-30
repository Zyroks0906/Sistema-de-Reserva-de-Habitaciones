package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private String id;
    private Room room;
    private Client client;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;

    //Constructor
    public Reservation(String id, Room room, Client client, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.room = room;
        this.client = client;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = calculateTotalPrice();
    }

    //getters y setters
    private double calculateTotalPrice() {
        long days = ChronoUnit.DAYS.between(checkIn, checkOut);
        return days * room.getType().getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}