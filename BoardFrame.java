import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * This frame contains the tic tac toe board and player info text field.
 */
public class BoardFrame extends JFrame
{
    private JLabel turnDisplay;
    private BoardSquare[][] board;
    private int whoseTurn;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;

    public BoardFrame()
    {
        createBoardPanel();

        turnDisplay = new JLabel("PLAYER Os GOES FIRST", 0);
        turnDisplay.setFont(new Font("Serif", 0, 24));
        turnDisplay.repaint();
        add(turnDisplay, BorderLayout.NORTH);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * Creates the board panel with buttons.
     */
    private void createBoardPanel()
    {
        JPanel boardPanel = new JPanel();
        
        final int BOARD_ROW = 3;
        final int BOARD_COL = 3;
        
        whoseTurn = 0;
        board = new BoardSquare[BOARD_ROW][BOARD_COL];
        boardPanel.setLayout(new GridLayout(BOARD_ROW,BOARD_COL));
        
        for (int i = 0; i < BOARD_ROW; i++)
        {
            for (int j = 0; j < BOARD_COL; j++)
            {
                BoardSquare square = new BoardSquare("___", i, j);
                board[i][j] = square;
                boardPanel.add(makeMoveSquare(i, j));
            }
        }
        
        add(boardPanel, BorderLayout.CENTER);
    }

    public JLabel makeMoveSquare(int i, int j)
    {
        JLabel square = new JLabel(board[i][j].getLabel());
        square.setFont(new Font("Serif", 0, 36));
        
        MoveListener listener = new MoveListener(square, i, j);
        square.addMouseListener(listener);
        return square;
    }

    class MoveListener extends MouseAdapter
    {
        private int moveI;
        private int moveJ;
        private JLabel square;

        public MoveListener(JLabel sq, int i, int j)
        {
            moveI = i;
            moveJ = j;
            square = sq;
        }

        /**
         * Changes the turn display label to show which box was clicked.
         */
        public void mousePressed(MouseEvent event)
        {
            turnDisplay.setText("You clicked square: " + moveI + ", " + moveJ);
            
            if (isEmptySpot())
            {
                makeMove();
            }
            else
            {
                turnDisplay.setText("That spot's already taken!");
            }
            
            if (isVictory() == 2)
            {
                turnDisplay.setText("It's a tie!");
            } 
            else if (isVictory() == 0 | isVictory() == 1)
            {
                String winner;
                if (whoseTurn == 0) { winner = "O"; }
                else                { winner = "X"; }
                
                turnDisplay.setText("Player " + winner + "'s wins!");
            }
        }
        
        public boolean isEmptySpot()
        {
            if (board[moveI][moveJ].getLabel().equals("___"))
            { return true; }
            else
            { return false; }
        }
        
        public void makeMove()
        {
            if (whoseTurn == 0)         
            { 
                board[moveI][moveJ].setLabel("O");
                square.setText("O"); 
                whoseTurn = 1;
            }
            else // whoseTurn == 1                   
            { 
                board[moveI][moveJ].setLabel("X");
                square.setText("X"); 
                whoseTurn = 0;
            } 
        }
        
        public int isVictory()
        {
            int victory = 3;
            String currentPlayer = 
            
            return victory;
        }
    }


}