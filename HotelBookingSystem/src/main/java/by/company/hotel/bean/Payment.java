package by.company.hotel.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;


public class Payment {
    private Integer id;
    private BigDecimal value;
    private PaymentMethod paymentMethod;
    private Integer idBooking;
    private Booking booking;
    private LocalDateTime payTime;
    private Integer idStaff;

    public Payment(Integer id, BigDecimal value, PaymentMethod paymentMethod, Integer idBooking,LocalDateTime payTime, Integer idStaff) {
        this.id = id;
        this.value = value;
        this.paymentMethod = paymentMethod;
        this.idBooking = idBooking;
        this.payTime = payTime;
        this.idStaff = idStaff;
    }

    public Payment() {
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value.setScale(2, RoundingMode.CEILING);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public Booking getBooking() {
        return booking;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", value=" + value +
                ", paymentMethod=" + paymentMethod +
                ", idBooking=" + idBooking +
                ", booking=" + booking +
                '}';
    }
}
