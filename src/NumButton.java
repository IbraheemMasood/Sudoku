import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * The buttons used on the number-pad
 */
public class NumButton extends JButton {
    static int value = 0;

    public NumButton() {
        //Num Button Style
        setText(String.valueOf(value));
        setBorder(BorderFactory.createLineBorder(gray));
        setBackground(darkGray);
        setForeground(WHITE);
        setFont(new Font("Inter", Font.BOLD, 40)); //Remember, no comic sans

        //allows the tracking of user input
        addActionListener(new Handler());
    }
}
