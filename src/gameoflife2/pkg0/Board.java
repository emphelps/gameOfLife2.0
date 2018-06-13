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
        boolean tempState = false;
        
        return tempState;
    }
}
