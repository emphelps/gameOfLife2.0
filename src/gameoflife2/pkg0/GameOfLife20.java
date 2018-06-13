package gameoflife2.pkg0;

/**
 *
 * @author emphelps
 */
public class GameOfLife20 {
    
    private static int ROW_SIZE = 20;
    private static int COL_SIZE = 20;
    private static final int PAUSE_MILLIS = 1000;
    
    private static int ALIVE_CHANCE = (int)(.3 * (ROW_SIZE * COL_SIZE));


    public static void main(String[] args) {
        Board newBoard = new Board(ROW_SIZE, COL_SIZE, ALIVE_CHANCE);
        Board newBoardCopy;
        
        while(true)
        {
            newBoardCopy = newBoard;
            for (int i = 0; i < ROW_SIZE; i++) 
            {
                for (int j = 0; j < COL_SIZE; j++) 
                {
                    newBoard[i][j] = calculateState(board, boardCopy, i, j);
                }
            }
            
            System.out.println(newBoard.getBoardContents());
            
            try
            {
                Thread.sleep(PAUSE_MILLIS);
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
    
}
