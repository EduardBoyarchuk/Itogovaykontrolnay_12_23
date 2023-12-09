package Model;
import java.util.Date;
public class PackAnimal extends Animal {
    private int carryingCapacity;

    public PackAnimal(String name, Date birthdate, int carryingCapacity) {
        super(name, birthdate);
        this.carryingCapacity = carryingCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }
}
