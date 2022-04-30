public final class Hourly extends Employee {
//    private int id;
//    private String name;
//    private int salary;
    private double hourlyRate;
    public Hourly( )
    {
//        id = 0;
//        name = null;
//        salary = 0;
        hourlyRate = 0.0;
    }
    public Hourly( int id, String name, double hourlyRate )
    {
        super( id, name );
        setHourlyRate( hourlyRate );
        super.name = name;
    }
//    public int getId( ) {
//        return id;
//    }
//    public String getName( )
//    {
//        return name;
//    }
//    public int getSalary( )
//    {
//        return salary;
//    }
    public double getHourlyRate( )
    {
        return hourlyRate;
    }
//    public void setId( int newId )
//    {
//        id = newId;
//    }
//    public void setName( String newName )
//    {
//        name = newName;
//    }
//    public void setSalary( int newSalary )
//    {
//        salary = newSalary;
//    }  
    public void setHourlyRate( double newHourlyRate )
    {
        if ( newHourlyRate < 0.00 )
            hourlyRate = 0;
        else
            hourlyRate = newHourlyRate;
    }
    
    /**
     * 
     * @return 
     */
    public String toString( )
    {
        return super.toString() + getClass().getName() + ":" + hourlyRate;
    }
    
    
    /**
     * equals
     * 
     * @param o  the instance being compared
     * @return   returns true if equal, false otherwise
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Hourly ) )
            return false;   
        Hourly e = ( Hourly ) o;
        return //id == e.id
                //&& name.equals( e.name )
                //&& salary == e.salary
                super.equals( o )
                && Math.abs( hourlyRate - e.hourlyRate ) < .01;        
    }
}
