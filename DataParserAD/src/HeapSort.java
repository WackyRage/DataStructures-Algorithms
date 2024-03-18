import java.text.ParseException;
import java.util.ArrayList;

public class HeapSort {
    static void heapSort(ArrayList<Game> games) {
        int n = games.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(games, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            Game temp = games.get(0);
            games.set(0, games.get(i));
            games.set(i, temp);

            // Heapify root element
            heap(games, i, 0);
        }
    }

    static void heap(ArrayList<Game> games, int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && games.get(l).getName().compareTo(games.get(largest).getName()) > 0)
            largest = l;

        if (r < n && games.get(r).getName().compareTo(games.get(largest).getName()) > 0)
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            Game swap = games.get(i);
            games.set(i, games.get(largest));
            games.set(largest, swap);

            heap(games, n, largest);
        }
    }
}
