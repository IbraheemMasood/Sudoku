import java.awt.*;
import javax.swing.*;
import java.lang.Math;

/**
 * Generates the main game boards GUI as
 * well as the win-screen
  */

public class SudokuGUI extends JFrame {

    public static JLayeredPane sudBoard = new JLayeredPane();
    public static Tile[][] buttonArray = new Tile[9][9];

    /**
     * Helper function to generate a win-screen
     * TODO add timer that shows time it took to win
     */
    public static void WinScreen(JLabel component) {
        JPanel winScreen = new JPanel();
        winScreen.setSize(630, 630);
        winScreen.add(component);
        sudBoard.removeAll();
        sudBoard.setLayout(null);
        sudBoard.add(winScreen);
        sudBoard.setLayer(winScreen, 3, 0);
        winScreen.setBackground(new Color(159, 18, 25));

    }

    /**
     * Generates sudoku GUI
     * @param size unnecessary for now, allows for potential scaling in the future
     */
    public SudokuGUI(int size) {

        super("Sudoku by Ibraheem");

        //sets game-board layout and default size
        sudBoard.setLayout(new GridLayout((int) Math.sqrt(size), (int) Math.sqrt(size)));
        sudBoard.setPreferredSize(new Dimension(Tile.SIZE * size, Tile.SIZE * size));

        //generates buttons
        for (int row = 0; row < (int) Math.sqrt(size); row++) {

            for (int col = 0; col < (int) Math.sqrt(size); col++) {

                JPanel sudBox = new JPanel(new GridLayout(3, 3));

                for (int innerRow = 0; innerRow < (int) Math.sqrt(size); innerRow++) {

                    //Creates a pattern for easier reading
                    if (col == 0 && row != 1 || col == 2 && row != 1 || col == 1 && row == 1) {
                        Tile.color = Color.GRAY;
                    } else {
                        Tile.color = Color.LIGHT_GRAY;
                    }

                    //Adds buttons, sets their value
                    for (int innerCol = 0; innerCol < (int) Math.sqrt(size); innerCol++) {
                        Tile tile = new Tile();
                        Tile.value = Main.sudNumbers[col * 3 + innerCol][row * 3 + innerRow];
                        Tile.visible = Main.sudIsSolved[col * 3 + innerCol][row * 3 + innerRow];
                        sudBox.add(tile);
                        buttonArray[col * 3 + innerCol][row * 3 + innerRow] = tile;
                    }

                }

                sudBoard.add(sudBox);
                add(sudBoard);
                pack();
                setVisible(true);


            }

        }

    }

}


