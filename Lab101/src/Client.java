
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        //initialize variables
        String employeeDecision;
        String newName;
        String titleOrPosition;
        int newID;
        int newSalary;
        int arrayLength = 10;
        double newHourlyRate;

        //create array of objects Employee
        Employee[] empList;
        empList = new Employee[arrayLength];

        Scanner scan; //create scanner to get input from keyboard

        for (int i = 0; i < arrayLength; i++) {
            if (Hourly.numOfHourly < 3 || Salaried.numOfSalaried < 3) {
                System.out.println("New Employee! What is their name? ");
                scan = new Scanner(System.in);
                newName = scan.nextLine();

                //Getting input for their ID Number
                System.out.println("What is their ID Number? ");
                scan = new Scanner(System.in);
                newID = scan.nextInt();

                //Choose whether it is a Salaried or Hourly Employee
                System.out.println("What type of Employee? (s for Salaried or h for Hourly) ");
                scan = new Scanner(System.in);
                employeeDecision = scan.nextLine();

                //Switch case for users decision
                switch (employeeDecision) {
                    case "h":
                        //ask and scan position
                        System.out.println("What is their position?");
                        scan = new Scanner(System.in);
                        titleOrPosition = scan.nextLine();

                        //ask and scan hourly rate
                        System.out.println("What is their Hourly Rate?");
                        newHourlyRate = scan.nextDouble();
                        
                        //create new hourly object
                        empList[i] = new Hourly(newID, newName, titleOrPosition, newHourlyRate);

                        //increment numOfEmployees and numOfHourly
                        empList[i].incrementNumOfEmployees();
                        Hourly h1 = (Hourly) empList[i];
                        h1.incrementNumOfHourly();
                        break;
                    case "s":
                        //ask and scan title
                        System.out.println("What is their title?");
                        scan = new Scanner(System.in);
                        titleOrPosition = scan.nextLine();

                        //ask and scan salary
                        System.out.println("What is their Salary?");
                        newSalary = scan.nextInt();
                        //create new salaried object
                        empList[i] = new Salaried(newID, newName, titleOrPosition, newSalary);

                        //increment numOfEmployees and numOfSalaried
                        empList[i].incrementNumOfEmployees();
                        Salaried s1 = (Salaried) empList[i];
                        s1.incrementNumOfSalaried();
                        break;
                    default:
                        System.out.print("You entered something other than 'h' or 's'");
                        break;
                }
            } // End of Switch Case

        }//end of For loop line 21

        //Use toString method to print out contents of Array
        for (int i = 0; i < arrayLength; i++) {
            if (empList[i] instanceof Salaried) {
                Salaried s;
                s = (Salaried) empList[i];
                System.out.println(s.toString());
            }
            if (empList[i] instanceof Hourly) {
                Hourly h;
                h = (Hourly) empList[i];
                System.out.println(h.toString());
            }
        }

        //Increase all employees wages by 10%
        for (int i = 0; i < arrayLength; i++) {
            if (empList[i] instanceof Salaried) {
                Salaried s2;
                s2 = (Salaried) empList[i];
                int nSalary = (int) (s2.getSalary() * 1.1);
                s2.setSalary(nSalary);
            }
            if (empList[i] instanceof Hourly) {
                Hourly h2;
                h2 = (Hourly) empList[i];
                h2.setHourlyRate((h2.getHourlyRate() * 1.1));
            }
        } //end of for loop(83)

        //Print out Contents excluding null 
        for (int i = 0; i < arrayLength; i++) {
            if (empList[i] != null) {
                if (empList[i] instanceof Salaried) {
                    Salaried s4;
                    s4 = (Salaried) empList[i];
                    System.out.println(s4.toString());
                }
                if (empList[i] instanceof Hourly) {
                    Hourly h4;
                    h4 = (Hourly) empList[i];
                    System.out.println(h4.toString());
                }
            }
        } //end of For Loop(108)

        //Testing Equals Methods Explicitly
        
        //Initializing objects to be compared
        Employee e10 = new Employee(1, "Greg");
        Employee e11 = new Employee(1, "Greg");
        Employee e12 = new Employee(2, "George");

        Hourly h10 = new Hourly(2, "Molly", "Teller", 13.75);
        Hourly h11 = new Hourly(2, "Molly", "Teller", 13.75);
        Hourly h12 = new Hourly(3, "Joe", "Customer Service Representative", 16.75);

        Salaried s10 = new Salaried(6, "Derek", "Branch Manager", 46000);
        Salaried s11 = new Salaried(6, "Derek", "Branch Manager", 46000);
        Salaried s12 = new Salaried(7, "Julie", "Teller Supervisor", 42000);

        //Testing Employee Classes Equals method
        if (e10.equals(e11)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (e10.equals(e12)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (e10.equals(h10)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }

        //Testing Hourly classes Equals Method
        if (h10.equals(h11)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (e10.equals(h12)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (e10.equals(s10)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }

        //Testing Salaried Classes Equals Method
        if (s10.equals(s11)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (s10.equals(s12)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }
        if (s10.equals(e10)) {
            System.out.println("They must be equal!");
        } else {
            System.out.println("They are not equal...");
        }

    }//main method bracket
}//client class bracket
