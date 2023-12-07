import java.util.Date;
class Horses extends PackAnimals {
    private String ridingAbility;

    // Конструктор
    public Horses(String name, Date birthdate, int carryingCapacity, String ridingAbility) {
        super(name, birthdate, carryingCapacity);
        this.ridingAbility = ridingAbility;
    }

    // Геттеры и сеттеры
    public String getRidingAbility() {
        return ridingAbility;
    }

    public void setRidingAbility(String ridingAbility) {
        this.ridingAbility = ridingAbility;
    }
}