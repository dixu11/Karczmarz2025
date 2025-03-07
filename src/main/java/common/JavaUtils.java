package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaUtils {
    public static int readAnswer(int min, int max) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wpisz numer wybranej opcji:");
            int input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Liczba ze złego przedziału");
                return readAnswer(min, max);
            }
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Należy podać cyfrę!");
            return readAnswer(min, max);
        }
    }

    public static void clear() {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }
}
