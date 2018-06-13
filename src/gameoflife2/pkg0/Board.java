package gameoflife2.pkg0;

import java.util.Random;
/**
 *
 * @author emphelps
 */
public class Board {
    
    private Cell[][] gameBoard;
    
    private int rowSize;
    private int colSize;
    
    private int aliveChance;
    
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
        
    }
    
    public boolean calculateNextStateOfCell(int row, int col, Cell[][] tempGameBoard)
    {
        int aliveNeighborCount = calculateAliveNeighborsOfCell(row, col, tempGameBoard);
        
        boolean tempState = false;
        
        if (gameBoard[row][col].isAlive()) 
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
    
    private int calculateAliveNeighborsOfCell(int row, int col, Cell[][] tempGameBoard)
    {
        int aliveCount = 0;
        
        for(int i = row - 1; i < row + 2 ; i++)
        {
            for(int j = col - 1; j < col + 2 ; j++)
            {
                if(row == i && col == j) continue;
                
                if(i < 0 || i >= rowSize) continue;
                
                if(j < 0 || j >= colSize) continue;
                
                if(gameBoard[i][j].isAlive())
                {
                    aliveCount++;
                }
            }
        }
        
        return aliveCount;
    }
    
    public String toString()
    {
        String boardContents = "";
        for (int i = 0; i < rowSize; i++) 
        {
            for (int j = 0; j < colSize; j++) 
            {
                boardContents += (gameBoard[i][j].isAlive() ? "*" : " ");
            }
            boardContents += "\n";
        }
        
        return boardContents;
    }
    
    public void runGame(double ebolaOutbreakChance)
    {
        Cell[][] tempGameBoard = new Cell[rowSize][colSize];
        EbolaOutbreak ebolaOutbreak = new EbolaOutbreak(9);
        for (int i = 0; i < rowSize; i++) 
            {
                for (int j = 0; j < colSize; j++) 
                {
                    tempGameBoard[i][j] = new Cell((calculateNextStateOfCell(i, j, tempGameBoard)), i, j);
                }
            }
        
        gameBoard = tempGameBoard;
        
        if(ebolaOutbreak.unexpectedEbolaOutbreak(ebolaOutbreakChance))
        {
            Random rand = new Random();
            int randomRow = rand.nextInt(rowSize);
            int randomCol = rand.nextInt(colSize);
            ebolaOutbreak(randomRow, randomCol, ebolaOutbreak.getSize());
        }
    }
    
    public void ebolaOutbreak(int row, int col, int ebolaSize)
    {
        int startIndex = (int)Math.sqrt(ebolaSize)/2;
        int endIndex = (int)Math.sqrt(ebolaSize) - startIndex;
        
        System.out.println("EBOLA OUTBREAK!!");
        
        for(int i = row - startIndex; i < row + endIndex ; i++)
        {
            for(int j = col - startIndex; j < col + endIndex; j++)
            {
                if(i < 0 || i >= rowSize) continue;
                
                if(j < 0 || j >= colSize) continue;
                
                gameBoard[i][j].setState(false);
            }
        }
    }
}
