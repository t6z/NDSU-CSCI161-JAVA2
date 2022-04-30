
import java.util.Random;

public class Client {

    public static void main(String[] args) {

        int newScoresArraySize = 100;
        int maximumBound = 100;
        int number;
        boolean bool;
        
        //create new object of type Scores
        Scores newScores;
        newScores = new Scores(newScoresArraySize);

        Random randomNumber; //Create random object for array population
        randomNumber = new Random();

        //Populates Array with random nums -100 to 100
        for (int i = 0; i < newScoresArraySize; i++) {
            number = randomNumber.nextInt(maximumBound + 1); 

            bool = randomNumber.nextBoolean();
            if (bool == true) {
            } else {
                number = -number;
            }

            newScores.add(number);
        }//end of for loop

        System.out.println(newScores.toString());
                
        newScores.add(86);

        System.out.printf("The total amount of numbers in the bag is: %d%n", newScores.getCurrentSize());

        newScores.remove();

        int exampleIndex = newScores.get(75);
        System.out.printf("The number at the 75th index is: %d%n", exampleIndex);
        System.out.printf("The frequency of the number %d is: %d%n",exampleIndex, newScores.getFrequencyOf(exampleIndex));

        //Call the appropriate overloaded remove method to remove the 
        //first occurrence of number at the 75th index position from the Bag
        newScores.remove(exampleIndex);

        System.out.printf("The frequency of the number %d is: %d%n", exampleIndex, newScores.getFrequencyOf(exampleIndex));

        System.out.printf("The frequency of 86 is: %d%n", newScores.getFrequencyOf(86));

        //Prints whether or not 86 is in array.
        if (newScores.contains(86)) {
            System.out.println("The number 86 is within the array!");
        } else {
            System.out.println("The number 86 is not within the array...");
        }

    }

}
