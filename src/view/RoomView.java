package view;

import java.util.Scanner;

public class RoomView {
    private Scanner scanner = new Scanner(System.in);

    public void showRoomMenu() {
        System.out.println("=== Gestión de Habitaciones ===");
        System.out.println("1. Listar Habitaciones");
        System.out.println("2. Ver Detalles de una Habitación");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void showRoomDetails(String roomDetails) {
        System.out.println("=== Detalles de la Habitación ===");
        System.out.println(roomDetails);
    }
}
