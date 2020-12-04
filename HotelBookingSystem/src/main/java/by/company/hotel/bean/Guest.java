package by.company.hotel.bean;

import java.time.LocalDate;

public class Guest {
    private Integer id;
    private String name;
    private String document;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;

    public Guest(String name, String document, LocalDate birthDate, String email, String phoneNumber) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Guest() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
