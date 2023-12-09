import Presenter.AnimalPresenter;
import View.ConsoleView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        AnimalPresenter presenter = new AnimalPresenter(view);

        while (true) {
            view.displayMessage("\nМеню:");
            view.displayMessage("1.Добавить животное");
            view.displayMessage("2.Показать команды");
            view.displayMessage("3.Обучить животное");
            view.displayMessage("4.Отобразить животных по дате рождения.");
            view.displayMessage("5. Показать общее количество животных");
            view.displayMessage("0. Выход");

            String choice = view.readLine();

            switch (choice) {
                case "1":
                    addAnimal(presenter);
                    break;
                case "2":
                    displayCommands(presenter);
                    break;
                case "3":
                    trainAnimal(presenter);
                    break;
                case "4":
                    displayAnimalsByBirthdate(presenter);
                    break;
                case "5":
                    displayTotalAnimalCount(presenter);
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Неверный выбор. Введите допустимую опцию..");
            }
        }
    }

    private static void addAnimal(AnimalPresenter presenter) {
        ConsoleView view = presenter.getView();

        view.displayMessage("Введите тип животного (собака, кошка, хомяк, лошадь, верблюд, ослик): ");
        String type = view.readLine();

        view.displayMessage("Введите имя животного: ");
        String name = view.readLine();

        view.displayMessage("Введите дату рождения (гггг-ММ-дд): ");
        String birthdateString = view.readLine();
        Date birthdate = parseDate(birthdateString);

        switch (type.toLowerCase()) {
            case "собака":
            case "кошка":
            case "хомяк":
                view.displayMessage("Введите команды (через запятую): ");
                String commandsString = view.readLine();
                String[] commands = commandsString.split(",");
                presenter.addAnimal(type, name, birthdate, commands);
                break;
            case "лошадь":
            case "верблюд":
            case "ослик":
                view.displayMessage("Введите грузоподъемность: ");
                String carryingCapacityString = view.readLine();
                presenter.addAnimal(type, name, birthdate, new String[]{carryingCapacityString});
                break;
            default:
                view.displayMessage("Неизвестный тип животного");
        }
    }

    private static void displayCommands(AnimalPresenter presenter) {
        ConsoleView view = presenter.getView();
        view.displayMessage("Введите имя животного: ");
        String name = view.readLine();
        presenter.displayCommands(name);
    }

    private static void trainAnimal(AnimalPresenter presenter) {
        ConsoleView view = presenter.getView();
        view.displayMessage("Введите имя животного: ");
        String name = view.readLine();
        view.displayMessage("Введите новую команду: ");
        String newCommand = view.readLine();
        presenter.trainAnimal(name, newCommand);
    }

    private static void displayAnimalsByBirthdate(AnimalPresenter presenter) {
        presenter.displayAnimalsByBirthdate();
    }

    private static void displayTotalAnimalCount(AnimalPresenter presenter) {
        presenter.displayTotalAnimalCount();
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

