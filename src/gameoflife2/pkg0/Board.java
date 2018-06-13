/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife2.pkg0;

import java.util.Random;

/**
 *
 * @author emphelps
 */
public class Board {
    
    private Cell[][] gameBoard;
    private Cell[][] gameBoardCopy;
    
    // might not need to keep track of these ?
    private int rowSize;
    private int colSize;
    
    public Board(int rowSize, int colSize)
    {
        // or we could hardcode rowSize and colSize
        this.rowSize = rowSize;
        this.colSize = colSize;
        
        gameBoard = new Cell[rowSize][colSize];
        
        Random rand = new Random();
        for (int i = 0; i < ALIVE_CHANCE; i++) 
        {
            int randomAliveI = rand.nextInt(rowSize);
            int randomAliveJ = rand.nextInt(colSize);

            if (gameBoard[randomAliveI][randomAliveJ].getState()) 
            {
                i--;
            } 
            else 
            {
                gameBoard[randomAliveI][randomAliveJ].setState() = true;
            }
        }
    }
    
    private boolean getCellState(int row, int col)
    {
        gameBoardCopy[row][col].getState();
    }
    
}
