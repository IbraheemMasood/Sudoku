import javax.swing.*;
import java.awt.*;

/**
 * Creates the number-pad used by the player to select numbers
 */
public class KeyPadGUI extends JFrame {
    public static NumButton[][] keyArray = new NumButton[9][9];

    //Generates Keypad
    public KeyPadGUI() {
        super("Numbers");
        JPanel keyPad = new JPanel();
        keyPad.setLayout(new GridLayout(3, 3));
        keyPad.setPreferredSize(new Dimension(400, 400));

        //Iterator, used to set number for individual keys
        int numSet = 1;

        //Adds buttons to keypad
        for (int padRow = 0; padRow < 3; padRow++) {
            for (int padCol = 0; padCol < 3; padCol++) {
                NumButton.value = numSet;
                NumButton number = new NumButton();
                keyPad.add(number);
                numSet++;
                keyArray[padRow][padCol] = number;

            }

            add(keyPad);
            pack();
            setVisible(true);

        }
    }
}
