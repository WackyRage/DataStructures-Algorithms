import DataStructure.HashMap;
import DataStructure.LinkedList;
import Game.Game;

import java.util.Objects;

public class BinarySearch {
    private final String searchTerm;
    public BinarySearch(String searchTerm){
        this.searchTerm = searchTerm;
    }

    public int binarySearch(Application application) {
        if (application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            LinkedList<Game> Games = application.getLinkedListGame();
            int low = 0;
            int high = Games.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Objects.equals(Games.get(mid).getName(), searchTerm)) {
                    return mid;
                } else if (Games.get(mid).getName().compareTo(searchTerm) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        } else if (application.getSelectedDataStructure() == Application.DataStructures.HashMap){
            HashMap<Integer, Game> Games = application.getHashMapGame();
            int low = 0;
            int high = Games.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Objects.equals(Games.get(mid).getName(), searchTerm)) {
                    return mid;
                } else if (Games.get(mid).getName().compareTo(searchTerm) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
