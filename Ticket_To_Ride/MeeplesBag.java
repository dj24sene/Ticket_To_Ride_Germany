import java.util.ArrayList;
import java.util.Collections;
/**
 * A collection of meeples to be dispersed across the map
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class MeeplesBag
{
    protected static ArrayList<MeeplesColor> temp;
    
    /**
     * Constructs a MeeplesBag Object
     */
    public MeeplesBag()
    {
        temp = new ArrayList<MeeplesColor>();
        for (int i =0; i < 10; i++)
        {
            temp.add(MeeplesColor.RED);
            temp.add(MeeplesColor.GREEN);
            temp.add(MeeplesColor.YELLOW);
            temp.add(MeeplesColor.BLACK);
            temp.add(MeeplesColor.BLUE);
            temp.add(MeeplesColor.WHITE);
        }
    }
    
    private static MeeplesBag arr = new MeeplesBag();
     /**
     * Draws a meeple from the MeeplesBag
     * 
     * @return the color of the meeple that has been removed.
     */
    public static MeeplesColor drawMeeple()
    {
        int ticIndex = (int) Math.floor(Math.random()*arr.temp.size());
        MeeplesColor removed  = arr.temp.remove(ticIndex);
        return removed;
    }
}
