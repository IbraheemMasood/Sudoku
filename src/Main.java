
/**
 * A simple one board Sudoku player, using JavaFX
 *
 * @author Ibraheem Masood
 * @version 1.2
 * @since 2/3/2022
 */

public class Main {
    public static SudokuGUI gameGUI;
    //an array saving the numbers of the puzzle
    static int[][] sudNumbers = {{5, 2, 7, 9, 4, 1, 8, 6, 3}, {3, 8, 9, 2, 6, 7, 5, 1, 4}, {6, 1, 4, 8, 5, 3, 2, 7, 9}, {4, 3, 1, 5, 2, 9, 6, 8, 7}, {9, 6, 2, 1, 7, 8, 4, 3, 5}, {8, 7, 5, 6, 3, 4, 1, 9, 2}, {7, 5, 8, 3, 1, 2, 9, 4, 6}, {1, 4, 6, 7, 9, 5, 3, 2, 8}, {2, 9, 3, 4, 8, 6, 7, 5, 1}};
    //an array saving whether a given spot has been solved order is (row, col)
    static boolean[][] sudIsSolved = {{false, false, false, true, true, true, false, false, false}, {true, true, false, true, true, true, false, false, true}, {true, false, true, false, false, false, true, false, false}, {false, false, true, false, true, false, false, true, false}, {true, false, true, false, true, true, false, true, false}, {true, false, false, false, true, true, true, false, false}, {false, true, false, true, false, true, false, true, false}, {false, false, true, false, true, true, false, false, true}, {false, false, false, false, true, true, false, true, true}};


    /**
     * Runs helper commands to create a sudoku board
     */
    public static void main(String[] args) {

// I was unsure if Ms.Stusiak wanted us to keep this past step 1, left in just in case
//        for (int i = 0; i <= sudNumbers.length - 1; i++) {
//            for (int j = 0; j <= sudNumbers.length - 1; j++) {
        //if (sudIsSolved[j][i]) {
//                    System.out.print(" " + sudNumbers[j][i] + " ");
        //} else {
        //      System.out.print(" - ");
        //  }
//
//            }
//            System.out.println();
//
//        }
        //Starts up time and game-board
        gameGUI = new SudokuGUI(9);
    }

    /**
     * Checks if the game is won
     */
    public static boolean isWon() {

        for (int row = 0; row < sudNumbers.length; row++) {
            for (int col = 0; col < sudNumbers.length; col++) {
                if (sudNumbers[col][row] != SudokuGUI.buttonArray[col][row].showing && !SudokuGUI.buttonArray[col][row].isShown) {
                    return false;
                }


            }


        }
        return true;
    }
}


