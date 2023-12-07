import java.util.Date;
class PackAnimals extends Animals {
    private int carryingCapacity;

    // Конструктор
    public PackAnimals(String name, Date birthdate, int carryingCapacity) {
        super(name, birthdate);
        this.carryingCapacity = carryingCapacity;
    }

    // Геттеры и сеттеры
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}