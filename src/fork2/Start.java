package fork2;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Start {
    public static void main(String[] args) {

        final int componentValue = 1000000;
        Long beginT = System.nanoTime();
        ForkJoinPool fjp = new ForkJoinPool();
        StreamMy test = new StreamMy(componentValue,0,componentValue);
        fjp.invoke(test);
        Long endT = System.nanoTime();
        Long timebetweenStartEnd = endT - beginT;
        System.out.println("=====time========" +timebetweenStartEnd);

    }
}