package gameoflife2.pkg0;

import java.util.Random;
/**
 *
 * @author emphelps
 */
public class Board {
    
    private Cell[][] gameBoard;
    private Cell[][] gameBoardCopy;
    
    private int rowSize;
    private int colSize;
    
    private int aliveChance;
    
    private String boardContents;
    
    public Board(int rowSize, int colSize, int aliveChance)
    {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.aliveChance = aliveChance;
        
        initializeGameBoard();
    }
    
    private void initializeGameBoard()
    {
        gameBoard = new Cell[rowSize][colSize];
        
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                gameBoard[i][j] = new Cell(false, i, j);
            }
        }
        
        Random rand = new Random();
        
        for(int i = 0; i < aliveChance; i++)
        {
            int randomAliveRowIndex = rand.nextInt(rowSize);
            int randomAliveColIndex = rand.nextInt(colSize);
            
            if(gameBoard[randomAliveRowIndex][randomAliveColIndex].isAlive())
            {
                i--;
            }
            else
            {
                gameBoard[randomAliveRowIndex][randomAliveColIndex].setState(true);
            }
        }
        
        gameBoardCopy = gameBoard;
    }
    
    private boolean calculateNextStateOfCell(int row, int col)
    {
        int aliveNeighborCount = calculateAliveNeighborsOfCell(row, col);
        
        boolean tempState = false;
        
        if (gameBoardCopy[row][col].isAlive()) 
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
                
                if(j < 0 || j >= colSize) continue;
                
                if(gameBoardCopy[i][j].isAlive())
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
                boardContents += (gameBoard[i][j].isAlive() ? "*" : " ");
            }
            boardContents += "\n";
        }
    }
    
    public String getBoardContents()
    {
        return boardContents;
    }
    
    public void resetGameBoardCopy()
    {
        gameBoardCopy = gameBoard;
    }
    
    public void setGameBoardCellState(int row, int col, boolean state)
    {
        gameBoard[row][col].setState(state);
    }
}
