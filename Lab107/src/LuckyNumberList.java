
import java.util.NoSuchElementException;

/**
 *
 * LuckyNumberList is of type LuckyNumber. Creates a new LinkedPositionalList when
 * constructed.
 * 
 * @author tsmal
 * @version 20181010
 */
public class LuckyNumberList {

    private LinkedPositionalList<LuckyNumber> list = null;
    /**
     * Default Constructor for LuckyNumberList. Creates a new
     * LinkedPositionalList named list
     */
    public LuckyNumberList() {
        list = new LinkedPositionalList<>();
    }
    /**
     * Takes in a LuckyNumber object l and adds it to the end of
     * LinkedPositionalList list
     * @param l 
     */
    public void addLuckyNumber(LuckyNumber l) {
        list.addLast(l);
    }
    /**
     * Takes integer n and returns if it is even or not
     * @param n
     * @return boolean value
     */
    public boolean isEven(int n) {
        return (n % 2) == 0;
    }
    /**
     * Takes integer n and returns if it is prime or not
     * @param n
     * @return boolean value
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns string with contents of list
     * @return content of list
     */
    @Override
    public String toString() {
        String s = "";

        Iterator<LuckyNumber> listIterator = list.iterator();

        while (listIterator.hasNext()) {
            s += listIterator.next().toString() + " ";
        }

        return s;
    }
   
    
    
    
    
    
    
    
    //----- nested PositionIterator class -----
    private class PositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = list.first();
        private Position<LuckyNumber> recent = null;
        /**
         * Returns boolean value true if cursor is not null
         * @return boolean value
         */
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }
        /**
         * Makes recent equal to cursor, and cursor equal to next LuckyNumber object
         * reference on list.
         * @return
         * @throws NoSuchElementException 
         */
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if (cursor == null) {
                throw new NoSuchElementException("nothing left ");
            }
            recent = cursor;
            cursor = list.after(cursor);
            return recent;
        }
        /**
         * Removes LuckyNumber object whose reference is stored in recent from list
         * @throws IllegalStateException 
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove ");
            }
            list.remove(recent);
            recent = null;
        }
    } //----- end of nested PositionIterator class-----

    //----- nested PositionIterable class -----
    private class PositionIterable implements Iterable<Position<LuckyNumber>> {
        /**
         * Returns new Position Iterator
         * @return 
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new PositionIterator();
        }
    }
    /**
     * returns new PositionaIterable, which then returns new Position Iterator.
     * @return 
     */
    public Iterable<Position<LuckyNumber>> positions() {
        return new PositionIterable(); //create a new instance of of the inner class
    }

    
    
    
    
    
    //----- nested PositionIterator class -----
    private class EvenPositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = list.first();
        private Position<LuckyNumber> recent = null;
        /**
         * Returns boolean value of true if cursor is not null
         * @return 
         */
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }
        /**
         * Returns next position
         * @return
         * @throws NoSuchElementException when cursor == null
         */
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if (recent == null) {
                while (cursor != null && !isEven(cursor.getElement().getLuckyNumber())) {
                    cursor = list.after(cursor);
                }
            }

            if (cursor == null) {
                throw new NoSuchElementException("nothing left ");
            }
            recent = cursor;
            cursor = list.after(cursor);

            // advance cursor to the next even number
            while (cursor != null && !isEven(cursor.getElement().getLuckyNumber())) {
                cursor = list.after(cursor);
            }

            return recent;
        }
        /**
         * Removes LuckyNumber in recent position
         * @throws IllegalStateException 
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove ");
            }
            list.remove(recent);
            recent = null;
        }
    } //----- end of nested EvenPositionIterator Class-----

    private class EvenPositionIterable implements Iterable<Position<LuckyNumber>> {
        /**
         * Iterator method returns new EvenPositioniterator
         * @return 
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new EvenPositionIterator();
        }
    } //----- end of nested EvenPositionIterable class -----
    /**
     * evenPositions returns new EvenPositionIterable
     * @return 
     */
    public Iterable<Position<LuckyNumber>> evenPositions() {
        return new EvenPositionIterable();  // create a new instace of the inner class
    }

    
    
    
    
    
    
    private class PrimePositionIterator implements Iterator<Position<LuckyNumber>> {

        private Position<LuckyNumber> cursor = list.first();
        private Position<LuckyNumber> recent = null;
        /**
         * Returns true if cursor is not null
         * @return 
         */
        @Override
        public boolean hasNext() {
            return (cursor != null);
        }
        /**
         * Returns next position in list
         * @return
         * @throws NoSuchElementException 
         */
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if (recent == null) {
                while (cursor != null && !isPrime(cursor.getElement().getLuckyNumber())) {
                    cursor = list.after(cursor);
                }
            }

            if (cursor == null) {
                throw new NoSuchElementException("nothing left ");
            }
            recent = cursor;
            cursor = list.after(cursor);

            // advance cursor to the next prime number
            while (cursor != null && !isPrime(cursor.getElement().getLuckyNumber())) {
                cursor = list.after(cursor);
            }

            return recent;
        }
        /**
         * Removes recent position if it is not null
         * @throws IllegalStateException 
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove ");
            }
            list.remove(recent);
            recent = null;
        }
    } //----- end of nested PrimePositionIterator Class-----

    private class PrimePositionIterable implements Iterable<Position<LuckyNumber>> {
        /**
         * Returns new PrimePositionIterator
         * @return 
         */
        @Override
        public Iterator<Position<LuckyNumber>> iterator() {
            return new PrimePositionIterator();
        }
    } //----- end of nested EvenPositionIterable class -----
    /**
     * Returns new PrimePositionIterable
     * @return 
     */
    public Iterable<Position<LuckyNumber>> primePositions() {
        return new PrimePositionIterable();  // create a new instace of the inner class
    }
}
