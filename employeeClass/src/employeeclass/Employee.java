
public class Employee {

    private int id;
    private String name;
    private int salary;
    private double hourlyRate;
    
    public Employee( )
    {
        id = 0;
        name = null;
        salary = 0;
        hourlyRate = 0.0;
    }
    
    public int getId( ) {
        return id;
    }
    
    public String getName( )
    {
        return name;
    }
    
    public int getSalary( )
    {
        return salary;
    }
    
    public double getHourlyRate( )
    {
        return hourlyRate;
    }
    
    public void setId( int newId )
    {
        id = newId;
    }
    
    public void setName( String newName )
    {
        name = newName;
    }
    
    public void setSalary( int newSalary )
    {
        salary = newSalary;
    }
    
    public void setHourlyRate( double newHourlyRate )
    {
        if ( newHourlyRate < 0.00 )
            hourlyRate = 0;
        else
            hourlyRate = newHourlyRate;
    }
}

    
    

