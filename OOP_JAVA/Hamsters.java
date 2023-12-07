import java.util.Date;
class Hamsters extends Pets {
    private String runningWheel;

    // Конструктор
    public Hamsters(String name, Date birthdate, String[] commands, String runningWheel) {
        super(name, birthdate, commands);
        this.runningWheel = runningWheel;
    }

    // Геттеры и сеттеры
    public String getRunningWheel() {
        return runningWheel;
    }

    public void setRunningWheel(String runningWheel) {
        this.runningWheel = runningWheel;
    }
}