package by.company.hotel.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Booking {
    private Integer id;
    private Integer idRoom;
    private Room room;
    private Integer idGuest;
    private Guest guest;
    private LocalDate arrival;
    private LocalDate departure;
    private BigDecimal total;
    private Integer idStaff;
    private Staff staff;

    public Booking(Integer idRoom, Integer idGuest, LocalDate arrival, LocalDate departure, BigDecimal total, Integer idStaff) {
        this.idRoom = idRoom;
        this.idGuest = idGuest;
        this.arrival = arrival;
        this.departure = departure;
        this.total = total;
        this.idStaff = idStaff;
    }

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public Room getRoom() {
        return room;
    }

    public Booking setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.CEILING);
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", idRoom=" + idRoom +
                ", room=" + room +
                ", idGuest=" + idGuest +
                ", guest=" + guest +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", total=" + total +
                ", idStaff=" + idStaff +
                ", staff=" + staff +
                '}';
    }






}
