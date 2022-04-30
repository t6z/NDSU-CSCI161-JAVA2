/*
 */

/**
 *
 * @author tsmal
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 23;
        
        System.out.println(isPrime(n));
    }
    
    public static boolean isPrime(int n){
        if (n <= 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            if (n % 2 == 0) {
                return false;
            }
            for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
    }
    
}
