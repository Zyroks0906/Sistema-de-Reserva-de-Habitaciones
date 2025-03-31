import java.util.Scanner;
import controller.*;
import view.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        ClientController clientController = new ClientController();
        ReservationController reservationController = new ReservationController();
        RoomController roomController = new RoomController();
        HotelView view = new HotelView(clientController, reservationController, roomController);
        view.showMainMenu();
    }
}
