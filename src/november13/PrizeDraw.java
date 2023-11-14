package november13;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrizeDraw {
    public static void mega() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] chosenNumbers = new int[7];

        for (int i = 0; i < 7; i++) {
            boolean validInput = false;
            do {
                try {
                    System.out.printf("Enter the %dth number (from 0 to 100): ", i + 1);
                    chosenNumbers[i] = Integer.parseInt(scanner.nextLine());

                    if (chosenNumbers[i] < 0 || chosenNumbers[i] > 100) {
                        throw new NumberFormatException();
                    }

                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer from 0 to 100.");
                }
            } while (!validInput);
        }

        int[] drawnNumbers = new int[7];
        for (int i = 0; i < 7; i++) {
            drawnNumbers[i] = random.nextInt(101);
        }

        System.out.println("Drawn numbers: " + Arrays.toString(drawnNumbers));

        int matches = 0;
        for (int chosen : chosenNumbers) {
            if (Arrays.binarySearch(drawnNumbers, chosen) >= 0) {
                matches++;
            }
        }

        System.out.println("Chosen numbers: " + Arrays.toString(chosenNumbers));
        System.out.println("Matches: " + matches);

        switch (matches) {
            case 5:
                System.out.println("Parabéns! Você ganhou 10 mil reais.");
                break;
            case 6:
                System.out.println("Parabéns! Você ganhou 50 mil reais.");
                break;
            case 7:
                System.out.println("Parabéns! Você ganhou 200 mil reais.");
                break;
            default:
                System.out.println("Infelizmente você não ganhou desta vez. Tente novamente!");
        }

        scanner.close();
    }
}
