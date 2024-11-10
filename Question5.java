import java.util.*;

public class Question5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] strengthLevels = new int[4][3];
        
        System.out.println("Enter strength levels for 4 trainees over 3 rounds (total 12 values):");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                int strength = scanner.nextInt();
                if (strength < 1 || strength > 200) {
                    System.out.println("INVALID INPUT");
                    return;
                }
                strengthLevels[i][j] = strength;
            }
        }

        double[] averageStrengths = new double[4];
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += strengthLevels[i][j];
            }
            averageStrengths[i] = Math.round(sum / 3.0);
        }

        double maxAverageStrength = Arrays.stream(averageStrengths).max().orElse(0);
        
        if (maxAverageStrength < 100) {
            System.out.println("All trainees are unfit.");
        } else {
            System.out.println("Output:");
            for (int i = 0; i < 4; i++) {
                if (averageStrengths[i] == maxAverageStrength) {
                    System.out.println("Trainee Number : " + (i + 1));
                }
            }
        }

        scanner.close();
    }
}
