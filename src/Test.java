import java.util.ArrayList;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Test {
    public static void main(String[] args){
        String[] input = new String[3];
        input[0] = "Mary";
        input[1] = "Ivan";
        input[2] = "Mary";
        System.out.println(findMax(3,"1 2 3 1 # # 1"));
    }

    static long findMax(int n, String tree) {
        String[] array = tree.split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        int elementsCount = 0;
        int powerOfTwo = 0;
        int startIndex = 0;
        int endIndex = 0;

        while (elementsCount <= n) {
            endIndex = startIndex + (int) Math.pow((double) 2, (double) powerOfTwo);
            int amount = 0;
            for (int i = startIndex; i < endIndex; i++) {
                if (array[i].equals("#")) {
                    amount = amount + 0;
                } else {
                    amount = amount + Integer.parseInt(array[i]);
                }
                elementsCount++;
            }
            list.add(amount);
            startIndex = endIndex;
            powerOfTwo++;
        }
        return (long) list.get(2);

    }
}
