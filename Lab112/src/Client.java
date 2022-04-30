
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 *
 * @author tsmal
 */
public class Client {

    public static void main(String[] args) throws IOException {

        boolean fileCreated;
        int numberOfElements;
        int randNum;
        long start;
        long stop;
        String randNumString;
        String unsortedFilePath = "C:\\data\\data.txt";
        String sortedFilePath = "C:\\data\\sortedData.txt";
        Random rand;

        //Creates new instance of File class using filePath and creates file if there isn't one
        File file = new File(unsortedFilePath);
        file.delete();
        fileCreated = file.createNewFile();
        System.out.println("The file was created: " + fileCreated);
        //Scan for number of elements to create in file
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input the number of elements to be added to file: ");
        numberOfElements = scan.nextInt();

        rand = new Random();
        FileWriter fw = new FileWriter(unsortedFilePath);
        BufferedWriter bw = new BufferedWriter(fw);

        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) {
            randNum = rand.nextInt(Integer.MAX_VALUE - 1) + 1;
            randNumString = Integer.toString(randNum);
            bw.write(randNumString);
            bw.newLine();
        }
        bw.close();
        stop = System.currentTimeMillis();

        //prints out time it took to write to file and size of file
        long timeToWrite = (stop-start)/1000;
        System.out.println("It took " + timeToWrite + " ms to write unsorted numbers to file");
        System.out.println("The unsorted file size is " + file.length() + " bytes big!");

        // ##########################
        // ### Start Sorting File ###
        // ##########################
        ExternalMergeSort ems = new ExternalMergeSort();
        start = System.currentTimeMillis();
        ems.externalMergeSort(unsortedFilePath, sortedFilePath);
        stop = System.currentTimeMillis();

        System.out.println("It took " + ((stop - start) / 1000) + " seconds to sort the entire file");

        Scanner unsortedScan = new Scanner(new File(unsortedFilePath));
        Scanner sortedScan = new Scanner(new File(sortedFilePath));

        System.out.println("\nThe first 100 numbers in the unsortedFile:");
        for (int i = 0; i < 100; i++) {
            if (unsortedScan.hasNextInt()) {
                System.out.println(unsortedScan.nextInt());
            }
        }
        System.out.println("\n");
        System.out.println("The first 100 numbers in the sortedFile:");
        for (int i = 0; i < 100; i++) {
            if (sortedScan.hasNextInt()) {
                System.out.println(sortedScan.nextInt());
            }
        }
    } //end of main method
}
