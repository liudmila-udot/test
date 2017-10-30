public class Main2 {

    public static void main(String[] args) {
        int[] array1 = new int[15];
        for (int i = 0; i < array1.length; i=i+1) {
            array1[i] = (int) (Math.random() * 5) + 5;
        }
        System.out.print(java.util.Arrays.toString(array1));

        int[] array2= new int[15];
        for (int i=0; i<array2.length; i=i +1) {
            array2[i] = (int) (Math.random() * 5) + 10;
        }
        System.out.print("   " + java.util.Arrays.toString(array2));
        int[] array3= new int[15];
        for(int i = 0; i<array1.length; i=i +1){
            array3[i]= array1[i] + array2[i];
        }
        System.out.print("   " + java.util.Arrays.toString(array3));
    }
}