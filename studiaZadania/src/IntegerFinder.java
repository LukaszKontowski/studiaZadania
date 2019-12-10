import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Napisać program, który z pliku {user.home}/tab.txt  wczytuje liczby całkowite
 * (liczby w pliku są rozdzielone dowolnymi białymi znakami)  i tworzy tablicę, zawierającą te liczby .
 * W tak zainicjowanej tablicy program znajduje wartość maksymalną oraz wszystkie indeksy
 * w tablicy gdzie taka wartość się znajduje.
 *
 * Program wypisuje na konsoli:
 * w pierwszym wierszu - wszystkie elementy tablicy, rozdzielone spacjami
 * w drugim wierszu - wartość  maksymalną,
 * w trzecim wierszu - indeksy tablicy gdzie ta wartość się znajduje.
 *
 * Przykładowo, jeśli plik {user.home}/tab.txt zawiera:
 * 1 5 5 3
 * -1 2 5 4
 * to na konsoli otrzymujemy:
 * 1 5 5 3 -1 2 5 4
 * 5
 * 1 2 6
 *
 * W przypadku wystąpienia błędów (np. brak pliku, wadliwe dane) należy obsłużyć błąd
 * - wypisać na konsoli TYLKO trzy gwiazdki:
 *
 * ***
 * i zakończyć działanie programu.
 */

public class IntegerFinder {

    private static String allIndexesOfMaxValues(Integer[] allIntValues) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxValue = findMaxValue(allIntValues);
        for (int i = 0; i < allIntValues.length; i++) {
            if (allIntValues[i] == maxValue) {
                stringBuilder.append(i).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private static int findMaxValue(Integer[] allIntValues) {
        return Collections.max(Arrays.asList(allIntValues));
    }

    private static String printArray(Integer[] allIntValues) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allIntValues.length; i++) {
            stringBuilder.append(allIntValues[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    private static Integer[] createArray(File inputFile) {
        Scanner scanner = createScanner(inputFile);
        List<Integer> integersFromFile = getAllIntegers(scanner);
        return integersFromFile.toArray(new Integer[integersFromFile.size()]);
    }

    private static Scanner createScanner(File inputFile) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("***");
            System.exit(1);
        }
        return scanner;
    }

    private static List<Integer> getAllIntegers(Scanner scanner) {
        List<Integer> integersFromFile = new ArrayList<>();
        while (scanner.hasNextInt()) {
            integersFromFile.add(scanner.nextInt());
        }
        return integersFromFile;
    }

    public static void main(String[] args) {
        String fname = null;
        try {
            fname = System.getProperty("user.home") + "/tab.txt";
        } catch (IllegalArgumentException e) {
            System.out.println("***");
            System.exit(1);
        }

        Integer[] allIntValues = createArray(new File(fname));
        System.out.println(printArray(allIntValues));
        System.out.println(findMaxValue(allIntValues));
        System.out.println(allIndexesOfMaxValues(allIntValues));
    }
}
