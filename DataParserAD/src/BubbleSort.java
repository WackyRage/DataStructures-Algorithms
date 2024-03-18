import DataStructure.DataStructureOperations;

public class BubbleSort {
    static void bubbleSort(DataStructureOperations<Game> Games) {
        int size = Games.size();

        // Loop through all game elements
        for (int i = 0; i < size - 1; i++) {

            // Element compare loop
            for (int j = 0; j < size - i - 1; j++){
                Game currentGame = Games.get(j).getValue();
                Game nextGame = Games.get(j + 1).getValue();

                //compare elements
                if (currentGame.getName().compareTo(nextGame.getName()) > 0) {

                    Games.set(j, nextGame);
                    Games.set(j + 1, currentGame);
                }
            }
        }
    }
}
