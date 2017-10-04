import java.util.Scanner;

/**
 * This program plays tic tac toe in the console window with the user(s).
 */
public class TicTacToe
{
    public static void main(String[] args)
    {
        // Define the board as an array.
        String[][] board =
        {
           { " ", " ", " " },
           { " ", " ", " " },
           { " ", " ", " " }
        };
        
        int victory = 0;    // will set 1 or -1 for winning player
        int playerTurn = 1; // start with Player Xs
        String playerToken = "";
        
        for (int m = 0; m < 9; m++)     // The board is filled at 9 moves, resulting in a tie!
        {
           // Draw the board in the console.
           for (int i = 0; i < 3; i++)
           {
               System.out.print("\n |---|---|---| \n");            // top border of each row
               for (int j = 0; j < 3; j++)
               {
                   System.out.print(" | " + board[i][j]);          // each cell
               }
               System.out.print(" |");                             // right side of the row
           }
           System.out.println("\n |---|---|---| ");                // bottom border of board
          
           int validMove = 0;
           while (validMove == 0)       // having a valid move breaks the while loop so play continues; otherwise, it asks again
           {
               // Alternate players
               if (playerTurn == 1)    // It's Player 1's turn
               {
                   System.out.println("Player Os, what is your move? row(0-2) col(0-2) : ");
                   playerToken = "O"; 
               }
               else                    // It's Player 2's turn
               {
                   System.out.println("Player Xs, what is your move? row(0-2) col(0-2) : ");
                   playerToken = "X"; 
               }
               
               Scanner in = new Scanner(System.in);
               int playRow = in.nextInt();
               int playCol = in.nextInt();
               
               // too big a row/col call
               if (playRow > 2 || playCol > 2)                              
               { System.out.println("That's off the board! Try again!"); }
               // too small a row/col call
               else if (playRow < 0 || playCol < 0)  
               { System.out.println("That's off the board! Try again!"); }
               // space taken
               else if ( !board[playRow][playCol].equals(" ") )
               { System.out.println("That space is already taken! Try again!"); }
               else // should be valid move otherwise
               { 
                   board[playRow][playCol] = playerToken; 
                   validMove = 1;
               }
           }
           
           // Check for victory
           // Rows
           for (int i = 0; i < 3; i++)
           {
               if ( board[i][0].equals(playerToken)         // left 
                    && board[i][1].equals(playerToken)      // center
                    && board[i][2].equals(playerToken) )    // right
               {
                   victory = playerTurn;
               }
           }
              
           // Columns
           for (int j = 0; j < 3; j++)
           {
               if ( board[0][j].equals(playerToken)         // top 
                    && board[1][j].equals(playerToken)      // center
                    && board[2][j].equals(playerToken) )    // bottom
               {
                   victory = playerTurn;
               }
           }
           
           // Upper left to lower right diagonal
           if ( board[0][0].equals(playerToken)             // upper left
                && board[1][1].equals(playerToken)          // center
                && board[2][2].equals(playerToken) )        // lower left
           {
               victory = playerTurn;
           }
           
           // Lower left to upper right diagonal
           if ( board[2][0].equals(playerToken)             // lower left
                && board[1][1].equals(playerToken)          // center
                && board[0][2].equals(playerToken) )        // upper left
           {
               victory = playerTurn;
           }
            
           if (victory != 0)    { break; }    
           else                 { playerTurn = playerTurn * -1; }
        }
        
        // Print the final board
        for (int i = 0; i < 3; i++)
        {
           System.out.print("\n |---|---|---| \n");            // top border of each row
           for (int j = 0; j < 3; j++)
           {
               System.out.print(" | " + board[i][j]);          // each cell
           }
           System.out.print(" |");                             // right side of the row
        }
        System.out.println("\n |---|---|---| ");                // bottom border of board
            
        // Pronounce the winner
        if (victory == 1)           { System.out.println("Player Os wins!"); }
        else if (victory == -1)     { System.out.println("Player Xs wins!"); }
        else                        { System.out.println("It's a tie!"); }
    }
}