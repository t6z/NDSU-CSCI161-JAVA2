
/**
 *
 * @author tsmal
 */
public class Client {

    public static void main(String[] args) {
        DoubleStackTest();
        LeakyStackTest();

    }

    public static void DoubleStackTest() {
        DoubleStack<Integer> ds = new DoubleStack<>();
        //Add two elements to each stack
        ds.bluePush(1);
        ds.bluePush(2);
        ds.redPush(-1);
        ds.redPush(-2);
        System.out.println(ds.toString());

        //Print sizes of stacks
        System.out.println("Size of Red: " + ds.redSize());
        System.out.println("Size of Blue: " + ds.blueSize());

        //Pop and Empty methods
        System.out.println("Red Pop: " + ds.redPop());
        System.out.println("Blue Pop: " + ds.bluePop());
        System.out.println("Red Empty? " + ds.redIsEmpty());
        System.out.println("Blue Empty? " + ds.blueIsEmpty());

        //Pop last element in stacks and ask if empty
        System.out.println("Red Pop: " + ds.redPop());
        System.out.println("Blue Pop: " + ds.bluePop());
        System.out.println("Red Empty? " + ds.redIsEmpty());
        System.out.println("Blue Empty? " + ds.blueIsEmpty());

        //Pop on empty stack
        System.out.println("Red Pop: " + ds.redPop());
        System.out.println("Blue Pop: " + ds.bluePop());

        //Push two elements onto stacks
        ds.redPush(-3);
        ds.redPush(-4);
        ds.bluePush(3);
        ds.bluePush(4);

        //Check top methods
        System.out.println("Red Top: " + ds.redTop());
        System.out.println("Blue Top: " + ds.blueTop());

        //Push more
        ds.redPush(-5);
        ds.bluePush(5);

        //size
        System.out.println("Size of Red: " + ds.redSize());
        System.out.println("Size of Blue: " + ds.blueSize());

        //pop
        System.out.println("Red Pop: " + ds.redPop());
        System.out.println("Blue Pop: " + ds.bluePop());

        //Overfill
        ds.redPush(6);
        ds.bluePush(6);
        
        //Push on full stack for both stacks
        try {
            ds.redPush(-7);

        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        try {
            ds.bluePush(7);

        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
        //pop
        System.out.println("Red Pop: " + ds.redPop());
        System.out.println("Blue Pop: " + ds.bluePop());
        System.out.printf("\n\n\n");
    }

    public static void LeakyStackTest() {
        LeakyStack<Integer> ls = new LeakyStack<>();

        ls.push(1);
        ls.push(2);
        System.out.println("LS Contents: " + ls.toString());
        System.out.println("LS Size: " + ls.size());

        System.out.println("LS Pop: " + ls.pop());
        System.out.println("LS Empty? " + ls.isEmpty());

        System.out.println("LS Pop: " + ls.pop());
        System.out.println("LS Empty? " + ls.isEmpty());
        //pop on empty stack
        System.out.println("LS Pop: " + ls.pop());

        ls.push(3);
        ls.push(4);

        System.out.println("LS Top: " + ls.top());
        System.out.println("LS Contents: " + ls.toString());

        ls.push(5);

        System.out.println("LS Contents: " + ls.toString());
        //print size
        System.out.println("LS Size: " + ls.size());

        //push two more elements
        ls.push(6);
        ls.push(7);

        System.out.println("LS Contents: " + ls.toString());
        //Leak
        ls.push(8);
        System.out.println("LS Contents: " + ls.toString());

        //Pop off top
        System.out.println("LS Pop: " + ls.pop());
        System.out.println("LS Contents: " + ls.toString());

    }
}
