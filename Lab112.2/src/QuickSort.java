/**
 *
 * @author tsmal
 * @version 20181122
 */
public class QuickSort {
    public QuickSort(){}
    
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
