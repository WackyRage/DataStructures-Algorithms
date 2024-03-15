import java.util.ArrayList;

public class MergeSort{
    static void merge(ArrayList<Game> Games, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;

        ArrayList<Game> L = new ArrayList<>(n1);
        ArrayList<Game> M = new ArrayList<>(n2);

        for(int i = 0; i < n1; i++){
            L.add(i, Games.get(p + i));
        }
        for(int j = 0; j < n2; j++){
            M.add(j, Games.get(q + 1 + j));
        }

        //maintain current index of sub-arrays
        int i = 0;
        int j = 0;
        int k = p;

        //until the end is reached of L or M, pick larger element.
        while (i < n1 && j < n2){
            if (L.get(i).getPrice() <= M.get(j).getPrice()){
                Games.set(k, L.get(i));
                i++;
            } else {
                Games.set(k, M.get(j));
                j++;
            }
            k++;
        }

        //pick up remaining elements
        while (i < n1){
            Games.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2){
            Games.set(k, M.get(j));
            j++;
            k++;
        }
    }

    static void mergeSort(ArrayList<Game> games, int l, int r){
        if(l < r){
            //m is the point where the array gets split
            int m = (l + r) / 2;

            mergeSort(games, l, m);
            mergeSort(games, m + 1, r);

            //Merge the sorted sub-arrays
            merge(games, l, m, r);
        }
    }
}
