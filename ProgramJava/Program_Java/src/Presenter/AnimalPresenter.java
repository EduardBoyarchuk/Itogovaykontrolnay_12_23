package Presenter;

import Model.Animal;
import Model.Pet;
import Model.PackAnimal;
import View.ConsoleView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalPresenter {

    private ConsoleView view;
    private List<Animal> animals;

    public AnimalPresenter(ConsoleView view) {
        this.view = view;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(String type, String name, Date birthdate, String[] additionalAttributes) {
        Animal animal;
        switch (type.toLowerCase()) {
            case "собака":
            case "кошка":
            case "хомяк":
                animal = new Pet(name, birthdate, additionalAttributes);
                break;
            case "лошадь":
            case "верблюд":
            case "ослик":
                animal = new PackAnimal(name, birthdate, Integer.parseInt(additionalAttributes[0]));
                break;
            default:
                view.displayMessage("Неизвестный тип животного");
                return;
        }
        animals.add(animal);
        view.displayMessage("Животное успешно добавлено.");
    }

    public void displayCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name) && animal instanceof Pet) {
                String[] commands = ((Pet) animal).getCommands();
                view.displayMessage("Команды для " + name + ": ");
                for (String command : commands) {
                    view.displayMessage("- " + command);
                }
                return;
            }
        }
        view.displayMessage("Домашнее животное с таким именем не найдено " + name);
    }


    public void trainAnimal(String name, String newCommand) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name) && animal instanceof Pet) {
                Pet pet = (Pet) animal;
                pet.addCommand(newCommand);
                view.displayMessage(name + " выучил новую команду: " + newCommand);
                return;
            }
        }
        view.displayMessage("Домашнее животное с таким именем не найдено " + name);
    }


    public void displayAnimalsByBirthdate() {
        // Sorting animals by birthdate here (implementation not provided)
        // Displaying the sorted list
        for (Animal animal : animals) {
            view.displayMessage(animal.getName() + " - " + animal.getBirthdate());
        }
    }

    public void displayTotalAnimalCount() {
        view.displayMessage("Общее количество животных: " + animals.size());
    }

    public ConsoleView getView() {
        return view;
    }
}

