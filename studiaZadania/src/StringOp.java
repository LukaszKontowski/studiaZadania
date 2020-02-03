/**
 * Napisać program, który jako pierwszy argument wywołania uzyskuje  łańcuch znakowy i:
 *
 *     podaje na konsoli długość łańcucha,
 *     wyprowadza pierwszy i ostatni znak (rozdzielone spacją)
 *     wyprowadza podłańcuch od 4 znaku do ostatniego znaku,
 *     wyprowadza podłańcuch od 4 znaku do przedostatniego znaku,
 *     wyprowadza informacje o tym ile razy w wejściowym łańcuchu występuje zadany
 *     (podany jako drugi argument wywołania programu)  podłańcuch (np. ile razy w łańcuchu
 *     "podstoleczne tramwaje mialy postoje po sto razy dziennie" występuje podlancuch "sto"
 *     - w tym przypadku 3)
 *     tworzy tablicę wszystkich słów  łańcucha (tu slowa niech oznaczają zestawy znaków
 *     rozdzielone spacjami, przecinkami, kropkami i średnikami) i wyprowadza jej elementy
 *     w jednym wierszu, rozdzielone znakiem _ (podkreślenie) ,
 *     stwierdzia czy pierwsze i ostatnie słowo łańcucha jest takie samo.
 *
 * Działanie programu winno wyglądać w następujący sposób.
 * Załóżmy, że jako argumenty wywołania programu podano:
 *
 * "ala ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala" psa
 *
 *
 * Przy takim wywołaniu na konsoli powinniśmy uzyskać wynik:
 *
 * 1) 55
 * 2) a a
 * 3) ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala
 * 4) ma kota, ale  ma psa.psa.hopsa. psa kota psa ma al
 * 5) 5
 * 6) ala_ma_kota_ale_ma_psa_psa_hopsa_psa_kota_psa_ma_ala
 * 7) true
 */

public class StringOp {

    private int getLengthOfGivenString(String text) {
        return text.toCharArray().length;
    }

    private String getFirstAndLastChar(String text) {
        return text.toCharArray()[0] + " " + text.toCharArray()[getLengthOfGivenString(text) - 1];
    }

    private String fromFourth(String text) {
        return text.substring(4);
    }

    private String fromFourthDeleteLast(String text) {
        return text.substring(4, text.toCharArray().length - 1);
    }

    private int countAppearances(String text, String pattern) {
        int count = 0;
        while (text.contains(pattern)) {
            text = text.substring(text.indexOf(pattern) + pattern.length());
            count++;
        }
        return count;
    }

    private String transformGivenText(String text) {
        String[] wordsArray = createArrayFromGivenString(text);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(wordsArray[0]);
        for (int i = 1; i < wordsArray.length; i++) {
            stringBuilder.append("_").append(wordsArray[i]);
        }
        return stringBuilder.toString().replaceAll(" ", "_");
    }

    private boolean isFirstWordEqualToLast(String text) {
        String[] wordsArray = createArrayFromGivenString(text);
        return (wordsArray[0].equals(wordsArray[wordsArray.length - 1]));
    }

        // a Helper method for two upper methods
        private String[] createArrayFromGivenString(String text) {
            return text.split("[ ,;\\.]+");
        }

    public static void main(String[] args) throws IndexOutOfBoundsException, NullPointerException {
        StringOp operator = new StringOp();
        try {
            System.out.println("1) " + operator.getLengthOfGivenString(args[0]));
            System.out.println("2) " + operator.getFirstAndLastChar(args[0]));
            System.out.println("3) " + operator.fromFourth(args[0]));
            System.out.println("4) " + operator.fromFourthDeleteLast(args[0]));
            System.out.println("5) " + operator.countAppearances(args[0], args[1]));
            System.out.println("6) " + operator.transformGivenText(args[0]));
            System.out.println("7) " + operator.isFirstWordEqualToLast(args[0]));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("***");
        }

    }
}
