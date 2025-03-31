import controller.*;
import view.MainView;
import model.*;

public class App {
    public static void main(String[] args) throws Exception {
        ClientController clientController = new ClientController();
        ReservationController reservationController = new ReservationController();
        RoomController roomController = new RoomController();
        MainView view = new MainView(clientController, reservationController, roomController);

        roomController.addRoom(101, RoomTypeEnum.INDIVIDUAL, "Habitación individual con cama matrimonial");
        roomController.addRoom(102, RoomTypeEnum.DOBLE, "Habitación doble con dos camas individuales");
        roomController.addRoom(103, RoomTypeEnum.SUITE, "Suite con jacuzzi y vista al mar");
        roomController.addRoom(104, RoomTypeEnum.INDIVIDUAL, "Habitación individual con cama matrimonial");
        roomController.addRoom(105, RoomTypeEnum.DOBLE, "Habitación doble con dos camas individuales");
        roomController.addRoom(201, RoomTypeEnum.SUITE, "Suite con jacuzzi y vista al mar");
        roomController.addRoom(202, RoomTypeEnum.INDIVIDUAL, "Habitación individual con cama matrimonial");
        roomController.addRoom(203, RoomTypeEnum.DOBLE, "Habitación doble con dos camas individuales");
        roomController.addRoom(204, RoomTypeEnum.SUITE, "Suite con jacuzzi y vista al mar");
        roomController.addRoom(205, RoomTypeEnum.INDIVIDUAL, "Habitación individual con cama matrimonial");
        roomController.addRoom(301, RoomTypeEnum.DOBLE, "Habitación doble con dos camas individuales");
        roomController.addRoom(302, RoomTypeEnum.SUITE, "Suite con jacuzzi y vista al mar");
        roomController.addRoom(303, RoomTypeEnum.INDIVIDUAL, "Habitación individual con cama matrimonial");
        roomController.addRoom(304, RoomTypeEnum.DOBLE, "Habitación doble con dos camas individuales");
        roomController.addRoom(305, RoomTypeEnum.SUITE, "Suite con jacuzzi y vista al mar");

        clientController.addClient("010", "Juan Pérez");
        clientController.addClient("020", "María López");
        clientController.addClient("030", "Carlos García");

        view.showMainMenu();
    }
}
