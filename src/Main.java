public class Main {

    public static void main(String[] args) {
        int[] array = new int[20];
        int max = array[0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i = i + 1) {
            array[i] = (int) (Math.random() * 199) + 1;
            System.out.print(" " + array[i]);
        }

        for (int i = 0; i < array.length; i = i + 1) {
            array[i] = (int) (Math.random() * 199) + 1;
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }

        System.out.println();
        System.out.println(" Max Value is " + max);

        System.out.println(" Min Value is " + min);


    }
}


