import DataStructure.DataStructureOperations;

public class QuickSort {
    static int partition(DataStructureOperations<Game> Games, int low, int high){
        //create and set pivot
        Game pivot = Games.get(high).getValue();

        //pointer for greater element
        int i = (low - 1);

        for (int j = low; j < high; j++){
            Game selectedGame = Games.get(j).getValue();

            if (selectedGame.getName().compareTo(pivot.getName()) <= 0) {
                // If smaller element than pivot is found,
                // swap it with greater element
                i++;

                // Swap element i with j
                Game temp = Games.get(i).getValue();
                Games.set(i, Games.get(j).getValue());
                Games.set(j, temp);
            }
        }

        Game temp = Games.get(i + 1).getValue();
        Games.set((i + 1), Games.get(high).getValue());
        Games.set(high, temp);

        return i + 1;
    }

    static void quickSort(DataStructureOperations<Game> Games, int low, int high){
        if(low < high){
            int pi = partition(Games, low, high);

            quickSort(Games, low, pi - 1);

            quickSort(Games, pi+1, high);
        }
    }
}
