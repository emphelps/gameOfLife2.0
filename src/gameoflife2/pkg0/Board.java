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
    
    private String boardContents;
    
    // might not need to keep track of these ?
    private int rowSize;
    private int colSize;
    private int ALIVE_CHANCE;
    
    public Board(int rowSize, int colSize, int ALIVE_CHANCE)
    {
        // or we could hardcode rowSize and colSize
        this.rowSize = rowSize;
        this.colSize = colSize;
        
        this.ALIVE_CHANCE = ALIVE_CHANCE;
        
        gameBoard = new Cell[rowSize][colSize];
        
        Random rand = new Random();
        for (int i = 0; i < ALIVE_CHANCE; i++) 
        {
            int randomAliveI = rand.nextInt(rowSize);
            int randomAliveJ = rand.nextInt(colSize);

            if (gameBoard[randomAliveI][randomAliveJ].isState()) 
            {
                i--;
            } 
            else 
            {
                gameBoard[randomAliveI][randomAliveJ].setState(true);
            }
        }
        
        gameBoardCopy = gameBoard;
    }
    
    public Cell[][] getGameBoard() 
    {
        return gameBoard;
    }

    public Cell[][] getGameBoardCopy() 
    {
        return gameBoardCopy;
    }
    
    private boolean calculateCellState(int row, int col) 
    {
        int aliveNeighborCount = calculateAliveNeighborsOfCell(row, col);
        
        boolean tempState = false;
        if (gameBoardCopy[row][col].isState()) 
        {
            switch (aliveNeighborCount) 
            {
                case 2:
                case 3:
                    tempState = true;
                    break;
            }
        } 
        else 
        {
            if (aliveNeighborCount == 3) 
            {
                tempState = true;
            }
        }
        
        return tempState;
    }
    
    private int calculateAliveNeighborsOfCell(int row, int col)
    {
        int aliveCount = 0;
        
        for(int i = row - 1; i < row + 2 ; i++)
        {
            for(int j = col - 1; j < col + 2 ; j++)
            {
                if(row == i && col == j) continue;
                
                if(i < 0 || i >= rowSize) continue;
                
                if(j < 0 || j >= rowSize) continue;
                
                if(gameBoardCopy[i][j].isState())
                {
                    aliveCount++;
                }
            }
        }
        
        return aliveCount;
    }
    
    private void generateBoardContents()
    {
        for (int i = 0; i < rowSize; i++) 
        {
            for (int j = 0; j < colSize; j++) 
            {
                boardContents += (gameBoard[i][j].isState() ? "*" : " ");
            }
            boardContents += "\n";
        }
    }
    
//    private void printBoard()
//    {
//        
//    }
}
