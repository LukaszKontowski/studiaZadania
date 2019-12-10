import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 Wyobraźmy sobie, że z sieci przychodzą i zapisywane są na nasz dysk jakieś dane.
 Każdą kolejną porcję przychodzących danych nazwiemy pakietem.
 Każdy kolejny przychodzący pakiet (licząc od drugiego do piątego włącznie) ma rozmiar
 dwa razy większy niż poprzedni, a poczynając od szóstego - ma rozmiar 3 razy większy niż poprzedni.

 Program ma określić i podać  ile pakietów zmieści się na dysku,
 dla każdego mieszczącego się pakietu wypisać informację o jego numerze i wielkości
 oraz podać zajmowaną przez pakiety przestrzeń dyskową.

 Dane (pobierane z pliku {user.home}/pakiety.txt):

 rozmiar pierwszego pakietu w bajtach,
 rozmiar dostępnej przestrzeni dyskowej w megabajtach.

 Dane są zapisane jako liczby całkowite rozdzielone białymi znakami.

 Wyniki (wypisywane na konsolę w kolejnych wierszach):

 liczba pakietów mieszczących się w dostępnej przestrzeni dyskowej,
 dla każdego zaakceptowanego (mieszczącego się jeszcze na dysku) pakietu jego numer i wielkość w bajtach.
 rozmiar zajmowanej przez pakiety przestrzeni dyskowej


 Przykładowo, jeśli w pliku {user.home}/pakiety.txt mamy następujące dane:
 100 1
 to wynik na konsoli winien wyglądać tak:
 10
 1 100
 2 200
 3 400
 4 800
 5 1600
 6 4800
 7 14400
 8 43200
 9 129600
 10 388800
 583900


 W przypadku wystąpienia błędów (np. brak pliku, wadliwe dane) należy wypisać na konsoli TYLKO trzy gwiazdki:

 ***
 i zakończyć działanie programu.
 */

public class PackageSizes {

    private static List<Integer> allPackageSizes = new ArrayList<>();

    private static String printAllPackageSizes() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= allPackageSizes.size(); i++) {
            stringBuilder.append(i).append(" ").append(allPackageSizes.get(i - 1));
            if (i < allPackageSizes.size()) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    private static int numberOfAllPackages() {
        return allPackageSizes.size();
    }

    private static int sumOfAllPackages(int[] twoIntegersArray) {
        int sizeOfCurrentPackage = twoIntegersArray[0];
        int totalDiskSpace = twoIntegersArray[1] * 1000000;
        int currentSumOfPackages = 0;
        for (int i = 0; sizeOfCurrentPackage <= totalDiskSpace && currentSumOfPackages < totalDiskSpace; i++) {
            if (i < 5 && currentSumOfPackages + sizeOfCurrentPackage <= totalDiskSpace) {
                currentSumOfPackages += sizeOfCurrentPackage;
                allPackageSizes.add(sizeOfCurrentPackage);
                sizeOfCurrentPackage = sizeOfCurrentPackage * 2;
                if (i == 4) {
                    sizeOfCurrentPackage = sizeOfCurrentPackage * 3/2;
                }
            } else if (i >= 5 && currentSumOfPackages + sizeOfCurrentPackage <= totalDiskSpace) {
                currentSumOfPackages += sizeOfCurrentPackage;
                allPackageSizes.add(sizeOfCurrentPackage);
                sizeOfCurrentPackage = sizeOfCurrentPackage * 3;
            } else {
                break;
            }
        }
        return currentSumOfPackages;
    }

    private static int[] twoIntegersArray(File inputFile) {
        Scanner scanner = createScanner(inputFile);
        int[] twoIntegersArray = new int[2];
        twoIntegersArray[0] = scanner.nextInt();
        twoIntegersArray[1] = scanner.nextInt();
        if (twoIntegersArray[0] < 0 || twoIntegersArray[1] < 1) {
            throw new IllegalArgumentException();
        }
        return twoIntegersArray;
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

    public static void main(String[] args) {
        String fname = null;
        try {
            fname = System.getProperty("user.home") + "/pakiety.txt";
        } catch (IllegalArgumentException e) {
            System.out.println("***");
            System.exit(1);
        }

        int[] inputValues = new int[]{};
        try {
            inputValues = twoIntegersArray(new File(fname));
        } catch (IllegalArgumentException e) {
            System.out.println("***");
            System.exit(1);
        }
        int sumOfPackages = sumOfAllPackages(inputValues);
        System.out.println(numberOfAllPackages());
        System.out.println(printAllPackageSizes());
        System.out.println(sumOfPackages);
    }
}
