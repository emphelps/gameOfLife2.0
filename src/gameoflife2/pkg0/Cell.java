package gameoflife2.pkg0;

/**
 *
 * @author emphelps
 */
public class Cell {
    
    private boolean state;
    private Location location;
    
    public Cell(boolean state, int row_coordinate, int col_coordinate)
    {
        this.state = state;
        this.location = new Location(row_coordinate, col_coordinate);
    }

    public boolean isAlive() 
    {
        return state;
    }
    
    public void setState(boolean state) 
    {
        this.state = state;
    }

    public Location getLocation() 
    {
        return location;
    }
}
