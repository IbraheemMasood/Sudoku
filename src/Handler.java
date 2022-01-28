import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Runs code depending on game state and user input
 */
public class Handler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        //stores the number you clicked from
        if (e.getSource() instanceof NumButton numpad) {
            Main.currentNum = Integer.parseInt(numpad.getText());

        } else {
            Tile tile = (Tile) e.getSource(); //Checks what button was clicked
            if (!Tile.visible && Main.currentNum != 0) {
                tile.setText(String.valueOf(Main.currentNum));
                tile.showing = Main.currentNum;
                Main.currentNum = 0;
                tile.setForeground(new Color(7, 0, 120));
            }

            //Checks if game is won
            if (Main.isWon()) {

                //Gets image from webhost
                URL imgURL = null;
                try {
                    imgURL = new URL("https://i.imgur.com/gFaGrll.png");
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                BufferedImage winImage = null;
                try {
                    winImage = ImageIO.read(imgURL);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //Creates JLabel with image
                JLabel winComponent = new JLabel(new ImageIcon(winImage));

                //Win-screen animation
                for (int i = 0; i <= 5; i++) {
                    for (int row = 0; row < SudokuGUI.buttonArray.length; row++) {
                        for (int col = 0; col < SudokuGUI.buttonArray.length; col++) {
                            tile = SudokuGUI.buttonArray[row][col];
                            Color background = new Color(250, 30 + col * 20, 30 + row * 20);
                            tile.setBackground(background);
                            //Force renders before sleep to allow for delay
                            tile.paintImmediately(1, 1, tile.getWidth(), tile.getHeight());

                            //Sleeps for 4milliseconds to create animated effect
                            try {
                                TimeUnit.MILLISECONDS.sleep(4);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();

                            }

                            tile = SudokuGUI.buttonArray[col][row];
                            tile.setBackground(background);
                            tile.paintImmediately(1, 1, tile.getWidth(), tile.getHeight());

                        }
                    }
                }
                //Runs method to generate win-screen
                SudokuGUI.WinScreen(winComponent);


            }

        }
    }
}

