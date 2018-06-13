package gameoflife2.pkg0;

import java.util.*;
/**
 *
 * @author emphelps
 */
public class GameOfLife20 {
    
    static int ROW_SIZE = 20;
    static int COL_SIZE = 20;
    static final int PAUSE_MILLIS = 1000;
    
    static int ALIVE_CHANCE = (int)(.3 * (ROW_SIZE * COL_SIZE));


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
                    //newBoard[i][j] = calculateState(board, boardCopy, i, j);
                    //newBoard.setGameBoardCell(i, j, (calculateCellState(i, j, newBoardCopy)));
                }
            }
            
            //System.out.println(newBoard.getBoardContents());
            
            try
            {
                Thread.sleep(PAUSE_MILLIS);
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
    
//    private static boolean calculateCellState(int row, int col, Board newBoardCopy) 
//    {
//        int aliveNeighborCount = calculateAliveNeighborsOfCell(newBoardCopy, row, col);
//        
//        boolean tempState = false;
//        if (newBoardCopy.getGameBoardCopy()[row][col].isState()) 
//        {
//            switch (aliveNeighborCount) 
//            {
//                case 2:
//                case 3:
//                    tempState = true;
//                    break;
//            }
//        } 
//        else 
//        {
//            if (aliveNeighborCount == 3) 
//            {
//                tempState = true;
//            }
//        }
//        
//        return tempState;
//    }
//    
//    private static int calculateAliveNeighborsOfCell(Board newBoardCopy, int row, int col) 
//    {
//        int aliveCount = 0;
//        
//        for(int i = row - 1; i < row + 2 ; i++)
//        {
//            for(int j = col - 1; j < col + 2 ; j++)
//            {
//                if(row == i && col == j) continue;
//                
//                if(i < 0 || i >= ROW_SIZE) continue;
//                
//                if(j < 0 || j >= COL_SIZE) continue;
//                
//                if(newBoardCopy.getGameBoardCopy()[i][j].isState())
//                {
//                    aliveCount++;
//                }
//            }
//        }
//        
//        return aliveCount;
//    }
//    
}
