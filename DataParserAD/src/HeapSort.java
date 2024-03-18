import DataStructure.DataStructureOperations;

import java.text.ParseException;
import java.util.ArrayList;

public class HeapSort {
    static void heapSort(DataStructureOperations<Game> Games) {
        int n = Games.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(Games, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            Game temp = Games.get(0).getValue();
            Games.set(0, Games.get(i).getValue());
            Games.set(i, temp);

            // Heapify root element
            heap(Games, i, 0);
        }
    }

    static void heap(DataStructureOperations<Game> Games, int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && Games.get(l).getValue().getName().compareTo(Games.get(largest).getValue().getName()) > 0)
            largest = l;

        if (r < n && Games.get(r).getValue().getName().compareTo(Games.get(largest).getValue().getName()) > 0)
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            Game swap = Games.get(i).getValue();
            Games.set(i, Games.get(largest).getValue());
            Games.set(largest, swap);

            heap(Games, n, largest);
        }
    }
}
