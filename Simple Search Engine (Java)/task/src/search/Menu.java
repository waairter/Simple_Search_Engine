package search;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private SearchingEngine engine = new SearchingEngine();

    public Menu(String[] args) {
        engine.initUsers(args);
    }

    public String chooseAction() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");

        return scanner.nextLine();
    }

    public void displayAllUsers() {
        System.out.println("\n=== List of people ===");
        engine.getUsers().forEach(System.out::println);
    }

    public void findAndDisplayUsers() {
        engine.findUsers();
    }
}
