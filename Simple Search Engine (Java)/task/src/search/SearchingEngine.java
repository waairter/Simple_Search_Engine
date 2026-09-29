package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchingEngine {

    private UserFinder userFinder =  new UserFinder();

    private Map<String, List<Integer>> invertedIndex = new HashMap<>();
    private List<User> users = new ArrayList<>();


    public void findUsers() {
        userFinder.performSearch(invertedIndex, users);
    }

    public void initUsers(String[] args) {
        String filePath = args[1];
        File file = new File(filePath);
        int userIndex = 0;

        try(Scanner fileScanner = new Scanner(file)) {
            while(fileScanner.hasNextLine()) {
                String[] userData = fileScanner.nextLine().split(" ");

                for(int i = 0; i < userData.length; i++) {
                    String token = userData[i].toLowerCase();
                    if(invertedIndex.containsKey(token)) {
                        List<Integer> occurrences = new ArrayList<>(invertedIndex.get(token));
                        occurrences.add(userIndex);
                        invertedIndex.remove(token);

                        invertedIndex.put(token, occurrences);
                        continue;
                    }
                    invertedIndex.put(token, List.of(userIndex));
                }
                userIndex++;

                User user;
                String firstName = userData[0].toLowerCase();
                String secondName = userData[1].toLowerCase();

                if(userData.length == 2) {
                    user = new User(firstName, secondName);
                } else {
                    String email = userData[2].toLowerCase();
                    user = new User(firstName, secondName, email);
                }
                users.add(user);
            }

        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public List<User> getUsers() {
        return users;
    }
}