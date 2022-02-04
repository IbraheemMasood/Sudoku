import javax.swing.*;
import java.awt.*;

/**
 * The game tiles
 */
public class Tile extends JButton {
    /**
     * The size of the button in pixels
     */
    static final int SIZE = 70;

    /**
     * Button color
     */
    static Color color = Color.WHITE;

    /**
     * Tracks whether a tile is visible or not
     */
    static boolean visible = false;

    /**
     * Tracks what number a tile holds
     */
    static int value = 0;

    /**
     * Holds the number inputted by the user
     */
    int showing = 0;

    /**
     * Workaround to let me see if individual tiles are viewable, changing visible to non-static ruins rendering
     */
    boolean isShown = visible;


    /**
     * Holds the tile specifications
     */
    public Tile() {

        setText(String.valueOf(value));//Shows value on button
        //tile style
        setBorder(BorderFactory.createLineBorder(new Color(65, 67, 68)));
        setBackground(color);
        setForeground(Color.black);
        setFont(new Font("Retro Gaming", Font.PLAIN, 40));

        //Sets button to blank if value isn't shown
        if (!isShown) {
            setText(" ");
        }

        //Allows the tracking of user input
        addActionListener(new Handler());

    }
}

