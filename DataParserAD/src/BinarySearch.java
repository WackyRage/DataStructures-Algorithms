import DataStructure.LinkedList;
import Game.Game;

public class BinarySearch {
    private String searchTerm;
    public BinarySearch(Application application, String searchTerm){
        this.searchTerm = searchTerm;
    }

    public int binarySearch(Application application) {
        if (application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            LinkedList<Game> Games = application.getLinkedListGame();
            int low = 0;
            int high = Games.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (Games.get(mid).getName() == searchTerm) {
                    return mid;
                } else if (Games.get(mid).getName().compareTo(searchTerm) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        return -1;
    }
}
