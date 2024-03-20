import Game.Game;

public class BubbleSort {
    public static void bubbleSort(Application application) {
        if(application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            System.out.println("ITS A LINKEDLIST");
            int size = application.getLinkedListGame().size();

            // Loop through all game elements
            for (int i = 0; i < size - 1; i++) {

                // Element compare loop
                for (int j = 0; j < size - i - 1; j++) {
                    Game currentGame = application.getLinkedListGame().get(j);
                    Game nextGame = application.getLinkedListGame().get(j + 1);

                    //compare elements
                    if (currentGame.getName().compareTo(nextGame.getName()) > 0) {

                        application.getLinkedListGame().set(j, nextGame);
                        application.getLinkedListGame().set(j + 1, currentGame);
                    }
                }
            }
        } else if(application.getSelectedDataStructure() == Application.DataStructures.HashMap) {
            System.out.println("ITS A HASHMAP");
            int size = application.getHashMapGame().size();

            // Loop through all game elements
            for (int i = 0; i < size - 1; i++) {
                // Element compare loop
                for (int j = 0; j < size - i - 1; j++) {
                    Game currentGame = application.getHashMapGame().get(j);
                    Game nextGame = application.getHashMapGame().get(j + 1);

                    //compare elements
                    if (currentGame.getName().compareTo(nextGame.getName()) > 0) {

                        application.getHashMapGame().set(j, nextGame);
                        application.getHashMapGame().set(j + 1, currentGame);
                    }
                }
            }
        }
    }
}
