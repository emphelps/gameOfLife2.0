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
        //double EBOLA_OUTBREAK_CHANCE = 0.00000007;
        
        Board newBoard = new Board(ROW_SIZE, COL_SIZE, ALIVE_CHANCE);
        
        while(true)
        {
            newBoard.resetGameBoardCopy();
//            if(unexpectedEbolaOutbreak(EBOLA_OUTBREAK_CHANCE))
//            {
//                
//            }
            
            newBoard.runGame();
            System.out.println(newBoard);
            
            try
            {
                Thread.sleep(PAUSE_MILLIS);
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
    
//    public static boolean unexpectedEbolaOutbreak(double ebolaOutBreakChance)
//    {
//        boolean outbreak = false;
//        
//        Random rand = new Random();
//        double num = rand.nextDouble();
//        
//        return outbreak;
//    }
}
