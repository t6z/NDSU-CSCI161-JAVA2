
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        Recursion test = new Recursion();
        while (true) { //So that it will keep asking you which recursion to run until you choose exit.
            String[] choices = {"n-th Harmonic Series", "Isabel's technique", "Recursive File System print", "Exit"};

            String answer = (String) JOptionPane.showInputDialog(null, "Which one?",
                    "Lab104", JOptionPane.QUESTION_MESSAGE, null, choices, choices[3]);

            //Exit
            if (answer.equals(choices[3])) {
                System.exit(0);
            }

            //n-th harmonic series
            if (answer.equals(choices[0])) {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Please input a n value for harmonic series..."));

                System.out.printf("N-th Harmonic Series with n as:\n %d\n", num);

                double harmonicAnswer = Recursion.nthRecursion(num);

                System.out.printf("The Harmonic Series with %d as n is:\n%f\n", num, harmonicAnswer);

                System.out.println("There have been no errors\n");
            }//End of n-th harm. series

            //Isabel's Technique
            if (answer.equals(choices[1])) {

                String s = JOptionPane.showInputDialog("Please input a File path for Isabel's Technique...");

                System.out.printf("You chose Isabel's technique with the file path being:\n%s\n", s);
                int result = test.isabelsRecursion(s);
                //if the array is not power of two then it gives you options
                //to quit or try again, and resets b value.
                if (test.getB()) {
                    test.setB(false); // reset b value
                    String[] choices3 = {"Exit", "Try Again"};

                    String answer3 = (String) JOptionPane.showInputDialog(null,
                            "The Array is not a power of two... what do you want to do?",
                            "Lab104", JOptionPane.QUESTION_MESSAGE, null, choices3, choices3[1]);
                    
                    if(answer3.equals(choices3[0])){
                        System.exit(0);
                    }
                } else {
                    System.out.printf("The sum of the numbers is %d\n", result);
                }
            }//end of isabel's technique

            //Recursive File System print
            if (answer.equals(choices[2])) {
                String inputPath = JOptionPane.showInputDialog("Please input a File path for File System Recursion...");
                System.out.printf("Recursive File System Print with a File path of:\n%s\n\n", inputPath);

                test.list(inputPath);
            }
        }
    }
}
