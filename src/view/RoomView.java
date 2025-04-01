package view;

import model.Room;
import controller.RoomController;

import java.util.List;
import java.util.Scanner;

public class RoomView {
    private Scanner scanner = new Scanner(System.in);

    public void showRoomMenu() {
        System.out.println("\n === Gestión de Habitaciones ===");
        System.out.println("1. Listar Habitaciones");
        System.out.println("2. Ver Detalles de una Habitación");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public void listRooms(List<Room> rooms) {
        System.out.println("\n === Lista de Habitaciones ===");
        for (Room room : rooms) {
            System.out.println("Número: " + room.getNumber() + " | Tipo: " + room.getType() + " | Estado: " + room.getStatus() + " | Descripción: " + room.getDescription());
        }
    }

    public void showRoomDetails(Room room) {
        System.out.println("\n === Detalles de la Habitación ===");
        System.out.println("Número: " + room.getNumber());
        System.out.println("Tipo: " + room.getType());
        System.out.println("Estado: " + room.getStatus());
        System.out.println("Descripción: " + room.getDescription());
    }

    public int getRoomNumberInput() {
        try {
            System.out.print("Ingrese el número de la habitación: ");
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return -1;
        }
    }

    public void handleRoomManagement(RoomController roomController) {
        int roomChoice = 0;
        do {
            showRoomMenu();
            try {
                roomChoice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue; // Reintenta mostrar el menú
            }

            switch (roomChoice) {
                case 1:
                    listRooms(roomController.getAllRooms());
                    break;
                case 2:
                    int roomNumber = getRoomNumberInput();
                    if (roomNumber != -1) { // Verifica si la entrada fue válida
                        Room room = roomController.getRoomByNumber(roomNumber);
                        if (room != null) {
                            showRoomDetails(room);
                        } else {
                            System.out.println("Habitación no encontrada.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (roomChoice != 3);
    }
}
