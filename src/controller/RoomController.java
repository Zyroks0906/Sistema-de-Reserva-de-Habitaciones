package controller;

import model.Room;
import model.RoomStatusEnum;
import model.RoomTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class RoomController {
    private List<Room> rooms;

    public RoomController() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(int number, RoomTypeEnum type, String description) {
        rooms.add(new Room(number, type, description));
    }

    public Room getRoomByNumber(int number) {
        return rooms.stream()
                .filter(room -> room.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public void updateRoomStatus(int number, RoomStatusEnum status) {
        Room room = getRoomByNumber(number);
        if (room != null) {
            room.setStatus(status);
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}
