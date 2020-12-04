package by.company.hotel.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoomType {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal dailyPrice;

    public RoomType(String name, String description, BigDecimal dailyPrice) {
        this.name = name;
        this.description = description;
        this.dailyPrice = dailyPrice;
    }

    public RoomType() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDailyPrice() {
        return dailyPrice.setScale(2, RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dailyPrice=" + dailyPrice +
                '}';
    }
}
