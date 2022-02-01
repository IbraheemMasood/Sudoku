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
    //Starts timer
    public static long startTime = System.currentTimeMillis();

    @Override
    public void actionPerformed(ActionEvent e) {

        //Stores the number you clicked from
        if (e.getSource() instanceof NumButton numpad) {
            Main.gameGUI.currentNum = Integer.parseInt(numpad.getText());

        } else {
            Tile tile = (Tile) e.getSource(); //Checks what button was clicked
            if (!tile.isShown && Main.gameGUI.currentNum != 0) {
                tile.setText(String.valueOf(Main.gameGUI.currentNum));
                tile.showing = Main.gameGUI.currentNum;
                tile.setForeground(new Color(11, 0, 100));
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
                    winImageR = ImageIO.read(imgURLR);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //Creates JLabel with image
                JLabel winComponent1 = new JLabel(new ImageIcon(winImageL));
                JLabel winComponent2 = new JLabel(new ImageIcon(winImageR));

                //Win-screen animation
                for (int i = 0; i <= 5; i++) {
                    for (int row = 0; row < SudokuGUI.buttonArray.length; row++) {
                        for (int col = 0; col < SudokuGUI.buttonArray.length; col++) {
                            tile = SudokuGUI.buttonArray[row][col];
                            Color background = new Color(250, 30 + col * 20, 30 + row * 20);
                            tile.setBackground(background);
                            tile.setBorder(BorderFactory.createLineBorder(background));
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
                long endTime = System.currentTimeMillis();
                String elapsedMin = String.valueOf(((endTime - startTime) / 1000) / 60);
                String elapsedSec = String.valueOf(((endTime - startTime) / 1000) % 60);
                Main.gameGUI.WinScreen(winComponent1, winComponent2, elapsedMin, elapsedSec);


            }

        }
    }
}

