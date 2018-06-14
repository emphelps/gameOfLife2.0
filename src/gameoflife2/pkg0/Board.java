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
    private boolean stable;
    
    public Board(int rowSize, int colSize, int aliveChance)
    {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.aliveChance = aliveChance;
        
        stable = false;
        
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
    
    public boolean calculateNextStateOfCell(int row, int col)
    {
        int aliveNeighborCount = calculateAliveNeighborsOfCell(row, col);
        
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
                
                if(gameBoard[i][j].isAlive())
                {
                    aliveCount++;
                }
            }
        }
        
        return aliveCount;
    }
    
    @Override
    public String toString()
    {
        String boardContents = "";
        
        if(stable)
        {
            boardContents += "Stable!! \n";
        }
        
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
    
    public void runGame(double ebolaOutbreakChance, double stabilityMeasurement)
    {
        Cell[][] tempGameBoard = new Cell[rowSize][colSize];
        EbolaOutbreak ebolaOutbreak = new EbolaOutbreak(100);
        
        stable = false;
        
        for (int i = 0; i < rowSize; i++) 
            {
                for (int j = 0; j < colSize; j++) 
                {
                    tempGameBoard[i][j] = new Cell((calculateNextStateOfCell(i, j)), i, j);
                }
            }
        
        gameBoard = tempGameBoard;
        
        if(ebolaOutbreak.unexpectedEbolaOutbreak(ebolaOutbreakChance))
        {
            int beforeOutbreakAliveCount = checkStability();
            
            Random rand = new Random();
            int randomRow = rand.nextInt(rowSize);
            int randomCol = rand.nextInt(colSize);
            ebolaOutbreak(randomRow, randomCol, ebolaOutbreak.getSize());
            
            int afterOutbreakAliveCount = checkStability();
            
            if(afterOutbreakAliveCount >= (beforeOutbreakAliveCount * stabilityMeasurement))
            {
                stable = true;
            }
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
    
    private int checkStability()
    {
        int aliveCount = 0;
        
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                if(gameBoard[i][j].isAlive())
                {
                    aliveCount++;
                }
            }
        }
        
        return aliveCount;
    }
}
