package model;

public class Room {
    private int number;
    private RoomTypeEnum type;
    private RoomStatusEnum status;
    private String description;

    //Constructor
    public Room(int number, RoomTypeEnum type, String description) {
        this.number = number;
        this.type = type;
        this.status = RoomStatusEnum.DISPONIBLE;
        this.description = description;
    }

    // Getters y Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomTypeEnum getType() {
        return type;
    }

    public void setType(RoomTypeEnum type) {
        this.type = type;
    }

    public RoomStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RoomStatusEnum status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}