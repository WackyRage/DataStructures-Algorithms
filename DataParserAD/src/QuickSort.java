import java.util.ArrayList;

public class QuickSort {
    static int partition(ArrayList<Game> Games, int low, int high){
        //create and set pivot
        Game pivot = Games.get(high);

        //pointer for greater element
        int i = (low - 1);

        for (int j = low; j < high; j++){
            Game selectedGame = Games.get(j);

            if (selectedGame.getName().compareTo(pivot.getName()) <= 0) {
                // If smaller element than pivot is found,
                // swap it with greater element
                i++;

                // Swap element i with j
                Game temp = Games.get(i);
                Games.set(i, Games.get(j));
                Games.set(j, temp);
            }
        }

        Game temp = Games.get(i + 1);
        Games.set((i + 1), Games.get(high));
        Games.set(high, temp);

        return i + 1;
    }

    static void quickSort(ArrayList<Game> Games, int low, int high){
        if(low < high){
            int pi = partition(Games, low, high);

            quickSort(Games, low, pi - 1);

            quickSort(Games, pi+1, high);
        }
    }
}
