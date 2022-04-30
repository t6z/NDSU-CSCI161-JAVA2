
public class GenArray<E> implements IntToGenericInterfaceGen<E> {

    private E[] list;
    
    private int count;  
    
    public GenArray( )
    {                                   // cannot create an array generic type
        list = ( E[] ) new Object[10];  // must create an array of Object class
                                        // then cast to the generic type
        count = 0;
    }
    
    public GenArray( int length )
    {
        list = ( E[] ) new Object[ length ]; 
        count = 0;
    }

    public int getCount( ) { return count; }
    
    // no setCount method, count is controlled by class
    
    // no getList method, user cannot get entire array
    
    // no setList method, user cannot set the entire array
    
    public int getCapacity( ) { return list.length; }
    
    
    public void add( E newInt )
    {
        if ( count == list.length )
            throw new IllegalArgumentException( "IntArray is full" );
        list[ count++ ] = newInt;
    }
    
    public E get( int index )
    {
        if ( count == 0 )
            throw new IllegalArgumentException( "IntArray is empty" );
        
        if ( index < 0 || index >= count )
            throw new IllegalArgumentException( "index out of bounds");        
        
        return list[ index ];
    }
        
    public String toString( )
    {
        String returnString = getClass().getName();
        
        returnString = returnString + ":count = " + count + ":list = [";
            
        for ( int i = 0; i < count; i++ )
            returnString = returnString + " " + list[i].toString( ) + " ";
        
        returnString += "]";
        
        return returnString;                
    }

    public boolean equals( Object o )
    {
        if ( !( o instanceof IntArray ) )
            return false;
        
        IntArray intArrayObj = ( IntArray ) o;
        
        if ( count != intArrayObj.getCount( ) )
            return false;
        
        for ( int i = 0; i < count; i++ )
            if ( list[i].equals( intArrayObj.get( i ) ) )
                return false;
        
        return true;        
    }
}

    

