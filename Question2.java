import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int n = scanner.nextInt();
        int[] startIndex = new int[n];
        for (int i = 0; i < n; i++) {
            startIndex[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] endIndex = new int[m];
        for (int i = 0; i < m; i++) {
            endIndex[i] = scanner.nextInt();
        }

        List<Integer> results = countBees(s, startIndex, endIndex);
        System.out.println("Output:");
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public static List<Integer> countBees(String s, int[] startIndex, int[] endIndex) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < startIndex.length; i++) {
            int start = startIndex[i] - 1;
            int end = endIndex[i] - 1;
            results.add(countBeesInRange(s, start, end));
        }

        return results;
    }

    private static int countBeesInRange(String s, int start, int end) {
        int firstFlower = -1;
        int lastFlower = -1;

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '|') {
                if (firstFlower == -1) {
                    firstFlower = i;
                }
                lastFlower = i;
            }
        }

        if (firstFlower == -1 || lastFlower == -1 || firstFlower == lastFlower) {
            return 0;
        }

        int beeCount = 0;
        for (int i = firstFlower + 1; i < lastFlower; i++) {
            if (s.charAt(i) == '*') {
                beeCount++;
            }
        }

        return beeCount;
    }
}
