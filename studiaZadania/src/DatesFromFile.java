import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Daty w pliku tekstowym  o nazwie{user.home}/test/daty.txt maja postać YYYY-MM-DD (rok- miesiac- dzien).
 * Oprócz dat, plik zawiera inne informacje.  Wczytać plik i wypisać w jednym wierszu wszystkie poprawne daty
 * - czyli: po wyróżnieniu wszystkich fragmentów, które mogą być datami sprawdzić ich poprawnośc
 * (np. czy właściwa jest liczba dni w miesiącu)
 *
 * Program powinien w specyficzny sposób traktować niejednozanczną informację
 * (np. 2009-01-111 - czy to błędna data czy potraktowac ją jako 2009-01-11).
 * Sposób traktowania takich sytuacji wyjaśnia poniższy przykład.
 *
 * Dane w pliku:
 *
 * 2007-01-12Jakis txt2008-01-31 xxx 2008-02-29 2008-15-10 2008-19-45 2009-05-01
 * 20999-11-11 pppp 2001-00-01 09-01-01 2001-01-00 2009-01-111 2009-02-29 1998-11-11
 *
 * Program powinien wyprowadzić:
 *
 * 2007-01-12 2008-01-31 2008-02-29 2009-05-01 1998-11-11
 */

public class DatesFromFile {
    // BufferedReader
    // Regex
    // Date
    //System.out.printf("%tF", Calendar.getInstance());
    private static final String dateRegex = "\\d\\d\\d\\d-\\d\\d-\\d\\d";

    private static List<String> datesList = new ArrayList<>();

    private static void printDatesList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String date : datesList) {
            stringBuilder.append(date + " ");
        }
        System.out.println(stringBuilder.toString());
    }

    private static void createDatesList(String fileName) {
        Scanner scanner = createScanner(new File(fileName));
        while (scanner.hasNext()) {
            String currentStringCleared = cleanCurrentStringIfNeeded(scanner.next());
            if (isValidDate(currentStringCleared)) {
                datesList.add(currentStringCleared);
            }
        }
    }
        private static String cleanCurrentStringIfNeeded(String currentString) {
            StringBuilder stringBuilder = new StringBuilder(currentString);
            while (stringBuilder.toString().matches(".*\\D+" + dateRegex + ".*")) {
                stringBuilder.deleteCharAt(0);
            }
            while (stringBuilder.toString().matches(dateRegex + "\\D+.*")) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            return stringBuilder.toString();
        }

        private static boolean isValidDate(String inDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(inDate);
            } catch (ParseException pe) {
                return false;
            }
            return inDate.matches(dateRegex);
        }

        private static Scanner createScanner(File inputFile) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                System.out.println("***FileNotFoundException***");
                System.exit(1);
            }
            return scanner;
        }

    private static String getFileName(String fileDirection) {
        String fname = null;
        try {
            fname = System.getProperty("user.home") + fileDirection;
        } catch (IllegalArgumentException e) {
            System.out.println("***IllegalArgumentException***");
            System.exit(1);
        }
        return fname;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        String fName = getFileName("/test/daty.txt");
        createDatesList(fName);
        printDatesList();
    }
}
