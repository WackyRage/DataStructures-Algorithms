import java.util.ArrayList;
import Game.Game;

public class MergeSort{
    static void merge(Application application, int p, int q, int r){
        if(application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            int n1 = q - p + 1;
            int n2 = r - q;

            ArrayList<Game> L = new ArrayList<>(n1);
            ArrayList<Game> M = new ArrayList<>(n2);

            for (int i = 0; i < n1; i++) {
                L.add(i, application.getLinkedListGame().get(p + i));
            }
            for (int j = 0; j < n2; j++) {
                M.add(j, application.getLinkedListGame().get(q + 1 + j));
            }

            //maintain current index of sub-arrays
            int i = 0;
            int j = 0;
            int k = p;

            //until the end is reached of L or M, pick larger element.
            while (i < n1 && j < n2) {
                if (L.get(i).getName().compareTo(M.get(j).getName()) <= 0) {
                    application.getLinkedListGame().set(k, L.get(i));
                    i++;
                } else {
                    application.getLinkedListGame().set(k, M.get(j));
                    j++;
                }
                k++;
            }

            //pick up remaining elements
            while (i < n1) {
                application.getLinkedListGame().set(k, L.get(i));
                i++;
                k++;
            }

            while (j < n2) {
                application.getLinkedListGame().set(k, M.get(j));
                j++;
                k++;
            }
        } else if(application.getSelectedDataStructure() == Application.DataStructures.HashMap) {
            int n1 = q - p + 1;
            int n2 = r - q;

            ArrayList<Game> L = new ArrayList<>(n1);
            ArrayList<Game> M = new ArrayList<>(n2);

            for (int i = 0; i < n1; i++) {
                L.add(i, application.getHashMapGame().get(p + i));
            }
            for (int j = 0; j < n2; j++) {
                M.add(j, application.getHashMapGame().get(q + 1 + j));
            }

            //maintain current index of sub-arrays
            int i = 0;
            int j = 0;
            int k = p;

            //until the end is reached of L or M, pick larger element.
            while (i < n1 && j < n2) {
                if (L.get(i).getName().compareTo(M.get(j).getName()) <= 0) {
                    application.getHashMapGame().set(k, L.get(i));
                    i++;
                } else {
                    application.getHashMapGame().set(k, M.get(j));
                    j++;
                }
                k++;
            }

            //pick up remaining elements
            while (i < n1) {
                application.getHashMapGame().set(k, L.get(i));
                i++;
                k++;
            }

            while (j < n2) {
                application.getHashMapGame().set(k, M.get(j));
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(Application application, int l, int r){
        if(l < r){
            //m is the point where the array gets split
            int m = (l + r) / 2;

            mergeSort(application, l, m);
            mergeSort(application, m + 1, r);

            //Merge the sorted sub-arrays
            merge(application, l, m, r);
        }
    }
}
