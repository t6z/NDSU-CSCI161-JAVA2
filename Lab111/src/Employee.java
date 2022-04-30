import java.util.Random;
/**
 *
 * @author tsmal
 */
public class Employee {
    int id;
    int dept;
    int hired;
    String name = "";
    
    public Employee(){
        Random rand = new Random();
        id = rand.nextInt(100000000);
        dept = (rand.nextInt(5) + 1);
        hired = (rand.nextInt(10) + 2008);
        int a = rand.nextInt(6) + 5;
        int b;
        for(int i = 0; i < a; i++){
            b = rand.nextInt(26) + 97;
            name+= (char) b;
        }
    }
    
    public int getId(){
        return id;
    }
    
    public int getDept(){
        return dept;
    }
    
    public int getHired(){
        return hired;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        return name + " : " + id + " : " + dept + " : " + hired;
    }
}
