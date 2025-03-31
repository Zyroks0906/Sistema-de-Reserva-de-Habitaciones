package view;

import java.util.Scanner;
import controller.ClientController;
import controller.ReservationController;
import controller.RoomController;
import model.Room;
import model.Client;
import view.ReservationView;

public class MainView {
    private Scanner scanner = new Scanner(System.in);
    private ClientController clientController;
    private ReservationController reservationController;
    private RoomController roomController;
    private RoomView roomView = new RoomView();
    private ClientView clientView = new ClientView();
    private ReservationView reservationView = new ReservationView();

    public MainView(ClientController clientController, ReservationController reservationController, RoomController roomController) {
        this.clientController = clientController;
        this.reservationController = reservationController;
        this.roomController = roomController;
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\n=== Sistema de Reserva de Habitaciones ===");
            System.out.println("1. Gestionar Habitaciones");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    roomView.handleRoomManagement(roomController);
                    break;
                case 2:
                    handleClientManagement();
                    break;
                case 3:
                    reservationView.handleReservationManagement(reservationController, roomController, clientController);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 4);
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

    private void handleClientManagement() {
        clientView.handleClientManagement(clientController);
    }
}
