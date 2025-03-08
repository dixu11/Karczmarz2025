package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaUtils {
    public static int readAnswer(int min, int max) {
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input < min || input > max) {
                errorMessage("\t#Nie rozumiem Twojego polecenia. Wybierz jedną z dostępnych opcji.");
                return readAnswer(min, max);
            }
            return input;
        } catch (InputMismatchException e) {
            errorMessage("\t#Nie rozumiem Twojego polecenia. Wybierz jedną z dostępnych opcji.");
            return readAnswer(min, max);
        }
    }

    private static void errorMessage(String message) {
        System.out.println(message);
    }


    public static void clear() {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }
}
