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
    /**
     * Used to get time for win-screen
     */
    public static long startTime = System.currentTimeMillis();

    /**
     * Handles mouse actions
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        //Stores the number you clicked from
        if (event.getSource() instanceof NumButton numpad) {
            for (int col = 0; col < 3; col++) {
                //Resets past keypad button when new one is pressed
                for (int row = 0; row < 3; row++) {
                    SudokuGUI.keyArray[col][row].setBackground(new Color(255, 57, 108));
                    SudokuGUI.keyArray[col][row].setForeground(Color.black);
                }
                //Shows what keypad button is currently pressed
                Main.game.currentNum = Integer.parseInt(numpad.getText());
                numpad.setBackground(new Color(50, 30, 130));
                numpad.setForeground(Color.white);

            }
        } else {
            Tile tile = (Tile) event.getSource(); //Checks what button was clicked
            if (!tile.isShown && Main.game.currentNum != 0) {

                tile.setText(String.valueOf(Main.game.currentNum));
                tile.showing = Main.game.currentNum;
                tile.setForeground(new Color(50, 30, 130));
            }

            //Checks if game is won
            if (Main.isWon()) {

                //Gets left image from web-host
                URL imgURLL = null;
                try {
                    imgURLL = new URL("https://i.imgur.com/GH6u1OE.png");
                } catch (MalformedURLException ex) {
                    System.out.println("The image url has expired, please email Ibraheemmasood10@gmail.com and tell him");
                }
                BufferedImage winImageL = null;
                try {
                    assert imgURLL != null;
                    winImageL = ImageIO.read(imgURLL);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Gets right image from web-host
                URL imgURLR = null;
                try {
                    imgURLR = new URL("https://i.imgur.com/Uc4slMU.png");
                } catch (MalformedURLException ex) {
                    System.out.println("The image url has expired, please email Ibraheemmasood10@gmail.com and tell him");
                }
                BufferedImage winImageR = null;
                try {
                    assert imgURLR != null;
                    winImageR = ImageIO.read(imgURLR);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //Creates JLabels with images
                assert winImageL != null;
                JLabel winComponent1 = new JLabel(new ImageIcon(winImageL));

                assert winImageR != null;
                JLabel winComponent2 = new JLabel(new ImageIcon(winImageR));

                //Win-screen animation
                for (int i = 0; i <= 5; i++) {
                    for (int row = 0; row < SudokuGUI.buttonArray.length; row++) {
                        for (int col = 0; col < SudokuGUI.buttonArray.length; col++) {
                            tile = SudokuGUI.buttonArray[row][col];
                            Color background = new Color(i * 50, 30 + col * 20, 30 + row * 20);
                            tile.setBackground(background);
                            tile.setBorder(BorderFactory.createLineBorder(background));
                            //Force renders before sleep to allow for delay
                            tile.paintImmediately(1, 1, tile.getWidth(), tile.getHeight());

                            //Sleeps for 4milliseconds to create animated effect
                            try {
                                TimeUnit.MILLISECONDS.sleep(3);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();

                            }

                            tile = SudokuGUI.buttonArray[col][row];
                            tile.setBackground(background);
                            tile.setBorder(BorderFactory.createLineBorder(background));
                            tile.paintImmediately(1, 1, tile.getWidth(), tile.getHeight());

                        }
                    }
                }


                long endTime = System.currentTimeMillis();

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                //Gets time it took to win
                String elapsedMin = String.valueOf(((endTime - startTime) / 1000) / 60);
                String elapsedSec = String.valueOf(((endTime - startTime) / 1000) % 60);
                //Runs method to generate win-screen
                Main.game.WinScreen(winComponent1, winComponent2, elapsedMin, elapsedSec);


            }

        }
    }
}

