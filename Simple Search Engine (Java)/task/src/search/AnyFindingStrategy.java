package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnyFindingStrategy implements SearchingStrategy {

    @Override
    public List<User> search(Map<String, List<Integer>> invertedIndex,
                             List<User> users,
                             String query) {
        String[] tokens = query.split("\\s+");
        List<User> allFoundUsers = new ArrayList<>();

        for(String token : tokens) {
            List<Integer> indexes = invertedIndex.getOrDefault(token, List.of());
            for(Integer index : indexes) {
                User user = users.get(index);
                if(!allFoundUsers.contains(user)) {
                    allFoundUsers.add(user);
                }
            }
        }
        return allFoundUsers;
    }
}
