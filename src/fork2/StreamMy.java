package fork2;

import java.util.concurrent.RecursiveAction;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class StreamMy extends RecursiveAction {

    final int countProcessors = Runtime.getRuntime().availableProcessors();
    final int countLimit = 500000;
    int start;
    int end;
    int forSplit;

    StreamMy(int componentValue,int startNumber, int endNumber) {
        forSplit = componentValue;
        start = startNumber;
        end = endNumber;
    }
    protected void compute() {
        if (countProcessors == 1 || end - start <= countLimit) {
            System.out.println("=run=");
            for(int i = start; i <= end; i++) {
                new Calc().go(i);
            }
        } else {
            int middle = (start + end)/ 2;
            invokeAll(new StreamMy(forSplit, 0, middle),
                    new StreamMy(forSplit, middle+1, end));
        }
    }
}
