package Model;

import java.util.Date;

public class Pet extends Animal {
    private String[] commands;

    public Pet(String name, Date birthdate, String[] commands) {
        super(name, birthdate);
        this.commands = commands;
    }

    public String[] getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        int currentLength = commands.length;
        String[] newCommands = new String[currentLength + 1];
        System.arraycopy(commands, 0, newCommands, 0, currentLength);
        newCommands[currentLength] = newCommand;
        commands = newCommands;
    }
}
