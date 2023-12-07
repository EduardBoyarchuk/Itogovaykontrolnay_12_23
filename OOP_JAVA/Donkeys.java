import java.util.Date;
class Donkeys extends PackAnimals {
    private String harness;

    // Конструктор
    public Donkeys(String name, Date birthdate, int carryingCapacity, String harness) {
        super(name, birthdate, carryingCapacity);
        this.harness = harness;
    }

    // Геттеры и сеттеры
    public String getHarness() {
        return harness;
    }

    public void setHarness(String harness) {
        this.harness = harness;
    }
}