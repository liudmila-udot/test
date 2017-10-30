package euler;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class Multipliers35 {

    public static void main(String[] args) {

        int amount3 = 0;
        int base = 1;

        while (base * 3 < 1000) {
            amount3 = amount3 + base * 3;
            base++;
        }

        int amount5 = 0;
        base = 1;

        while (base * 5 < 1000) {
            if ((base * 5) % 3 != 0) {
                amount5 = amount5 + base * 5;
            }
            base++;
        }

        System.out.println(amount3 + amount5);
    }
}
