
public class Boss extends Employee {
    
    private int salary;
        
//    public Boss( )                        //??? Why doesn't this work???
//    {
//        super( );
//        salary = 0;            
//    }
    
    public Boss( int id, String name, int salary ){
        super( id, name );        
        this.salary = salary;                
    }
        
    public int getSalary( )
    {
        return salary;
    }        
    
    public void setSalary( int newSalary )
    {
        salary = newSalary;
    }  
    
    public String toString( )
    {
        return super.toString() + "::" + getClass().getName() + ":" + salary;        
    }
    
    public boolean equals( Object o )
    {
        if ( !( o instanceof Boss ) )
            return false;
        Boss b = ( Boss ) o;
        
        return super.equals(  b )
                && salary == b.salary;
    }
    
}
