import DataStructure.HashMap;
import DataStructure.LinkedList;
import Game.Game;

import java.util.Objects;

public class LinearSearch {
    private String searchTerm;

    public LinearSearch(Application application, String searchTerm){
        this.searchTerm = searchTerm;
    }

    public int linearSearch(Application application) {
        if (application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            LinkedList<Game> Games = application.getLinkedListGame();
            int n = Games.size();
            System.out.println(Games.size());
            //move through array sequentially
            for (int i = 0; i < n; i++) {
                if (Objects.equals(Games.get(i).getName(), searchTerm)) {
                    System.out.println("we found it!");
                    return i;
                }
                System.out.println(Games.get(i).getName());
                System.out.println(searchTerm);
            }
            return -1;
        } else if (application.getSelectedDataStructure() == Application.DataStructures.HashMap) {
            HashMap<Integer, Game> Games = application.getHashMapGame();
            int n = Games.size();
            System.out.println(Games.size());
            //move through array sequentially
            for (int i = 0; i < n; i++) {
                if (Objects.equals(Games.get(i).getName(), searchTerm)) {
                    System.out.println("we found it!");
                    return i;
                }
                System.out.println(Games.get(i).getName());
                System.out.println(searchTerm);
            }
            return -1;
        }
        return -1;
    }
}
