
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tsmal
 * @version 20181128
 */
public class ExternalMergeSort {

    private long blockSize;
    private long presentFreeMemory;
    private long unsortedFileSize;
    private int numOfBlocks;
    private int numOfIntInBlock;

    /**
     * Default constructor
     */
    public ExternalMergeSort() {
    }

    /**
     * Runs garbage collector then estimates available memory at runtime for use
     * with external merge sort
     *
     * @return present free memory
     */
    private long estimatedAvailableMemory() {
        System.gc();
        Runtime r = Runtime.getRuntime();
        presentFreeMemory = r.freeMemory();
        System.out.println("Present free memory: " + presentFreeMemory);
        return presentFreeMemory;
    }

    /**
     * Returns an estimated blockSize in bytes.
     *
     * @param unsortedFileSize
     * @param maxMemory
     * @return
     */
    private long estimatedBlockSize() {
        if (unsortedFileSize < (presentFreeMemory/2)) {
            blockSize = unsortedFileSize;
        } else {
            blockSize = unsortedFileSize / (presentFreeMemory / 2);
        }
        if(blockSize < (presentFreeMemory/2)){
            blockSize = presentFreeMemory/2;
        }
        System.out.println("Block Size: " + blockSize + " bytes");
        return blockSize;
    }

    /**
     *
     * @param unsortedFilePath
     * @param sortedFilePath
     * @throws java.io.FileNotFoundException
     */
    public void externalMergeSort(String unsortedFilePath, String sortedFilePath) throws FileNotFoundException, IOException {
        File unsortedFile = new File(unsortedFilePath);
        Scanner fileScan = new Scanner(unsortedFile);
        QuickSort qs = new QuickSort();
        unsortedFileSize = unsortedFile.length();
        presentFreeMemory = estimatedAvailableMemory();
        blockSize = estimatedBlockSize();
        //USE UNTIL ESTIMATED BLOCK SIZE METHOD IS FIXED
        numOfBlocks = (int) (unsortedFileSize / blockSize);
        System.out.println("Number of blocks: " + numOfBlocks);
        //Block size in bytes
        //Calculate number of integers within one block
        numOfIntInBlock = (int) (blockSize / 8);
        System.out.println("Number of integers in one block: " + numOfIntInBlock);
        //Temporary queue to store block of integers in
        LinkedQueue<Integer> tempQueue = new LinkedQueue();

        /**
         * Adds a block to a temporary linked queue. That linked queue is then
         * sorted, then written to a new file.
         */
        IntegerComparator ic = new IntegerComparator();
        String blockFilePath;
        File tempFile;
        FileWriter fw;
        BufferedWriter bw;
        long start;
        long stop;
        long timeToSort;
        for (int j = 0; j < numOfBlocks; j++) {
            for (int i = 0; i < numOfIntInBlock; i++) {
                if (fileScan.hasNextInt()) {
                    tempQueue.enqueue(fileScan.nextInt());
                }
            }
            start = System.currentTimeMillis();
            qs.quickSort(tempQueue, ic);
            stop = System.currentTimeMillis();
            timeToSort = (stop-start)/1000;
            System.out.println("It took " + timeToSort + " seconds to sort block " + j);
            blockFilePath = "C:\\data\\block" + j + ".txt";
            tempFile = new File(blockFilePath);
            tempFile.createNewFile();
            fw = new FileWriter(blockFilePath);
            bw = new BufferedWriter(fw);
            //Writes sorted tempQueue to its own file
            while (!tempQueue.isEmpty()) {
                bw.write(Integer.toString(tempQueue.dequeue()));
                bw.newLine();
            }
            bw.close();
        }

        /**
         * Take first number from each block file and add to a priority queue.
         * Take out min from priority queue and write to new file. Take second
         * number from list that was taken from and add to priority queue.
         * Repeat until priority queue is empty.
         *
         */
        Scanner[] blockScanArray = new Scanner[numOfBlocks];
        UnsortedPriorityQueue<Integer, Integer> upq = new UnsortedPriorityQueue(ic);
        //Adds first number from each block file
        for (int j = 0; j < numOfBlocks; j++) {
            blockScanArray[j] = new Scanner(new File("C:\\data\\block" + j + ".txt"));
            if (blockScanArray[j].hasNextInt()) {
                upq.insert(blockScanArray[j].nextInt(), j);
            }
        }

        File sortedFile = new File(unsortedFilePath);
        sortedFile.createNewFile();
        BufferedWriter sortedbw = new BufferedWriter(new FileWriter(sortedFilePath));
        Entry temp;
        int value;
        int key;
        String keyString;
        while (!upq.isEmpty()) {
            temp = upq.removeMin();
            value = (int) temp.getValue();
            key = (int) temp.getKey();
            keyString = Integer.toString(key);
            sortedbw.write(keyString);
            sortedbw.newLine();
            if (blockScanArray[value].hasNextInt()) {
                upq.insert(blockScanArray[value].nextInt(), value);
            }
        }
        sortedbw.close();

        //Delete Temporary Files
        //  File deleteTempFiles;
        //  for (int j = 0; j < numOfBlocks; j++) {
        //      deleteTempFiles = new File("C:\\data\\block" + j + ".txt");
        //      System.out.println(deleteTempFiles.getAbsolutePath());
        //      System.out.println("Block file " + j + " was deleted: " + deleteTempFiles.delete());
        //  }
    } //end of external merge sort

}
