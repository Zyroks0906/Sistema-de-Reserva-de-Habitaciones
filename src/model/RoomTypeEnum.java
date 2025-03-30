package model;

public enum RoomTypeEnum {
    INDIVIDUAL(50),
    DOBLE(80),
    SUITE(150);

    private double price;

    RoomTypeEnum(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}