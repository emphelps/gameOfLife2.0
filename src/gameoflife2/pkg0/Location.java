/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife2.pkg0;

/**
 *
 * @author emphelps
 */
public class Location {
    
    private int row;
    private int col;
    
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() 
    {
        return row;
    }

    public int getCol() 
    {
        return col;
    }
    
}
