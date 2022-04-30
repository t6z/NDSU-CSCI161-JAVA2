/**
 * Class player has all default methods. Has three fields: name, positionPlayed, and jerseyNumber
 * @author tsmal
 * @version 2018915
 */
public class Player {
    
    private String name;
    private String positionPlayed;
    private int jerseyNumber;
    /**
     * overloaded constructor. Takes in name, posistionPlayed, and jerseyNumber
     * @param name
     * @param positionPlayed
     * @param jerseyNumber 
     */
    public Player(String name, String positionPlayed, int jerseyNumber){
        this.jerseyNumber = jerseyNumber;
        this.name = name;
        this.positionPlayed = positionPlayed;
    }
    /**
     * default constructor. Sets jerseyNumber to 0, name and positionPlayed to null
     */
    public Player(){
        this.jerseyNumber = 0;
        this.name = null;
        this.positionPlayed = null;
    }
    /**
     * returns String of name
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * returns String of positionPlayed
     * @return 
     */
    public String getPositionPlayed(){
        return positionPlayed;
    }
    /**
     * returns int of jerseyNumber
     * @return 
     */
    public int getJerseyNumber(){
        return jerseyNumber;
    }
    /**
     * takes in string of name and sets name
     * @param newName 
     */
    public void setName(String newName){
        name = newName;
    }
    /**
     * takes in string of position and sets that as new positionPlayed
     * @param newPosition 
     */
    public void setPositionPlayed(String newPosition){
        positionPlayed = newPosition;
    }
    /**
     * takes in int newNumber and sets that as the new jersey number
     * @param newNumber 
     */
    public void setJerseyNumber(int newNumber){
        jerseyNumber = newNumber;
    }
    /**
     * returns String with contents of player
     * @return 
     */
    public String toString(){
        return getClass().getName() + " : " + name + " : " + positionPlayed + " : " + jerseyNumber;
    }
    /**
     * if object o is equivalent to object called on returns true, false otherwise
     * @param o
     * @return 
     */
    public boolean equals(Object o){
        if (!(o instanceof Player)){
            return false;
        }
        Player p = (Player) o;
        return name.equals(p.name) && positionPlayed.equals(p.positionPlayed) && jerseyNumber == p.jerseyNumber;
    }
}
