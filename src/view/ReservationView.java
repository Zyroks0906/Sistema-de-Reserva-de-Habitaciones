package view;

import model.*;
import controller.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationView {
    private Scanner scanner = new Scanner(System.in);

    public void showReservationMenu() {
        System.out.println("\n === Gestión de Reservas ===");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Cancelar Reserva");
        System.out.println("3. Listar Reservas");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }


    public void showReservationDetails(Reservation reservation) {
        System.out.println("\n === Detalles de la Reserva ===");
        System.out.println("ID: " + reservation.getId());
        System.out.println("Habitación: " + reservation.getRoom().getNumber());
        System.out.println("Cliente: " + reservation.getClient().getName());
        System.out.println("Check-in: " + reservation.getCheckIn());
        System.out.println("Check-out: " + reservation.getCheckOut());
        System.out.println("Precio Total: " + reservation.getTotalPrice());
    }

    public void listReservations(List<Reservation> reservations) {
        System.out.println("\n === Lista de Reservas ===");
        for (Reservation reservation : reservations) {
            System.out.println("ID: " + reservation.getId() + " | Habitación: " + reservation.getRoom().getNumber() + " | Cliente: " + reservation.getClient().getName());
        }
    }

    public String getReservationIdInput() {
        System.out.print("Ingrese el ID de la reserva: ");
        return scanner.nextLine().trim();
    }

    public LocalDate getDateInput(String prompt) {
        System.out.print(prompt + " (YYYY-MM-DD): ");
        return LocalDate.parse(scanner.nextLine());
    }

    public String getClientIdInput() {
        System.out.print("Ingrese el ID del cliente: ");
        return scanner.nextLine().trim();
    }

    public int getRoomNumberInput() {
        System.out.print("Ingrese el número de la habitación: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Número de habitación no válido. Intente de nuevo.");
            return getRoomNumberInput(); // Reintentar en caso de error
        }
    }

    public int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    public void handleReservationManagement(ReservationController reservationController, RoomController roomController, ClientController clientController) {
        int choice;
        do {
            showReservationMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    createReservation(reservationController, roomController, clientController);
                    break;
                case 2:
                    cancelReservation(reservationController);
                    break;
                case 3:
                    listReservations(reservationController.getAllReservations());
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 4);
    }

    private void createReservation(ReservationController reservationController, RoomController roomController, ClientController clientController) {
        try {
            String reservationId = getReservationIdInput();

            // Obtener número de habitación
            int roomNumber = getRoomNumberInput();
            Room room = roomController.getRoomByNumber(roomNumber);
            if (room == null || room.getStatus() != RoomStatusEnum.DISPONIBLE) {
                System.out.println("La habitación no está disponible o no existe.");
                return;
            }

            // Obtener ID del cliente
            String clientId = getClientIdInput();
            Client client = clientController.getClientById(clientId);
            if (client == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }

            // Obtener fechas de check-in y check-out
            LocalDate checkIn;
            LocalDate checkOut;
            try {
                checkIn = getDateInput("Ingrese la fecha de check-in");
                checkOut = getDateInput("Ingrese la fecha de check-out");
            } catch (Exception e) {
                System.out.println("Formato de fecha no válido. Use el formato YYYY-MM-DD.");
                return;
            }

            // Crear la reserva
            reservationController.createReservation(reservationId, room, client, checkIn, checkOut);
            System.out.println("Reserva creada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al crear la reserva: " + e.getMessage());
        }
    }

    private void cancelReservation(ReservationController reservationController) {
        try {
            String reservationId = getReservationIdInput();
            reservationController.cancelReservation(reservationId);
            System.out.println("Reserva cancelada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
        }
    }
}
