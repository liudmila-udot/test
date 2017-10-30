package fork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Runner {

    public static void main(String[] s){
        Node root = getRootNode();
        long ret = new ForkJoinPool().invoke(new ValueSumCounter(root));
        System.out.println(ret);
    }

    private static Node getRootNode() {


        return new Node() {
            @Override
            public Collection<Node> getChildren() {
                Collection<Node> ret = new ArrayList<>();
                ret.add(getNode(15));
                ret.add(getNode(20));
                ret.add(getNode(25));
                ret.add(getNode(30));
                return ret;
            }

            @Override
            public long getValue() {
                return 10;
            }
        };
    }

    private static Node getNode(long value){
        return new Node() {
            @Override
            public Collection<Node> getChildren() {
                return new ArrayList<>();
            }

            @Override
            public long getValue() {
                return value;
            }
        };
    }
}
