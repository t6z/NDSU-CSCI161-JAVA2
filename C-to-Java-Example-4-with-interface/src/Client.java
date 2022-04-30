
/**
 * An example client class with an explicit test of each method.
 * 
 * 
 * @author latimerlocal
 * @version 20180903
 */
public class Client {

    public static void main(String[] args) {
       
        System.out.println( "\n=====  Explicit test of each method:  =====\n" );
        
        System.out.println( "\tOverload constructor");
        
        System.out.println( "\tBoss boss1 = new Boss( 123, \"Sue\", 250000 );\n" );
        Boss boss1 = new Boss( 123, "Sue", 250000 );
        
        System.out.println( "\ttoString( ) method" );
        System.out.println( "\tboss1.toString();" ); 
        System.out.println( "\t" +  boss1.toString() + "\n" ); 
        
        System.out.println( "\tCalling each setter method:" );
        System.out.println( "\tboss1.setId( 333 );" );
        boss1.setId( 333 );
        System.out.println( "\tboss1.setName( \"Judy\" );" );
        boss1.setName( "Judy" );
        System.out.println("\tboss1.setSalary( 375000 );\n");
        boss1.setSalary( 375000 );
        
        System.out.println( "\tCalling each getter method:" );
        System.out.println( "\tboss1.getId( )     = " + boss1.getId( ) );
        System.out.println( "\tboss1.getName( )   = " + boss1.getName( ) );
        System.out.println( "\tboss1.getSalary( ) = " + boss1.getSalary ( ) + "\n" );
        
        System.out.println( "\tCreate boss2 to test equals method:" );
        System.out.println( "\tBoss boss2 = new Boss( 123, \"Sue\", 250000 );\n" );
        Boss boss2 = new Boss( 123, "Sue", 250000 );        
       
        System.out.println( "\tboss1.equals( boss1 ) = " +  boss1.equals( boss1 ) );
        System.out.println( "\tboss1.equals( boss2 ) = " +  boss1.equals( boss2 ) );
                
        System.out.println( "\n=====  End of Explicit test of each method:  =====\n" );
    }
    
}
