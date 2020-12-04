package by.company.hotel.bean;

public class Staff {
    private Integer id;
    private String name;
    private AccessLevel accessLevel;
    private String login;
    private String password;

    public Staff(String name, AccessLevel accessLevel, String login, String password) {
        this.name = name;
        this.accessLevel = accessLevel;
        this.login = login;
        this.password = password;
    }

    public Staff() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessLevel=" + accessLevel +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
