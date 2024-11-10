import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of segment k:");
        int k = scanner.nextInt();

        System.out.println("Enter the size of array n:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Output:");
        System.out.println(findMinOfMax(array, k));

        scanner.close();
    }

    public static int findMinOfMax(int[] array, int k) {
        int minOfMax = Integer.MAX_VALUE;

        for (int i = 0; i <= array.length - k; i++) {
            int maxInSubarray = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxInSubarray = Math.max(maxInSubarray, array[j]);
            }
            minOfMax = Math.min(minOfMax, maxInSubarray);
        }

        return minOfMax;
    }
}
