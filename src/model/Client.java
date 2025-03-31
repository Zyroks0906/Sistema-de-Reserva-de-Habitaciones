package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String name;
    private List<Reservation> activeReservations;
    private List<Reservation> pastReservations;

    //Constructor
    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.activeReservations = new ArrayList<>();
        this.pastReservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        if (activeReservations.size() >= 3) {
            throw new IllegalStateException("Máximo 3 reservas activas.");
        }
        activeReservations.add(reservation);
    }

    public void completeReservation(Reservation reservation) {
        activeReservations.remove(reservation);
        pastReservations.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> allReservations = new ArrayList<>(activeReservations);
        allReservations.addAll(pastReservations);
        return allReservations;
    }

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getActiveReservations() {
        return activeReservations;
    }

    public void setActiveReservations(List<Reservation> activeReservations) {
        this.activeReservations = activeReservations;
    }

    public List<Reservation> getPastReservations() {
        return pastReservations;
    }

    public void setPastReservations(List<Reservation> pastReservations) {
        this.pastReservations = pastReservations;
    }
}