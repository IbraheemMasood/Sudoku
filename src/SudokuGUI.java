import java.awt.*;
import javax.swing.*;
import java.lang.Math;


/**
 * Generates the main game boards GUI as
 * well as the win-screen
 */

public class SudokuGUI extends JFrame {
    public static JPanel sudBoard = new JPanel();
    public static Tile[][] buttonArray = new Tile[9][9];
    public static NumButton[][] keyArray = new NumButton[3][3];
    public static JPanel keyPad = new JPanel();
    int currentNum = 0; //Tracks users current number

    /**
     * Helper function to generate a win-screen
     */
    public void WinScreen(JLabel component1, JLabel component2, String min, String sec) {
        Color winCol = new Color(255, 2, 80);
        sudBoard.removeAll();
        keyPad.removeAll();
        keyPad.setBorder(null);
        keyPad.setBackground(winCol);
        sudBoard.setBackground(winCol);
        sudBoard.add(component1);
        keyPad.add(component2);
        setTitle("YOU WON IN " + min + " MINUTES AND " + sec + " SECONDS!");
    }

    /**
     * Generates sudoku GUI
     *
     * @param size unnecessary for now, allows for potential scaling in the future
     */
    public SudokuGUI(int size) {

        super("Sudoku by Ibraheem");

        //sets game-board layout and default size
        sudBoard.setLayout(new GridLayout((int) Math.sqrt(size), (int) Math.sqrt(size)));
        sudBoard.setPreferredSize(new Dimension(Tile.SIZE * size, Tile.SIZE * size));


        //Iterator, used to set number for individual keys
        int numSet = 1;

        //Generates Keypad
        keyPad.setLayout(new GridLayout(3, 3));
        keyPad.setBorder(BorderFactory.createLineBorder(new Color(255, 57, 53), 25));


        //Adds button to keypad
        for (int padRow = 0; padRow < 3; padRow++) {
            for (int padCol = 0; padCol < 3; padCol++) {
                NumButton.value = numSet;
                NumButton number = new NumButton();
                keyPad.add(number);
                numSet++;
                keyArray[padRow][padCol] = number;

            }

        }

        //generates buttons
        for (int row = 0; row < (int) Math.sqrt(size); row++) {

            for (int col = 0; col < (int) Math.sqrt(size); col++) {

                JPanel sudBox = new JPanel(new GridLayout(3, 3));

                for (int innerRow = 0; innerRow < (int) Math.sqrt(size); innerRow++) {

                    //Creates a pattern for easier reading
                    if (col == 0 && row != 1 || col == 2 && row != 1 || col == 1 && row == 1) {
                        Tile.color = new Color(255, 157, 193);
                    } else {
                        Tile.color = new Color(255, 97, 108);
                    }

                    //Adds button, sets its value
                    for (int innerCol = 0; innerCol < (int) Math.sqrt(size); innerCol++) {
                        Tile.value = Main.sudNumbers[col * 3 + innerCol][row * 3 + innerRow];
                        Tile.visible = Main.sudIsSolved[col * 3 + innerCol][row * 3 + innerRow];
                        Tile tile = new Tile();
                        sudBox.add(tile);
                        buttonArray[col * 3 + innerCol][row * 3 + innerRow] = tile;
                    }

                }

                setLayout(new GridLayout(1, 2, 0, 0));
                sudBoard.add(sudBox);
                add(sudBoard);
                add(keyPad);
                pack();
                setVisible(true);


            }

        }

    }

}



