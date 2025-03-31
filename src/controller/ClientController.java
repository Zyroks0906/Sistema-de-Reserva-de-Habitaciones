package controller;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private List<Client> clients;

    public ClientController() {
        this.clients = new ArrayList<>();
    }

    public void addClient(String id, String name) {
        clients.add(new Client(id, name));
    }

    public Client getClientById(String id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Client> getAllClients() {
        return clients;
    }
}
