import java.util.*;

public class Question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of candy flavors:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the candy flavors:");
        String[] flavors = new String[n];
        for (int i = 0; i < n; i++) {
            flavors[i] = scanner.nextLine();
        }

        String result = findOddFrequencyFlavor(flavors);
        System.out.println("Output:");
        System.out.println(result);

        scanner.close();
    }

    public static String findOddFrequencyFlavor(String[] flavors) {
        Map<String, Integer> flavorCount = new LinkedHashMap<>();

        for (String flavor : flavors) {
            flavorCount.put(flavor, flavorCount.getOrDefault(flavor, 0) + 1);
        }

        System.out.println("Frequency of each flavor:");
        for (Map.Entry<String, Integer> entry : flavorCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " candies");
        }

        for (Map.Entry<String, Integer> entry : flavorCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return "All are even";
    }
}
