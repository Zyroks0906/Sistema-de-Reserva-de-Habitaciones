package view;

import java.util.Scanner;

public class ReservationView {
    private Scanner scanner = new Scanner(System.in);

    public void showReservationMenu() {
        System.out.println("=== Gestión de Reservas ===");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Cancelar Reserva");
        System.out.println("3. Listar Reservas");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void showReservationDetails(String reservationDetails) {
        System.out.println("=== Detalles de la Reserva ===");
        System.out.println(reservationDetails);
    }
}
