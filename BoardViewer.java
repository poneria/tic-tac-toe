import javax.swing.JFrame;

/**
 * This program displays the tic tac toe game and board.
 */
public class BoardViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new BoardFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}