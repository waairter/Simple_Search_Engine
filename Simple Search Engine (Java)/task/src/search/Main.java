package search;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(args);

        mainLoop:
        while(true) {
            switch(menu.chooseAction()) {
                case "1":
                    menu.findAndDisplayUsers();
                    break;
                case "2":
                    menu.displayAllUsers();
                    break;
                case "0":
                    System.out.print("\nBye!");
                    break mainLoop;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }
        }
    }
}
