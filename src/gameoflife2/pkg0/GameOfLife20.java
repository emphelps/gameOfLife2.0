package gameoflife2.pkg0;

import java.util.*;
/**
 *
 * @author emphelps
 */
public class GameOfLife20 {
    
    public static void main(String[] args) 
    {
        int ROW_SIZE = 40;
        int COL_SIZE = 40;
        final int PAUSE_MILLIS = 1000;
    
        int ALIVE_CHANCE = (int)(.3 * (ROW_SIZE * COL_SIZE));
        double EBOLA_OUTBREAK_CHANCE = 0.2;
        
        Board board = new Board(ROW_SIZE, COL_SIZE, ALIVE_CHANCE);
        
        while(true)
        {
            board.runGame(EBOLA_OUTBREAK_CHANCE);
            System.out.println(board);
            
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
