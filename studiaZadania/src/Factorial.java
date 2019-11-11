import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Napisać metodę liczącą iteracyjnie silnię podanej jako argument liczby.
 * Przetestować ją w programie, który pyta użytkownika o kolejne liczby, których silnię trzeba wyliczyć
 * i podaje wyniki dopóki użytkownik nie zrezygnuje z wprowadzania liczb.
 */

public class Factorial {

    private static long calculateFactorial(int number) throws IllegalArgumentException {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result = result * i;
        }
        System.out.println("factorial equals : " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("type in some positive integer values to get it's factorial :");

        while (in.hasNextInt()) {
            int input = in.nextInt();
            try {
                    calculateFactorial(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("TYPE IN ONLY POSITIVE VALUES: TRY AGAIN:");
                    continue;
                }
            System.out.println("type in another value ...");
        }

        System.out.println("non-integer value typed in : this is the end");
        in.close();
    }
}
