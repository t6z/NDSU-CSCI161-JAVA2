
/**
 *
 * Code Fragments: 12.3, 12.5
 *
 * Container class holding different sorting methods
 *
 * @author tsmal
 * @version 20181121
 */
public class Sort {

    public Sort() {
    }
    /**
     * Simple bubble sort
     * @param <K>
     * @param data
     * @param comp 
     */
    public <K> void simpleBubbleSort(K[] data, Comparator<K> comp) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comp.compare(data[j], data[j + 1]) <= 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
    /**
     * 
     * @param <K>
     * @param arr
     * @param comp 
     */
    public <K> void insertionSort(K[] arr, Comparator comp) {
        int j;
        K temp;

        for (int i = 1; i < arr.length; i++) {
            j = i;
            temp = arr[i];

            while (j != 0 && comp.compare(temp, arr[j - 1]) == 1) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }

    /**
     * Performs a selection sort on an array
     *
     * @param <K>
     * @param arr
     */
    public <K> void selectionSort(K[] arr, Comparator comp) {
        K temp; //temporary location for swap
        int max; //index of maximum value in subarray

        for (int i = 0; i < arr.length; i++) {
            //find index of largest value in subarray
            max = indexOfLargestElement(arr, comp);

            //swap arr[max] and arr[arr.length - i - 1]
            temp = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    /**
     * Private class to find the maximum object in an array.
     * Used for selectionSort
     * @param <K>
     * @param arr
     * @param comp
     * @return 
     */
    private <K> int indexOfLargestElement(K[] arr, Comparator comp) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (comp.compare(arr[i], arr[index]) == 1) {
                index = i;
            }
        }
        return index;
    }

    public <K> void mergeSort(LinkedQueue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return;
        }
        //divide
        LinkedQueue<K> S1 = new LinkedQueue<>();
        LinkedQueue<K> S2 = new LinkedQueue<>();
        while (S1.size() < n / 2) {
            S1.enqueue(S.dequeue());
        }
        while (!S.isEmpty()) {
            S2.enqueue(S.dequeue());
        }
        //conquer
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        //merge results
        merge(S1, S2, S, comp);
    }

    public <K> void merge(LinkedQueue<K> S1, LinkedQueue<K> S2, LinkedQueue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0) {
                S.enqueue(S1.dequeue());
            } else {
                S.enqueue(S2.dequeue());
            }
        }
        while (!S1.isEmpty()) {
            S.enqueue(S1.dequeue());
        }
        while (!S2.isEmpty()) {
            S.enqueue(S2.dequeue());
        }
    }
    /**
     * quickSort method
     * @param <K>
     * @param S
     * @param comp 
     */
    public <K> void quickSort(LinkedQueue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return;
        }
        //divide
        K pivot = S.first();
        LinkedQueue<K> L = new LinkedQueue<>();
        LinkedQueue<K> E = new LinkedQueue<>();
        LinkedQueue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) {
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) {
                L.enqueue(element);
            } else if (c == 0) {
                E.enqueue(element);
            } else {
                G.enqueue(element);
            }
        }
        //conquer
        quickSort(L, comp);
        quickSort(G, comp);
        //concatenate results
        while (!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }
}
