package controller;

import model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

        if (ChronoUnit.DAYS.between(checkIn, checkOut) > 90) {
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
        client.getActiveReservations().add(newReservation); // Agregar a reservas activas
        client.getPastReservations().add(newReservation);   // Registrar en el historial
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
            // Remover de reservas activas
            reservation.getClient().getActiveReservations().remove(reservation);

            // Registrar en el historial (ya está en pastReservations, no es necesario agregarlo de nuevo)
            reservation.getRoom().setStatus(RoomStatusEnum.DISPONIBLE);
        } else {
            throw new IllegalStateException("La reserva no existe.");
        }
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public List<Reservation> getActiveReservationsByClient(Client client) {
        List<Reservation> activeReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getClient().equals(client) && reservation.getCheckIn().isAfter(LocalDate.now())) {
                activeReservations.add(reservation);
            }
        }
        return activeReservations;
    }
}
