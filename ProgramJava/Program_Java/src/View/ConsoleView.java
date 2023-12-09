package View;

import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
