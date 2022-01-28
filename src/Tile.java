import javax.swing.*;
import java.awt.*;

/**
 * The game tiles
 */
public class Tile extends JButton {

    static final int SIZE = 70; //The size of the button in pixels
    static Color color = Color.WHITE; //Editable button color
    static boolean visible = false; //Tracks whether a tile is visible or not
    static int value = 0; //Tracks what number a tile holds
    int showing = 0;//Holds the number inputted by the user
    boolean isShown = visible;//workaround to let me see if individual tiles are viewable, changing visible to non-static ruins rendering


    public Tile() {

        setText(String.valueOf(value));//Shows value on button
        setBorder(BorderFactory.createLineBorder(Color.black));
        //tile style
        setMargin(new Insets(0, 0, 0, 0));
        setBackground(color);
        setForeground(Color.black);
        setFont(new Font("Inter", Font.PLAIN, 25));

        //Sets button to blank if value isn't shown
        if (!isShown) {
            setText(" ");
        }

        //Allows the tracking of user input
        addActionListener(new Handler());

    }
}

