import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * The number-pad buttons
 */
public class NumButton extends JButton {
    static int value = 0;

    /**
     * Holds the number button specifications
     */
    public NumButton() {
        //Num Button Style
        setText(String.valueOf(value));
        setBorder(BorderFactory.createLineBorder(BLACK));
        setBackground(new Color(250, 97, 108));
        setForeground(black);
        setFont(new Font("Retro Gaming", Font.PLAIN, 60)); //Remember, no comic sans

        //allows the tracking of user input
        addActionListener(new Handler());
    }
}
