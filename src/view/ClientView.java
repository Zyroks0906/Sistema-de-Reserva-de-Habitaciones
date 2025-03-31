package view;

import model.Client;
import controller.ClientController;

import java.util.List;
import java.util.Scanner;

public class ClientView {
    private Scanner scanner = new Scanner(System.in);

    public void showClientMenu() {
        System.out.println("\n === Gestión de Clientes ===");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Ver Detalles de un Cliente");
        System.out.println("3. Registrar Nuevo Cliente");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
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

    public void showClientDetails(Client client) {
        System.out.println("\n === Detalles del Cliente ===");
        System.out.println("ID: " + client.getId());
        System.out.println("Nombre: " + client.getName());
        System.out.println("Reservas Activas: " + client.getActiveReservations().size());
        System.out.println("Historial de Reservas: " + client.getPastReservations().size());
    }

    public void listClients(List<Client> clients) {
        System.out.println("\n === Lista de Clientes ===");
        for (Client client : clients) {
            System.out.println("ID: " + client.getId() + " | Nombre: " + client.getName());
        }
    }

    public String getClientIdInput() {
        System.out.print("Ingrese el ID del cliente: ");
        return scanner.nextLine();
    }

    public String getClientNameInput() {
        System.out.print("Ingrese el nombre del cliente: ");
        return scanner.nextLine();
    }

    public void handleClientManagement(ClientController clientController) {
        int clientChoice;
        do {
            showClientMenu();
            clientChoice = getUserChoice();
            switch (clientChoice) {
                case 1:
                    listClients(clientController.getAllClients());
                    break;
                case 2:
                    String clientId = getClientIdInput();
                    Client client = clientController.getClientById(clientId);
                    if (client != null) {
                        showClientDetails(client);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    String newClientId = getClientIdInput();
                    if (clientController.clientExists(newClientId)) {
                        System.out.println("El cliente ya existe.");
                    } else {
                        String newClientName = getClientNameInput();
                        clientController.addClient(newClientId, newClientName);
                        System.out.println("Cliente registrado exitosamente.");
                    }
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (clientChoice != 4);
    }
}
