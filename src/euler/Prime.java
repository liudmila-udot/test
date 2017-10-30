package euler;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(600851475143l));
    }

    public static long largestPrimeFactor(long n) {
        Set<Long> result = new HashSet<>();

        for (long divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                result.add(divisor);
                result.add(n / divisor);
            }
        }
        Optional<Long> ret = result.stream()
            .sorted(Comparator.reverseOrder())
            .filter(Prime::isPrime)
            .findFirst();

        return ret.orElse(n);
    }

    public static boolean isPrime(long n) {
        for (long divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
