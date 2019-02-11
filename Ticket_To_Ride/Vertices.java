import java.util.ArrayList;
import java.util.Collections;
/**
 * All the possible destinations on the map with their 
 * associating number of meeples
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public enum Vertices {
    DANEMARK(1),

    NIEDERLANDE(1),

    FRANKREICH(1),

    SCHWEIZ(1),

    OSTERREICH(1),

    KIEL(1),

    ROSTOCK(1),
    
    EMDEN(1),

    BREMERHAVEN(1),

    SCHWERIN(1),

    HAMBURG(4),

    BREMEN(1),

    HANNOVER(1),

    BERLIN(5),

    MUNSTER(1),

    MAGDEBURG(1),

    DORTMUND(1),

    KASSEL(1),

    LEIPZIG(3),

    DRESDEN(1),

    DUSSELDORF(1),

    ERFURT(1),

    CHEMNITZ(1),

    KOLN(4),

    FRAKFURT(4),

    KOBLENZ(1),

    MAINZ(1),

    WURZBURG(1),

    NURNBERG(1),

    MANNHEIM(1),

    REGENSBURG(1),

    SAARBRUCKEN(1),

    KARLSRUHE(1),

    STUTTGART(3),

    AUGSBURG(1),

    ULM(1),

    MUNCHEN(4),

    FREIBURG(1),

    KONSTANZ(1),

    LINDAU(1);

    protected ArrayList<MeeplesColor> arr;
     /**
     * Constructs the vertex with the meeples
     * 
     * @param meeple number of meeples.
     * 
     */
    Vertices(int meeple) 
    {
        arr =  new ArrayList<MeeplesColor>();
        for(int i =0; i<meeple; i++)
        {
            arr.add(MeeplesBag.drawMeeple());
        }
    }
  
     /**
     * returns the number of meeples
     * 
     * @return  number of meeples.
     * 
     */
    public int getNumMeeples()
    {
        return arr.size();
    }

     /**
     * returns An arrayList of meeples. 
     * 
     * @return An arrayList of meeples. 
     * 
     */
    public ArrayList<MeeplesColor> getMeeples()
    {
        return arr;
    }

    /**
     * Returns if the arraylist contains a meeple and removes it. 
     * 
     * @param color the color that is going to be removed from the list.
     * 
     * @return A boolean of if the meeple was removed from list 
     * or did not contain it.
     */
    public boolean removeMeeple(MeeplesColor color)
    {
        if(arr.contains(color)){
            arr.remove(color);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * A method that prints out all the meeples in an arrayList. 
     * 
     *
     */
    public void printMeeples()
    {
        for(int i =0; i< arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
    }
}
