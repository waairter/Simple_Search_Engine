package search;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserFinder {

    private SearchingStrategy strategy;
    private Scanner scanner = new Scanner(System.in);
    private String inputQuery;
    private List<User> foundUsers;

    public void performSearch(Map<String, List<Integer>> invertedIndex,
                              List<User> users) {
        selectStrategy();
        enterInputQuery();
        findUsers(invertedIndex, users);
        displayResultOfSearch();
    }

    private void displayResultOfSearch() {
        System.out.println();
        int count = foundUsers.size();
        if(count == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(count + " persons found:");
            foundUsers.forEach(System.out::println);
        }
    }

    private void findUsers(Map<String, List<Integer>> invertedIndex,
                           List<User> users) {
        foundUsers = strategy.search(invertedIndex, users, inputQuery);
    }

    private void selectStrategy() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        String strategyInputString = scanner.nextLine();

        switch (strategyInputString) {
            case "ALL":
                strategy = new AllFindingStrategy();
                break;
            case "ANY":
                strategy = new AnyFindingStrategy();
                break;
            case "NONE":
                strategy = new NoneFindingStrategy();
                break;
        }
    }

    private void enterInputQuery() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        inputQuery = scanner.nextLine().trim().toLowerCase();
    }

}
