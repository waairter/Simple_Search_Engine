package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoneFindingStrategy implements SearchingStrategy {

    @Override
    public List<User> search(Map<String, List<Integer>> invertedIndex,
                             List<User> users,
                             String query) {
        List<User> usersToExclude = new AnyFindingStrategy().search(invertedIndex, users, query);
        List<User> usersCopy = new ArrayList<>(users);
        usersCopy.removeAll(usersToExclude);
        return usersCopy;
    }
}
