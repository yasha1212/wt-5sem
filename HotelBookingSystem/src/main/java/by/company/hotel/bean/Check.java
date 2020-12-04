package by.company.hotel.bean;

import java.time.LocalDateTime;

public class Check {
    private Integer id;
    private LocalDateTime check;
    private Integer idStaff;
    private Integer idBooking;
    private Boolean status;

    public Check(LocalDateTime check, Integer idStaff, Integer idBooking, Boolean status) {
        this.check = check;
        this.idStaff = idStaff;
        this.idBooking = idBooking;
        this.status = status;
    }

    public Check() {
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCheck() {
        return check;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", check=" + check +
                ", idStaff=" + idStaff +
                ", idBooking=" + idBooking +
                ", status=" + status +
                '}';
    }
}
