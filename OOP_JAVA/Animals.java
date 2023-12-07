import java.util.Date;
class Animals {
    private String name;
    private Date birthdate;

    // Конструктор
    public Animals(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}