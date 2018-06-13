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
        
        if((Math.random()/10000000) < ebolaOutbreakChance)
        {
            outbreak = true;
        }
        
        return outbreak;
    }
    
}
