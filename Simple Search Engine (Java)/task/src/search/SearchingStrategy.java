package search;

import java.util.List;
import java.util.Map;

public interface SearchingStrategy {

    public List<User> search(Map<String, List<Integer>> invertedIndex,
                             List<User> users,
                             String query);
}
