package gameoflife2.pkg0;

import java.util.Random;

/**
 *
 * @author emphelps
 */
public class EbolaOutbreak {
    
    private int size;
    
    public EbolaOutbreak(int size)
    {
        this.size = size;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public boolean unexpectedEbolaOutbreak(double ebolaOutbreakChance)
    {
        boolean outbreak = false;
        
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        double toCompare = 1/randomNum;
        if(toCompare == ebolaOutbreakChance)
        {
            outbreak = true;
        }
        
        return outbreak;
    }
    
}
