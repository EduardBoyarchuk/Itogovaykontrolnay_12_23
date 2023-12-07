import java.util.Date;
class Camels extends PackAnimals {
    private String hump;

    // Конструктор
    public Camels(String name, Date birthdate, int carryingCapacity, String hump) {
        super(name, birthdate, carryingCapacity);
        this.hump = hump;
    }

    // Геттеры и сеттеры
    public String getHump() {
        return hump;
    }

    public void setHump(String hump) {
        this.hump = hump;
    }
}