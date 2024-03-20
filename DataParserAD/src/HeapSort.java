import Game.Game;


public class HeapSort {
    public static void heapSort(Application application) {
        if(application.getSelectedDataStructure() == Application.DataStructures.LinkedList) {
            int n = application.getLinkedListGame().size();

            // Build max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heap(application, n, i);
            }

            // Heap sort
            for (int i = n - 1; i >= 0; i--) {
                Game temp = application.getLinkedListGame().get(0);
                application.getLinkedListGame().set(0, application.getLinkedListGame().get(i));
                application.getLinkedListGame().set(i, temp);

                // Heapify root element
                heap(application, i, 0);
            }
        } else if(application.getSelectedDataStructure() == Application.DataStructures.HashMap) {
            int n = application.getHashMapGame().size();

            // Build max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heap(application, n, i);
            }

            // Heap sort
            for (int i = n - 1; i >= 0; i--) {
                Game temp = application.getHashMapGame().get(0);
                application.getHashMapGame().set(0, application.getHashMapGame().get(i));
                application.getHashMapGame().set(i, temp);

                // Heapify root element
                heap(application, i, 0);
            }
        }
    }

    static void heap(Application application, int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && application.getLinkedListGame().get(l).getName().compareTo(application.getLinkedListGame().get(largest).getName()) > 0)
            largest = l;

        if (r < n && application.getLinkedListGame().get(r).getName().compareTo(application.getLinkedListGame().get(largest).getName()) > 0)
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            Game swap = application.getLinkedListGame().get(i);
            application.getLinkedListGame().set(i, application.getLinkedListGame().get(largest));
            application.getLinkedListGame().set(largest, swap);

            heap(application, n, largest);
        }
    }
}
