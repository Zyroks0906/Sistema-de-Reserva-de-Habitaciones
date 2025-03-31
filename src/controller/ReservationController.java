package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    private List<Reservation> reservations;

    public ReservationController() {
        this.reservations = new ArrayList<>();
    }

    public void createReservation(String id, Room room, Client client, LocalDate checkIn, LocalDate checkOut) {
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("Fechas de reserva no válidas.");
        }

        if (checkIn.until(checkOut).getDays() > 90) {
            throw new IllegalArgumentException("La reserva no puede exceder los 90 días.");
        }

        if (client.getActiveReservations().size() >= 3) {
            throw new IllegalStateException("El cliente ya tiene 3 reservas activas.");
        }

        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getNumber() == room.getNumber() &&
                !(checkOut.isBefore(reservation.getCheckIn()) || checkIn.isAfter(reservation.getCheckOut()))) {
                throw new IllegalStateException("La habitación ya está reservada en este rango de fechas.");
            }
        }

        Reservation newReservation = new Reservation(id, room, client, checkIn, checkOut);
        reservations.add(newReservation);
        client.addReservation(newReservation);
        room.setStatus(RoomStatusEnum.RESERVADA);
    }

    public void cancelReservation(String id) {
        Reservation reservation = reservations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (reservation != null && reservation.getCheckIn().isAfter(LocalDate.now())) {
            reservations.remove(reservation);
            reservation.getClient().getActiveReservations().remove(reservation);
            reservation.getRoom().setStatus(RoomStatusEnum.DISPONIBLE);
        } else {
            throw new IllegalStateException("La reserva no puede ser cancelada.");
        }
    }

    public void completeReservation(String id) {
        Reservation reservation = reservations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (reservation != null) {
            reservation.getClient().completeReservation(reservation);
            reservation.getRoom().setStatus(RoomStatusEnum.DISPONIBLE);
        }
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
