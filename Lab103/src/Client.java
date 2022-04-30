
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        ArrayBag footballTeam = new ArrayBag(2);
        Scanner scan;

        String newName;
        String newPosition;
        int newNumber;
        Player temp;

        //DEMONSTRATING ARRAYBAG FOR FOOTBALLTEAM
        for (int i = 0; i < 2; i++) {
            System.out.println("Please input a name for player: ");
            scan = new Scanner(System.in);
            newName = scan.nextLine();

            System.out.println("Please input a position played for player: ");
            scan = new Scanner(System.in);
            newPosition = scan.nextLine();

            System.out.println("Please input a number for player: ");
            scan = new Scanner(System.in);
            newNumber = scan.nextInt();

            temp = new Player(newName, newPosition, newNumber); //creates temporary player
            footballTeam.addItem(temp); //adds that player to the football team
        }

        System.out.println(footballTeam.toString()); //print contents of footballteam

        footballTeam.remove(); //remove random player

        System.out.println(footballTeam.toString()); //print contents of footballteam

        
        temp = new Player("Jeff","Linebacker",24);
        footballTeam.addItem(temp);
        
        System.out.println(footballTeam.toString());
        
        footballTeam.remove(temp);
        
        System.out.println(footballTeam.toString());
            
        
        
        //DEMONSTRATING BAG
        ArrayBag courses = new ArrayBag(3);
        
        courses.addItem("CSCI 161");
        courses.addItem("EE 206");
        courses.addItem("PHYS 252");
        courses.addItem("MATH 266");
        courses.addItem("CHEM 121L");
        
        System.out.println(courses.toString());
        
        courses.remove();
        
        System.out.println(courses.toString());
        
        
        //USING LINKEDBAG FOR BASKETBALL TEAM
        LinkedBag basketballTeam = new LinkedBag();
        
        for (int i = 0; i < 6; i++) {
            System.out.println("Please input a name for player: ");
            scan = new Scanner(System.in);
            newName = scan.nextLine();

            System.out.println("Please input a position played for player: ");
            scan = new Scanner(System.in);
            newPosition = scan.nextLine();

            System.out.println("Please input a number for player: ");
            scan = new Scanner(System.in);
            newNumber = scan.nextInt();

            temp = new Player(newName, newPosition, newNumber); //creates temporary player
            basketballTeam.addItem(temp); //adds that player to the football team
        }
        
        System.out.println(basketballTeam.toString());
        
        basketballTeam.remove();
        
        System.out.println(basketballTeam.toString());
        
        temp = new Player("Susan","Center",55);
        basketballTeam.addItem(temp);
        
        System.out.println(basketballTeam.toString());
        
        basketballTeam.remove(temp);
        
        System.out.println(basketballTeam.toString());
        
    }
}
