import java.util.ArrayList;

public class BubbleSort {
    static void bubbleSort(ArrayList<Game> games) {
        int size = games.size();

        // Loop through all game elements
        for (int i = 0; i < size - 1; i++) {

            // Element compare loop
            for (int j = 0; j < size - i - 1; j++){
                Game currentGame = games.get(j);
                Game nextGame = games.get(j + 1);

                //compare elements
                if (currentGame.getName().compareTo(nextGame.getName()) > 0) {

                    games.set(j, nextGame);
                    games.set(j + 1, currentGame);
                }
            }
        }
    }
}
