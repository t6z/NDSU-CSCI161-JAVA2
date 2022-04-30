
import java.util.Random;

/**
 * Testing Array and Linked List versions of a Stack and Queue. Also testing a
 * Array implementation of a List.
 *
 * @author tsmal
 * @version 20181002
 */
public class Client {

    public static void main(String[] args) {
        StackClasses();
        QueueClasses();
        ListClasses();
    }

    public static void StackClasses() {
        //Test Array Stack
        System.out.printf("\n\n************* TESTING ARRAY STACK *************\n");
        StackInterface<Integer> as = new ArrayStack<>();
        //Push two numbers on Stack
        as.push(5);
        as.push(3);
        //Print size
        System.out.println("The current size: " + as.size());
        //Pop and check if empty times two
        System.out.println("Pop: " + as.pop());
        System.out.println("Is empty? " + as.isEmpty());
        System.out.println("Pop: " + as.pop());
        System.out.println("Is Empty? " + as.isEmpty());
        //Pops empty stack
        System.out.println("Pop: " + as.pop());
        //Push two more numbers on
        as.push(7);
        as.push(9);
        //Output what's on top
        System.out.println("On top: " + as.top());
        //Push another number on
        as.push(4);
        //print size then pop to check LIFO
        System.out.println("Size: " + as.size());
        System.out.println("Pop: " + as.pop());
        as.push(6);
        as.push(8);
        System.out.println("Pop: " + as.pop());

        //Push on two more items.
        System.out.println("Testing pushing past capacity (Default of 5)");
        System.out.println("Size: " + as.size());
        as.push(6);
        System.out.println("Size: " + as.size());
        as.push(2);
        System.out.println("Size: " + as.size());
        //Testing pushing past capacity
        try {
            as.push(9);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }

        //Test Linked Stack
        System.out.printf("\n\n************* TESTING LINKED STACK *************\n");
        StackInterface<Integer> ls = new LinkedStack<>();
        ls.push(5);             //(5)
        ls.push(3);             //(5,3)
        System.out.println("The current size: " + ls.size()); //size: 2
        System.out.println("Pop: " + ls.pop());
        System.out.println("Is empty? " + ls.isEmpty());
        System.out.println("Pop: " + ls.pop());
        System.out.println("Is Empty? " + ls.isEmpty());
        System.out.println("Pop: " + ls.pop());             //Pops empty Stack
        ls.push(7);
        ls.push(9);
        //Tests LIFO 
        System.out.println("On top: " + ls.top());
        ls.push(4);                                         //(7,9,4)
        System.out.println("Size: " + ls.size());
        System.out.println("Pop: " + ls.pop());
        //Pushes two more numbers on Stack
        ls.push(6);
        ls.push(8);
        System.out.println("Pop: " + ls.pop());
    }

    public static void QueueClasses() {
        //Tests ArrayQueue
        System.out.printf("\n\n************* TESTING ARRAY QUEUE *************\n");
        QueueInterface<Integer> aq = new ArrayQueue<>();
        aq.enqueue(5);
        aq.enqueue(3);
        System.out.println("Size: " + aq.size());
        System.out.println("Dequeue: " + aq.dequeue());
        System.out.println("Empty? " + aq.isEmpty());
        System.out.println("Dequeue: " + aq.dequeue());
        System.out.println("Empty? " + aq.isEmpty());
        //Dequeueing on empty queue
        System.out.println("Dequeue: " + aq.dequeue());
        aq.enqueue(7);
        aq.enqueue(9);
        //Testing FIFO
        System.out.println("First: " + aq.first());
        aq.enqueue(4);
        System.out.println("First: " + aq.first());

        System.out.println("Testing pushing past capacity (Default of 5)");
        System.out.println("Size: " + aq.size());
        aq.enqueue(6);
        System.out.println("Size: " + aq.size());
        aq.enqueue(2);
        System.out.println("Size: " + aq.size());
        //Testing pushing past capacity
        try {
            aq.enqueue(9);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }

        //Tests LinkedQueue
        System.out.printf("\n\n************* TESTING LINKED QUEUE *************\n");
        QueueInterface<Integer> lq = new LinkedQueue<>();
        lq.enqueue(5);
        lq.enqueue(3);
        System.out.println("Size: " + lq.size());
        System.out.println("Dequeue: " + lq.dequeue());
        System.out.println("Empty? " + lq.isEmpty());
        System.out.println("Dequeue: " + lq.dequeue());
        System.out.println("Empty? " + lq.isEmpty());
        //Dequeueing on empty queue
        System.out.println("Dequeue: " + lq.dequeue());
        lq.enqueue(7);
        lq.enqueue(9);
        //Testing FIFO
        System.out.println("First: " + lq.first());
        lq.enqueue(4);
    }

    public static void ListClasses() {
        Random rand = new Random();
        int randomInt;
        long startTime;
        long stopTime;
        long totalTime;

        //Add initial elements to List
        //Add elements before and after 
        for (int j = 1; j < 4; j++) {
            int size = 134217728 * j;
            System.out.printf("\n\n********** Testing adding " + (size + 1) + " items to ArrayList **********\n");
            ListInterface<Integer> al = new ArrayList<>();

            for (int i = 0; i < size - 2; i++) {
                randomInt = rand.nextInt(10);
                al.add(i, randomInt);
            }
            try {
                for (int i = size - 2; i < size + 3; i++) {
                    randomInt = rand.nextInt(10);
                    
                    startTime = System.nanoTime();
                    al.add(i, randomInt);
                    stopTime = System.nanoTime();
                    
                    totalTime = stopTime - startTime;
                    System.out.println("Size =  " + al.size() + "  Time(ns) = " + totalTime);
                }
            } catch (OutOfMemoryError oome) {
                System.out.println("Ran out of memory at: " + (al.size() + 1));
                oome.getMessage();
                break;
            }
        }
    }
}
