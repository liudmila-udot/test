package concurrency;

/**
 * @author Liudmila Udot
 * @since 2017.3
 */
public class Concurrency1 {

    public static class Foot implements Runnable {

        String name;

        public Foot(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        (new Thread(new Foot("right"))).start();
        (new Thread(new Foot("left"))).start();
    }
}
