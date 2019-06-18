package Utils;

public class ArrayUtil {

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t + "\t");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (Integer i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printArrays(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
