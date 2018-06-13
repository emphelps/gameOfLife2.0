package gameoflife2.pkg0;

import java.util.*;
/**
 *
 * @author emphelps
 */
public class GameOfLife20 {
    
    public static void main(String[] args) 
    {
        int ROW_SIZE = 20;
        int COL_SIZE = 20;
        final int PAUSE_MILLIS = 1000;
    
        int ALIVE_CHANCE = (int)(.3 * (ROW_SIZE * COL_SIZE));
        Board newBoard = new Board(ROW_SIZE, COL_SIZE, ALIVE_CHANCE);
        
        while(true)
        {
            newBoard.resetGameBoardCopy();
            for (int i = 0; i < ROW_SIZE; i++) 
            {
                for (int j = 0; j < COL_SIZE; j++) 
                {
                    newBoard.setGameBoardCellState(i, j, (newBoard.calculateNextStateOfCell(i, j)));
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
