package numTeller;

import static javax.swing.JOptionPane.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = showInputDialog("Podaj 3 liczby");
        Scanner scan = new Scanner(input);
        String msg = "";
        try {
            msg += NumTeller.say(scan.nextInt()) + '\n';
            msg += NumTeller.say(scan.nextInt()) + '\n';
            msg += NumTeller.say(scan.nextInt()) + '\n';
        } catch (NoSuchElementException e) {
            showMessageDialog(null, "Wrong input, you may try again.");
            msg = "";
        }
        System.out.println(msg);
    }
}
