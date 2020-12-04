package by.company.hotel.bean;

public class Room {
    private Integer id;
    private Integer idRoomType;
    private RoomType roomType;
    private Integer number;

    public Room(Integer idRoomType, Integer number) {
        this.idRoomType = idRoomType;
        this.number = number;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdRoomType() {
        return idRoomType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", idRoomType=" + idRoomType +
                ", roomType=" + roomType +
                ", number=" + number +
                '}';
    }
}
