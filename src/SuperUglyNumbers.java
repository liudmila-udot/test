import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class SuperUglyNumbers {

    public static void main(String[] args) {
        int[] primes = {2, 3, 5};
        // super ugly numbers sequence length
        int n = 12;

        int[] result = new int[n];

        // index from result on which prime[i] was last multiplied
        int[] last = new int[primes.length];

        // init first result with 1
        result[0] = 1;

        for (int i = 1; i <= n - 1; i++) {

            int min = Integer.MAX_VALUE;


            for (int j = 0; j <= primes.length - 1; j++) {
                min = Math.min(min, primes[j] * result[last[j]]);
            }
            result[i] = min;

            for (int j = 0; j < last.length; j++) {
                if (result[last[j]] * primes[j] == min) {
                    last[j]++;
                }
            }
        }

        System.out.println(IntStream.of(result)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", ")));
    }
}
