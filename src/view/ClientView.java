package view;

import java.util.Scanner;

public class ClientView {
    private Scanner scanner = new Scanner(System.in);

    public void showClientMenu() {
        System.out.println("=== Gestión de Clientes ===");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Ver Historial de Reservas de un Cliente");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void showClientDetails(String clientDetails) {
        System.out.println("=== Detalles del Cliente ===");
        System.out.println(clientDetails);
    }
}
