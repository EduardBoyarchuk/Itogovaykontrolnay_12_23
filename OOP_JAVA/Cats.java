import java.util.Date;
class Cats extends Pets {
    private String character;

    // Конструктор
    public Cats(String name, Date birthdate, String[] commands, String character) {
        super(name, birthdate, commands);
        this.character = character;
    }

    // Геттеры и сеттеры
    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
