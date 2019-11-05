import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Napisać program proszący użytkownika o wprowadzenie kolejno 5 napisów (łańcuchów znakowych),
 * sprawdzający, czy są wśród nich takie same napisy i podający liczbę takich samych napisów.
 */

public class EqualInputs {

    public static void main(String[] args) {
        List<String> fiveStrings = new ArrayList<>();
        Set<String> inputValues = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            String input = JOptionPane.showInputDialog("Proszę, wprowadź " + (i+1) + ". napis: ");
            fiveStrings.add(input);
            inputValues.add(input);
        }

        boolean containsDuplicates = false;
        if (inputValues.size() != fiveStrings.size()) {
            containsDuplicates = true;
            JOptionPane.showMessageDialog(null, "Wśród wprowadzonych napisów były duplikaty.");
        } else {
            JOptionPane.showMessageDialog(null, "Wśród wprowadzonych napisów nie było duplikatów.");
        }

        int numberOfDuplicates = fiveStrings.size() - inputValues.size();
        JOptionPane.showMessageDialog(null, "Liczba takich samych napisów: " + numberOfDuplicates);

    }
}
