
/**
 *
 * @author tsmal
 */
public class Client {

    public static void main(String[] args) {
        int size = 100000;
        Employee[] OGArray = new Employee[size];
        LinkedQueue tempQueue = new LinkedQueue();
        Employee[] tempArray = new Employee[size];
        Employee temp;
        Sort sort = new Sort();
        NameComparator nameComp = new NameComparator();
        IdComparator idComp = new IdComparator();
        HiredComparator hiredComp = new HiredComparator();
        DeptComparator deptComp = new DeptComparator();
        long start;
        long stop;

        for (int i = 0; i < OGArray.length; i++) {
            temp = new Employee();
            OGArray[i] = temp;
            tempQueue.enqueue(temp);
        }

        //Merge sort by name
        start = System.currentTimeMillis();
        sort.mergeSort(tempQueue, nameComp);
        stop = System.currentTimeMillis();
        System.out.println("Merge Sorting by name took: " + (stop - start) + " ms");

        //Quick sort by department
        for (int i = 0; i < OGArray.length; i++) {
            tempQueue.dequeue();
        }
        for (int i = 0; i < OGArray.length; i++) {
            tempQueue.enqueue(OGArray[i]);
        }
        start = System.currentTimeMillis();
        sort.quickSort(tempQueue, deptComp);
        stop = System.currentTimeMillis();
        System.out.println("Quick Sorting by department took: " + (stop - start) + " ms");

        //Bubble sort by id
        for (int i = 0; i < OGArray.length; i++) {
            tempArray[i] = OGArray[i];
        }
        start = System.currentTimeMillis();
        sort.simpleBubbleSort(tempArray, idComp);
        stop = System.currentTimeMillis();
        System.out.println("SimpleBubble Sorting by id took: " + (stop - start) + " ms");

        //Insertion sort by name
        for (int i = 0; i < OGArray.length; i++) {
            tempArray[i] = OGArray[i];
        }
        start = System.currentTimeMillis();
        sort.insertionSort(tempArray, nameComp);
        stop = System.currentTimeMillis();
        System.out.println("InsertionSort by name took: " + (stop - start) + " ms");

        //Selection sort by id
        for (int i = 0; i < OGArray.length; i++) {
            tempArray[i] = OGArray[i];
        }
        start = System.currentTimeMillis();
        sort.selectionSort(tempArray, idComp);
        stop = System.currentTimeMillis();
        System.out.println("SelectionSort by id took: " + (stop - start) + " ms");

    }
}
