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
        double EBOLA_OUTBREAK_CHANCE = .3;//0.00000007;
        
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
