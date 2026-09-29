package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllFindingStrategy implements SearchingStrategy {

    @Override
    public List<User> search(Map<String, List<Integer>> invertedIndex,
                             List<User> users,
                             String query) {
        String[] tokens = query.split("\\s+");
        List<User> foundUsers = new AnyFindingStrategy().search(invertedIndex, users, query);
        List<User> suitableUsers = new ArrayList<>();

        Outer:
        for(User user : foundUsers) {
            String userDataString = user.toString().toLowerCase();
            for(String token : tokens) {
                if (!userDataString.contains(token)) {
                    continue Outer;
                }
            }
            suitableUsers.add(user);
        }
        return suitableUsers;
    }
}
