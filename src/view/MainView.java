package view;

import java.util.Scanner;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("=== Sistema de Reserva de Habitaciones ===");
        System.out.println("1. Gestionar Habitaciones");
        System.out.println("2. Gestionar Clientes");
        System.out.println("3. Gestionar Reservas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }
}
