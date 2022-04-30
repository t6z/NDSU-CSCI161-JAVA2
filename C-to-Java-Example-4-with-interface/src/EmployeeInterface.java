/**
 * @author Joe Latimer
 * @version 20180903
 * An example of a super class.
 */
public interface EmployeeInterface {
//
//  private abstract int getId( );    // will not work, access modifier must be public    
//
//  protected abstract int getId( );  // will not work, access modifier must be public
//
//  public abstract int getId( ){ }   // will not work, abstract methods cannot 
//                                    // have bodies, even empty bodies    
//    
//  public int getId( ){ }            // interface methods must be abstract
//    
//  public abstract int getId( );     // WILL WORK
//                                    // But since interface access modifier must be public, and
//                                    // interface methods must be abstract
//                                    // public & abstract do not need to be explicitly stated.
//                                    //           
    int getId( );                     // THIS IS THE TYPICAL STATEMENT FOR AN INTERFACE

    void setId( int newId );

    String getName( );

    void setName( String newName );

    String toString( );

    boolean equals( Object obj );    
}
