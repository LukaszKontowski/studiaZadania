package towary;

/**
 *
 * Kod, działający w wątku A czyta z pliku ../Towary.txt informacje o towarach w postaci:
 *
 * id_towaru waga
 *
 * tworzy obiekty klasy Towar, zawierające przeczytane informacje oraz wyprowadza na konsolę informacje
 * o liczbie utworzonych  obiektów. Informacja ma być wyprowadzana co 200 obiektów w postaci:
 *
 * utworzono 200 obiektów
 * utworzono 400 obiektów
 * utworzono 600 obiektów
 * itd.
 *
 * Kod działający równolegle w innym wątku (B) sięga po te obiekty, sumuje wagę  towarów
 * i  wyprowadza na konsolę informację o przeprowadzonym sumowaniu co 100 obiektów np.:
 * policzono wage 100 towarów
 * policzono wage 200 towarów
 * policzono wage 300 towarów
 * itd.
 * Na końcu podaje sumaryczną wagę wszystkich towarów.
 *
 */

public class Main {
    public static void main(String[] args) {
        Thread firstThread = new TowarCreator();
        Thread secondThread = new WeightConsumer();
        firstThread.start();
        secondThread.start();
    }
}
