import java.util.Date;
class Dogs extends Pets {
    private String breed;

    // Конструктор
    public Dogs(String name, Date birthdate, String[] commands, String breed) {
        super(name, birthdate, commands);
        this.breed = breed;
    }

    // Геттеры и сеттеры
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Дополнительный метод для собак
    public void bark() {
        System.out.println("Woof! Woof!");
    }
}